package controller;

import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static int samletBooketDoubleTid(String uddannelse, Kategori kategori) {
        int samletTid = 0;
        // Finder først alle relevante Spillere
        ArrayList<Spiller> spillerePåUddannelsen = new ArrayList<>();
        for (Spiller spiller : Storage.getSpillere()) {
            if (spiller.getUddannelse().equals(uddannelse)) {
                spillerePåUddannelsen.add(spiller);
            }
        }
        // Tjekker de relevante Spillere for Double Tider
        for (Spiller spiller : spillerePåUddannelsen) {
            for (Booking booking : spiller.getBookinger()) {
                if (!booking.isSingle()) {
                    samletTid++;
                }
            }
        }
        return samletTid;
    }

    /**
     * Kan returnere null
     */
    public static Bane findLedigBane(LocalDate dato, LocalTime tid, Kategori kategori) {
        Bane ledigBane = null;
        int i = 0;
        while (ledigBane == null && i < Storage.getBaner().size()) {
            Bane bane = Storage.getBaner().get(i);
            if (bane.getKategori().equals(kategori)) {
                if (bane.tidLedig(dato, tid)) {
                    ledigBane = bane;
                }
            }
            i++;
        }

        return ledigBane;
    }

    public static void printAlleBookings(String filNavn) {
        File file = new File(filNavn);
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Bane bane : Storage.getBaner()) {
                for (Booking booking : bane.getBookinger()) {
                    writer.print("Bane nr: " + bane.getNummer());
                    writer.print(", dag: " + booking.getDato());
                    writer.print(" kl. " + booking.getTid());
                    writer.print(", spil: ");
                    if (booking.isSingle()) {
                        writer.print("single");
                    } else {
                        writer.print("double");
                    }
                    writer.print(", spiller: " + booking.getSpiller());
                    writer.println("");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fil ikke fundet!");
        }
    }

    public static Spiller opretSpiller(String navn, String uddannelse) {
        Spiller spiller = new Spiller(navn, uddannelse);
        Storage.storeSpiller(spiller);
        return spiller;
    }

    public static Kategori opretKategori(String navn, int prisKrSingle, int prisKrDouble) {
        Kategori kategori = new Kategori(navn, prisKrSingle, prisKrDouble);
        Storage.storeKategori(kategori);
        return kategori;
    }

    public static Bane opretBane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori) {
        Bane bane = new Bane(nummer, inde, førsteTid, sidsteTid, kategori);
        Storage.storeBane(bane);
        return bane;
    }

    public static Booking opretBooking(LocalDate dato, LocalTime tid, boolean single, Spiller spiller, Bane bane) {
        Booking booking = new Booking(dato, tid, single, spiller, bane);
        spiller.tilføjBooking(booking);
        bane.tilføjBooking(booking);
        return booking;
    }

    public static ArrayList<Bane> getBaner() {
        return Storage.getBaner();
    }

    public static ArrayList<Spiller> getSpillere() {
        return Storage.getSpillere();
    }
}
