package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    public LocalDate dato;
    private final LocalTime tid;
    private final boolean single;
    private Spiller spiller;
    private final Bane bane;

    public Booking(LocalDate dato, LocalTime tid, boolean single, Spiller spiller, Bane bane) {
        this.dato = dato;
        this.tid = tid;
        this.single = single;
        this.spiller = spiller;
        this.bane = bane;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSpiller(Spiller spiller) {
        this.spiller = spiller;
    }

    public Bane getBane() {
        return bane;
    }

    public Spiller getSpiller() {
        return spiller;
    }

    @Override
    public String toString() {
        String single;
        if (isSingle()) {
            single = "single";
        } else single = "double";

        return dato +
                " kl. " + tid +
                ", " + single +
                ", bane nr. " + bane.getNummer() +
                ", " + spiller.getNavn();
    }
}
