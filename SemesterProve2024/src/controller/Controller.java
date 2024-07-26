package controller;

import model.Badge;
import model.Deltager;
import model.Hold;
import model.Tur;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Hold opretHold(String navn) {
        Hold hold = new Hold(navn);
        Storage.tilføjHold(hold);
        return hold;
    }

    public static ArrayList<Hold> getAlleHold() {
        return Storage.getAlleHold();
    }

    public static ArrayList<Deltager> getDeltagerePåHold(Hold hold) {
        return hold.getDeltagere();
    }

    public static ArrayList<Tur> getTureForDeltager(Deltager deltager) {
        return deltager.getTure();
    }

    public static Deltager opretDeltager(String navn, String mobil, Hold hold) {
        Deltager deltager = new Deltager(navn, mobil);
        hold.tilføjDeltager(deltager);
        return deltager;
    }

    public static Tur opretTur(LocalDate dato, int antalMinutter, int antalKm, Deltager deltager) {
        Tur tur = new Tur(dato, antalMinutter, antalKm, deltager);
        deltager.tilføjTur(tur);
        return tur;
    }

    public static Badge opretBadge(String beskrivelse) {
        Badge badge = new Badge(beskrivelse);
        Storage.tilføjBadge(badge);
        return badge;
    }

    public static void tilføjBadgeTilDeltager(Badge badge, Deltager deltager) {
        badge.tilføjDeltager(deltager);
        deltager.tilføjBadge(badge);
    }

    public static ArrayList<String> deltagerOversigtHold(Hold hold) {
        ArrayList<String> stringList = new ArrayList<>();
        for (Deltager deltager : hold.getDeltagere()) {
            StringBuilder sb = new StringBuilder();
            sb.append(deltager.getNavn() + " ");
            sb.append(deltager.getMobil() + ", ");
            sb.append(deltager.kmIAlt() + " km, ");
            if (deltager.getBadges().isEmpty()) {
                sb.append("- ingen badges -");
            } else {
                sb.append("badges: ");
                for (Badge badge : deltager.getBadges()) {
                    sb.append(badge + ", ");
                }
            }
            stringList.add(sb.toString());
        }
        return stringList;
    }

    public static void udskrivDeltagerOversigt(String filNavn) {
        File file = new File(filNavn);
        try (PrintWriter pw = new PrintWriter(file)) {
            for (Hold hold : Storage.getAlleHold()) {
                pw.println("Hold: " + hold.getNavn());
                if (hold.getDeltagere().isEmpty()) {
                    pw.println(" - ingen deltagere - ");
                } else {
                    ArrayList<Deltager> deltagereSorted = new ArrayList<>(hold.getDeltagere());
                    deltagereSorted.sort(Deltager::compareTo);
                    Hold sorteretHold = new Hold("");
                    for (Deltager d : deltagereSorted) {
                        sorteretHold.tilføjDeltager(d);
                    }
                    for (String str : deltagerOversigtHold(sorteretHold)) {
                        pw.println(str);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fil for udskrift ikke fundet!");
        }
    }
}
