
package kauppalistapp.logiikka;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.2
 * 
 * Ostos-olio sisältää Tuote-olion ja tähän kytketyn määrän
 */
public class Ostos implements Comparable<Ostos> {
    
    private Tuote tuote;
    private int maara;
    
    /**
     * Ostos-olion konstruktori
     * 
     * @param tuote nimen ja hinnan sisältävä olio
     * @param maara montako tuotetta
     */
    public Ostos(Tuote tuote, int maara) {
        this.tuote = tuote;
        this.maara = maara;
    }

    public Tuote getTuote() {
        return tuote;
    }

    /**
     * Lisaa Ostos-olion määrää annetulla parametrillä
     * 
     * @param lisays lisattava maara
     */
    public void lisaaMaaraa(int lisays) {
        this.maara += lisays;
    }

    public int getMaara() {
        return maara;
    }

    /**
     * Lisaa Ostos-olion määrää yhdellä
     */
    public void lisaaMaaraaYhdella() {
        this.maara += 1;
    }
    

    @Override
    public int compareTo(Ostos ostos) {
        return this.tuote.getNimi().hashCode()-ostos.getTuote().getNimi().hashCode();
    }
    
    @Override
    public String toString() {
        String palautettava = "";
        if (this.maara == 1) {
            palautettava += "   ";
        }
        else {
            palautettava +=  this.maara + "x ";
        }
        palautettava += this.tuote.toString();
        return palautettava;
    }    
}
