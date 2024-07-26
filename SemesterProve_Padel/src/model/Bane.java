package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {
    private final int nummer;
    private final boolean inde;
    private final LocalTime førsteTid;
    private final LocalTime sidsteTid;
    private final Kategori kategori;
    private final ArrayList<Booking> bookinger = new ArrayList<>();

    public Bane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori) {
        this.nummer = nummer;
        this.inde = inde;
        this.førsteTid = førsteTid;
        this.sidsteTid = sidsteTid;
        this.kategori = kategori;
    }

    public int bookedeTimerPåDato(LocalDate dato) {
        int antalTimer = 0;
        for (Booking booking : bookinger) {
            if (booking.getDato().equals(dato)) {
                antalTimer++;
            }
        }
        return antalTimer;
    }

    public int[] antalBookingerPrTime() {
        int antalTimer = sidsteTid.getHour() - førsteTid.getHour();
        int[] antalBookingerPrTime = new int[antalTimer];

        for (Booking booking : bookinger) {
            int time = booking.getTid().getHour() - førsteTid.getHour();
            antalBookingerPrTime[time]++;
        }

        return antalBookingerPrTime;
    }

    public boolean tidLedig(LocalDate dato, LocalTime tid) {
        boolean ledig = true;
        int i = 0;
        while (ledig && i < bookinger.size()) {
            Booking booking = bookinger.get(i);
            if (booking.getDato().equals(dato) && booking.getTid().equals(tid)) {
                ledig = false;
            } else {
                i++;
            }
        }
        return ledig;
    }

    public ArrayList<Booking> getBookinger() {
        return new ArrayList<>(bookinger);
    }

    public void tilføjBooking(Booking booking) {
        bookinger.add(booking);
    }

    public int getNummer() {
        return nummer;
    }

    public boolean isInde() {
        return inde;
    }

    public LocalTime getFørsteTid() {
        return førsteTid;
    }

    public LocalTime getSidsteTid() {
        return sidsteTid;
    }

    public Kategori getKategori() {
        return kategori;
    }

    @Override
    public String toString() {
        String inde;
        if (this.inde) {
            inde = "inde";
        } else inde = "ude";
        return
                "Nr. " + nummer +
                        " " + inde +
                        " (" + førsteTid +
                        " -> " + sidsteTid +
                        "), " + kategori;
    }
}
