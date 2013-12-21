package kauppalistapp.logiikka;

public class Tuote {

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

    public double getHinta() {
        return eurot;
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
        if (this.eurot == 0.0) {
            return this.nimi;
        } else {
            return this.nimi + ", " + this.eurot + "," + this.sentit + "e";
        }
    }
}
