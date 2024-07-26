package model;

import java.util.ArrayList;

public class Badge {
    private String beskrivelse;
    private final ArrayList<Deltager> deltagere = new ArrayList<>();

    public Badge(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    /**
     * Return value nullable
     */
    public Deltager findDeltager() {
        Deltager deltagerMedBadge = null;
        int i = 0;
        boolean found = false;
        while (!found && i < deltagere.size()) {
            Deltager d = (Deltager) deltagere.get(i);
            if (d.getBadges().contains(this)) {
                deltagerMedBadge = d;
                found = true;
            } else i++;
        }
        return deltagerMedBadge;
    }

    public void tilføjDeltager(Deltager deltager) {
        this.deltagere.add(deltager);
    }

    public void fjernDeltager(Deltager deltager) {
        this.deltagere.remove(deltager);
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public ArrayList<Deltager> getDeltagere() {
        return deltagere;
    }

    @Override
    public String toString() {
        return beskrivelse;
    }
}
