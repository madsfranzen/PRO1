package model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Vagt {
    private String navn;
    private LocalDateTime tidFra;
    private LocalDateTime tidTil;
    private ArrayList<Medarbejder> medarbejdere = new ArrayList<>();
    private ArrayList<Antal> antal = new ArrayList<>();

    public Vagt(String navn, LocalDateTime tidFra, LocalDateTime tilTil) {
        this.navn = navn;
        this.tidFra = tidFra;
        this.tidTil = tilTil;
    }

    public String status(Funktion funktion, int antalPåkrævet) {
        int i = 0;
        int antalFundet = 0;
        Medarbejder m = null;
        while (antalFundet != antalPåkrævet && i < medarbejdere.size()) {
            Medarbejder mSøg = (Medarbejder) medarbejdere.get(i);
            if (mSøg.getFunktioner().contains(funktion)) {
                antalFundet++;
            } else i++;
        }
        if (antalFundet == antalPåkrævet) {
            return "Ressourcer tildelt";
        } else return "Manlgende resourcer";
    }

    public Medarbejder[] skalAdviseresOmMødetid() {
        ArrayList<Medarbejder> medarbejdereTempList = new ArrayList<>();
        int antal = 0;
        for (Medarbejder m : medarbejdere) {
            if (m.getTypiskMødetid().isAfter(tidFra.toLocalTime())) {
                antal++;
                medarbejdereTempList.add(m);
            }
        }
        Medarbejder[] medarbejdereSkalAdviseres = new Medarbejder[antal];
        for (int i = 0; i < medarbejdereTempList.size(); i++) {
            medarbejdereSkalAdviseres[i] = medarbejdereTempList.get(i);
        }
        return medarbejdereSkalAdviseres;
    }

    public int antalMedarbejdereMedFunktion(Funktion funktion) {
        int antalMedarbejdere = 0;
        for (Medarbejder m : medarbejdere) {
            if (m.getFunktioner().contains(funktion)) {
                antalMedarbejdere++;
            }
        }
        return antalMedarbejdere;
    }

    public int beregnTimeforbrug() {
        int samletTimeforbrug = 0;
        int varighed = tidTil.getHour() - tidFra.getHour();
        return samletTimeforbrug;
    }

    /**
     * Return value NULLABLE
     */
    public Medarbejder findMedarbejder(LocalTime tidspunkt, int antalTimer) {
        Medarbejder medarbejder = null;
        for (Medarbejder m : medarbejdere) {
            if (m.getTypiskMødetid().equals(tidspunkt) && m.getAntalTimerPrDag() >= antalTimer) {
                medarbejder = m;
            }
        }
        return medarbejder;
    }

    public void tilføjAntal(Antal antal) {
        this.antal.add(antal);
    }

    public void fjernAntal(Antal antal) {
        this.antal.remove(antal);
    }

    public String getNavn() {
        return navn;
    }

    public LocalDateTime getTidFra() {
        return tidFra;
    }

    public LocalDateTime getTidTil() {
        return tidTil;
    }

    public ArrayList<Medarbejder> getMedarbejdere() {
        return medarbejdere;
    }

    public ArrayList<Antal> getAntal() {
        return antal;
    }
}
