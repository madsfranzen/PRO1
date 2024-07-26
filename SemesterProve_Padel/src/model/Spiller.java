package model;

import java.util.ArrayList;

public class Spiller {

    private final String navn;
    private final String uddannelse;
    private final ArrayList<Booking> bookinger = new ArrayList<>();

    public Spiller(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
    }

    public void tilføjBooking(Booking booking) {
        bookinger.add(booking);
    }

    public double samletPris(Kategori kategori) {
        double samletPris = 0;
        for (Booking booking : bookinger) {
            Kategori bookingKategori = booking.getBane().getKategori();
            if (bookingKategori.equals(kategori)) {
                if (booking.isSingle()) {
                    samletPris += bookingKategori.getPrisKrSingle();
                } else {
                    samletPris += bookingKategori.getPrisKrDouble();
                }
            }
        }
        return samletPris;
    }

    public ArrayList<Booking> getBookinger() {
        return new ArrayList<Booking>(bookinger);
    }

    public String getNavn() {
        return navn;
    }

    public String getUddannelse() {
        return uddannelse;
    }

    @Override
    public String toString() {
        return navn + " (" + uddannelse + ")";
    }
}
