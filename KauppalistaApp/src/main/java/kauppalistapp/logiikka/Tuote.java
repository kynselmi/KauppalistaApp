package kauppalistapp.logiikka;

public class Tuote implements Comparable<Tuote> {

    private String nimi;
    private int eurot;
    private int sentit;

    public Tuote(String nimi) {
        this.nimi = nimi;
    }

    public Tuote(String nimi, int eurot, int sentit) {
        this.nimi = nimi;
        this.eurot = eurot;
        this.sentit = sentit;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setHinta(int eurot, int sentit) {
        this.eurot = eurot;
        this.sentit = sentit;
    }

    @Override
    public String toString() {
        String sentitTekstina = "" + this.sentit;
        if (this.sentit < 10) {
            sentitTekstina = "0" + this.sentit;
        }
        if (this.eurot == 0 && this.sentit == 0) {
            return this.nimi;
        } else {
            return this.nimi + ", " + this.eurot + "," + sentitTekstina + "e";
        }
    }

    public boolean equals(Tuote tuote) {
        boolean onkoSama = false;
        if (tuote.getNimi().equals(this.nimi)) {
            onkoSama = true;
        }
        return onkoSama;
    }

    @Override
    public int compareTo(Tuote tuote) {
        return tuote.getNimi().compareTo(this.nimi);
    }
}
