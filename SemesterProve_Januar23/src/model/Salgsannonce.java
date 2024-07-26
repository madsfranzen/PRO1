package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salgsannonce {
    private static int antalAnnoncer = 1;
    private final int annonceNummer;
    private boolean aktiv = true;
    private final LocalDate udløbsDato;
    private final Sælger sælger;
    private final ArrayList<Vare> varer = new ArrayList<>();

    public Salgsannonce(Sælger sælger, ArrayList<Vare> varer) {
        this.annonceNummer = antalAnnoncer++;
        this.udløbsDato = LocalDate.now().plusMonths(1);
        this.sælger = sælger;
        this.varer.addAll(varer);
    }

    public int samletAnnonceUdbud() {
        int samletBeløb = 0;
        for (Vare vare : varer) {
            samletBeløb += vare.getUdbudspris();
        }
        return samletBeløb;
    }

    public void refreshAnnonce() {
        System.out.println("REFRESHING");
        if (LocalDate.now().isAfter(this.udløbsDato)) {
            this.aktiv = false;
        } else {
            if (alleVareSolgte()) {
                System.out.println("ALT ER SOLGT");
                this.aktiv = false;
            }
        }
    }

    public boolean alleVareSolgte() {
        boolean altSolgt = true;
        for (Vare vare : varer) {
            if (!vare.isSolgt()) {
                altSolgt = false;
            }
        }
        return altSolgt;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public Sælger getSælger() {
        return sælger;
    }

    public ArrayList<Vare> getVarer() {
        return varer;
    }

    public static int getAntalAnnoncer() {
        return antalAnnoncer;
    }

    public int getAnnonceNummer() {
        return annonceNummer;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public LocalDate getUdløbsDato() {
        return udløbsDato;
    }

    @Override
    public String toString() {
        return annonceNummer + " " + sælger.getNavn() + " " + udløbsDato;
    }
}
