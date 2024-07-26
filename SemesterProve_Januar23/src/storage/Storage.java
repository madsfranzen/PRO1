package storage;

import model.Salg;
import model.Sælger;
import model.Vare;

import java.util.ArrayList;

public abstract class Storage {
    private static final ArrayList<Sælger> sælgere = new ArrayList<>();
    private static final ArrayList<Vare> varer = new ArrayList<>();
    private static final ArrayList<Salg> alleSalg = new ArrayList<>();

    public static void gemSælger(Sælger sælger) {
        sælgere.add(sælger);
    }

    public static void gemVare(Vare vare) {
        varer.add(vare);
    }

    public static void gemSalg(Salg salg) {
        alleSalg.add(salg);
    }

    public static ArrayList<Sælger> getSælgere() {
        return new ArrayList<>(sælgere);
    }

    public static ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public static ArrayList<Salg> getSalg() {
        return new ArrayList<>(alleSalg);
    }
}
