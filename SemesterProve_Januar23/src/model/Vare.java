package model;

public class Vare {
    private Varekategori kategori;
    private String navn;
    private int udbudspris;
    private boolean solgt;
    private Salgsannonce salgsannonce;

    public Vare(Varekategori kategori, String navn, int udbudspris) {
        this.kategori = kategori;
        this.navn = navn;
        this.udbudspris = udbudspris;
        this.solgt = false;
    }

    public void setSalgsannonce(Salgsannonce salgsannonce) {
        this.salgsannonce = salgsannonce;
    }

    public void setSolgt(boolean solgt) {
        this.solgt = solgt;
    }

    public Salgsannonce getSalgsannonce() {
        return salgsannonce;
    }

    public Varekategori getKategori() {
        return kategori;
    }

    public String getNavn() {
        return navn;
    }

    public int getUdbudspris() {
        return udbudspris;
    }

    public boolean isSolgt() {
        return solgt;
    }

    @Override
    public String toString() {
        String status;
        if (isSolgt()) {
            status = "Solgt";
        } else {
            status = "Til Salg";
        }
        return navn + "    " + udbudspris + "   " + status;
    }
}
