package model;

import java.util.ArrayList;

public class Sælger implements Comparable<Sælger> {
    private String navn;
    private int studiekortNummer;
    private String mobil;
    private final ArrayList<Salgsannonce> salgsannoncer = new ArrayList<>();

    public Sælger(String navn, int studiekortNummer, String mobil) {
        this.navn = navn;
        this.studiekortNummer = studiekortNummer;
        this.mobil = mobil;
    }

    public ArrayList<Vare> alleIkkeSolgteVarerIKategori(Varekategori kategori) {
        ArrayList<Vare> alleIkkeSolgteVarer = new ArrayList<>();
        for (Salgsannonce salgsannonce : salgsannoncer) {
            ArrayList<Vare> varerIAnnonce = new ArrayList<>(salgsannonce.getVarer());
            for (Vare vare : varerIAnnonce) {
                if (vare.getKategori() == kategori && !vare.isSolgt()) {
                    alleIkkeSolgteVarer.add(vare);
                }
            }
        }
        return alleIkkeSolgteVarer;
    }

    public void tilføjSalgsannnonce(Salgsannonce salgsannonce) {
        salgsannoncer.add(salgsannonce);
    }

    public ArrayList<Salgsannonce> getSalgsannoncer() {
        return salgsannoncer;
    }

    public String getNavn() {
        return navn;
    }

    public int getStudiekortNummer() {
        return studiekortNummer;
    }

    public String getMobil() {
        return mobil;
    }

    @Override
    public int compareTo(Sælger o) {
        return this.navn.compareTo(o.navn);
    }
}
