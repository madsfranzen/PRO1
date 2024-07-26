package controller;

import model.*;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class Controller {

    public static Sælger opretSælger(String navn, int studiekortNummer, String mobil) {
        Sælger sælger = new Sælger(navn, studiekortNummer, mobil);
        Storage.gemSælger(sælger);
        return sælger;
    }

    public static Vare opretVare(Varekategori varekategori, String navn, int udbudspris) {
        Vare vare = new Vare(varekategori, navn, udbudspris);
        Storage.gemVare(vare);
        return vare;
    }

    public static void opretSalgsannonce(Sælger sælger, Vare... varerArgs) {
        ArrayList<Vare> varerArray = new ArrayList<>();
        for (Vare vare : varerArgs) {
            varerArray.add(vare);
        }
        Salgsannonce salgsannonce = new Salgsannonce(sælger, varerArray);
        for (Vare vare : varerArray) {
            vare.setSalgsannonce(salgsannonce);
        }
        sælger.tilføjSalgsannnonce(salgsannonce);
    }


    public static void opretSalg(String navn, int aftaltPris, Vare... varer) {
        ArrayList<Vare> varerKøbes = new ArrayList<>();
        for (Vare vare : varer) {
            varerKøbes.add(vare);
        }
        Salg salg = new Salg(navn, aftaltPris, varerKøbes);
        for (Vare vare : varerKøbes) {
            vare.setSolgt(true);
            if (vare.getSalgsannonce() != null) {
                vare.getSalgsannonce().refreshAnnonce();
            }
        }
        Storage.gemSalg(salg);
    }

    public static void initStorage() {
        Sælger viktor = opretSælger("Viktor", 23, "45344247");
        Sælger gustav = opretSælger("Gustav", 35, "56124522");

        Vare samsungMobil = opretVare(Varekategori.MOBILTELEFON, "Samsung Mobil", 1200);
        Vare iphone = opretVare(Varekategori.MOBILTELEFON, "iPhone", 2000);
        Vare java = opretVare(Varekategori.STUDIEBOG, "Java", 400);
        Vare android = opretVare(Varekategori.STUDIEBOG, "Android", 300);
        Vare python = opretVare(Varekategori.STUDIEBOG, "Python", 200);
        Vare regnjakke = opretVare(Varekategori.TØJ, "Regnjakke", 100);
        Vare regnbukser = opretVare(Varekategori.TØJ, "Regnbukser", 80);

        opretSalgsannonce(viktor, samsungMobil);
        opretSalgsannonce(viktor, java, android, python);
        opretSalgsannonce(gustav, iphone);
        opretSalgsannonce(gustav, regnjakke, regnbukser);

        opretSalg("Stine", 450, android, python);
        opretSalg("Laura", 120, regnbukser, regnjakke);
    }

    public static void salgTilFil(String filNavn) {
        ArrayList<Salg> sorteretSalg = new ArrayList<>(Storage.getSalg());
        sorteretSalg.sort(Salg::compareTo);
        File file = new File(filNavn);
        try (PrintWriter pw = new PrintWriter(file)) {
            for (Salg salg : sorteretSalg) {
                int samletPris = 0;
                pw.println(salg.getKøbersNavn() + ":");
                for (Vare vare : salg.getVarer()) {
                    pw.println("     " + vare.getNavn() + "      " + vare.getUdbudspris());
                    samletPris += vare.getUdbudspris();
                }
                pw.println("Aftalt pris: " + salg.getAftaltSamletPris() + "  Rabat er: " + (salg.getAftaltSamletPris() - samletPris));
                pw.println("");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public static ArrayList<Sælger> sælgereDerKøber() {
        ArrayList<String> købere = new ArrayList<>();
        for (Salg salg : Storage.getSalg()) {
            if (!købere.contains(salg.getKøbersNavn())) {
                købere.add(salg.getKøbersNavn());
            }
        }
        ArrayList<Sælger> sælgereDerKøber = new ArrayList<>();
        for (Sælger sælger : Storage.getSælgere()) {
            for (String køber : købere) {
                if (sælger.getNavn().equals(køber) && !sælgereDerKøber.contains(sælger.getNavn())) {
                    sælgereDerKøber.add(sælger);
                }
            }
        }
        return sælgereDerKøber;
    }

    public static ArrayList<Salgsannonce> getAnnoncer() {
        ArrayList<Salgsannonce> salgsannoncer = new ArrayList<>();
        for (Sælger sælger : Storage.getSælgere()) {
            for (Salgsannonce salgsannonce : sælger.getSalgsannoncer()) {
                salgsannoncer.add(salgsannonce);
            }
        }
        return salgsannoncer;
    }
}
