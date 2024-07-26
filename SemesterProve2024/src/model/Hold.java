package model;

import java.util.ArrayList;

public class Hold {
    private String navn;
    private final ArrayList<Deltager> deltagere = new ArrayList<>();

    public Hold(String navn) {
        this.navn = navn;
    }

    public Deltager deltagerMedFlestKm() {
        Deltager deltagerMedFlestKm = deltagere.get(0);
        for (int i = 1; i < deltagere.size(); i++) {
            if (deltagere.get(i).kmIAlt() > deltagerMedFlestKm.kmIAlt()) {
                deltagerMedFlestKm = deltagere.get(i);
            }
        }
        return deltagerMedFlestKm;
    }

    public ArrayList<Badge> holdBadges() {
        ArrayList<Badge> holdBadges = new ArrayList<>();
        for (Deltager deltager : deltagere) {
            for (Badge badge : deltager.getBadges()) {
                if (!holdBadges.contains(badge)) {
                    holdBadges.add(badge);
                }
            }
        }
        return holdBadges;
    }

    public Deltager[] hurtigeDeltagere(int minutGrænse, int kmGrænse) {
        Deltager[] tempArray = new Deltager[deltagere.size()];
        int i = 0;
        for (Deltager d : deltagere) {
            for (Tur tur : d.getTure()) {
                if (tur.getAntalKm() >= kmGrænse && tur.getAntalMinutter() <= minutGrænse) {
                    tempArray[i] = d;
                    i++;
                    continue; // version med while-sætning ses nedenfor -> hurtigeDeltagereUdenContinue()
                }
            }
        }
        Deltager[] finalArray = new Deltager[i];
        for (int j = 0; j < i; j++) {
            finalArray[j] = tempArray[j];
        }
        return finalArray;
    }

    public Deltager[] hurtigeDeltagereUdenContinue(int minutGrænse, int kmGrænse) {
        Deltager[] tempArray = new Deltager[deltagere.size()];
        int i = 0;
        for (Deltager d : deltagere) {
            boolean found = false;
            int g = 0;
            while (!found && g < d.getTure().size()) {
                Tur tur = d.getTure().get(g);
                if (tur.getAntalKm() >= kmGrænse && tur.getAntalMinutter() <= minutGrænse) {
                    tempArray[i] = d;
                    i++;
                    found = true;
                } else g++;
            }
        }
        Deltager[] finalArray = new Deltager[i];
        for (int j = 0; j < i; j++) {
            finalArray[j] = tempArray[j];
        }
        return finalArray;
    }

    public void tilføjDeltager(Deltager deltager) {
        this.deltagere.add(deltager);
    }

    public void sletDeltager(Deltager deltager) {
        this.deltagere.remove(deltager);
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Deltager> getDeltagere() {
        return deltagere;
    }

    @Override
    public String toString() {
        return this.navn;
    }
}
