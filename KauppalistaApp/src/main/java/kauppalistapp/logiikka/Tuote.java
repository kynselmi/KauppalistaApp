package kauppalistapp.logiikka;

public class Tuote {

    private String nimi;
    private double hinta;

    public Tuote(String nimi) {
        this.nimi = nimi;
    }

    public Tuote(String nimi, double hinta) {
        this.nimi = nimi;
        this.hinta = hinta;
    }

    public String getNimi() {
        return nimi;
    }

    public double getHinta() {
        return hinta;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setHinta(double hinta) {
        this.hinta = hinta;
    }

    @Override
    public String toString() {
        if (this.hinta == 0.0) {
            return this.nimi;
        } else {
            return this.nimi + ", " + this.hinta + "e";
        }
    }
}
