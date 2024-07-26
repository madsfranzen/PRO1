package model;

import java.util.ArrayList;

public class Deltager implements Comparable<Deltager> {
    private String navn;
    private String mobil;
    private final ArrayList<Tur> ture = new ArrayList<>();
    private final ArrayList<Badge> badges = new ArrayList<>();

    public Deltager(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public int kmIAlt() {
        int samletAntalKm = 0;
        for (Tur tur : ture) {
            samletAntalKm += tur.getAntalKm();
        }
        return samletAntalKm;
    }

    public int minutterIAlt() {
        int minutterIAlt = 0;
        for (Tur tur : ture) {
            minutterIAlt += tur.getAntalMinutter();
        }
        return minutterIAlt;
    }

    public void tilføjTur(Tur tur) {
        this.ture.add(tur);
    }

    public void fjernTur(Tur tur) {
        this.ture.remove(tur);
    }

    public void tilføjBadge(Badge badge) {
        this.badges.add(badge);
    }

    public void fjernBadge(Badge badge) {
        this.badges.remove(badge);
    }

    public ArrayList<Badge> getBadges() {
        return badges;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public ArrayList<Tur> getTure() {
        return ture;
    }

    @Override
    public String toString() {
        return navn + ", mobil: " + mobil;
    }

    @Override
    public int compareTo(Deltager o) {
        int compare = this.navn.compareToIgnoreCase(o.navn);
        if (compare == 0) {
            compare = this.mobil.compareTo(o.mobil);
        }
        return compare;
    }
}
