package kauppalistapp.logiikka;

import java.util.Objects;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class Tuote {

    private String nimi;
    private int eurot;
    private int sentit;

    /**
     * Tuote-olion konstruktori
     * @param nimi Tuotteen nimi
     */
    public Tuote(String nimi) {
        this.nimi = nimi;
    }

    /**
     * Tuote-olion konstruktori, hinta mukana
     * @param nimi Tuotteen nimi
     * @param eurot Tuotteen hinnan euro-osa
     * @param sentit Tuotteen hinnan senttiosa
     */
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.nimi);
        hash = 71 * hash + this.eurot;
        hash = 71 * hash + this.sentit;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tuote other = (Tuote) obj;
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        if (this.eurot != other.eurot) {
            return false;
        }
        if (this.sentit != other.sentit) {
            return false;
        }
        return true;
    }


}
