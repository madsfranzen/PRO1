package model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Medarbejder {
    private String navn;
    private int antalTimerPrDag;
    private LocalTime typiskMødetid;
    private ArrayList<Funktion> funktioner = new ArrayList<>();
    private ArrayList<Vagt> vagter = new ArrayList<>();

    public Medarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        this.navn = navn;
        this.antalTimerPrDag = antalTimerPrDag;
        this.typiskMødetid = typiskMødetid;
    }

    public void tilføjFunktion(Funktion funktion) {
        this.funktioner.add(funktion);
    }

    public void fjernFunktion(Funktion funktion) {
        this.funktioner.remove(funktion);
    }

    public String getNavn() {
        return navn;
    }

    public int getAntalTimerPrDag() {
        return antalTimerPrDag;
    }

    public LocalTime getTypiskMødetid() {
        return typiskMødetid;
    }

    public ArrayList<Funktion> getFunktioner() {
        return funktioner;
    }

    public ArrayList<Vagt> getVagter() {
        return vagter;
    }

    public void tilføjVagt(Vagt vagt) throws RuntimeException {
        if (1 == 1) {
            throw new RuntimeException("LALALA");
        }

    }
}
