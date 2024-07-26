package model;

import java.util.ArrayList;

public class Salg implements Comparable<Salg> {
    private String købersNavn;
    private int aftaltSamletPris;
    private final ArrayList<Vare> varer = new ArrayList<>();

    public Salg(String købersNavn, int aftaltSamletPris, ArrayList<Vare> varer) {
        this.købersNavn = købersNavn;
        this.aftaltSamletPris = aftaltSamletPris;
        for (Vare vare : varer) {
            this.varer.add(vare);
            vare.isSolgt();
        }
    }

    public String getKøbersNavn() {
        return købersNavn;
    }

    public int getAftaltSamletPris() {
        return aftaltSamletPris;
    }

    public ArrayList<Vare> getVarer() {
        return varer;
    }

    @Override
    public int compareTo(Salg o) {
        return købersNavn.compareTo(o.købersNavn);
    }
}
