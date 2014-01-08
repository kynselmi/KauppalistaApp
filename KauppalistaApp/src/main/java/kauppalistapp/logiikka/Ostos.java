
package kauppalistapp.logiikka;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.2
 */
public class Ostos implements Comparable<Ostos> {
    
    private Tuote tuote;
    private int maara;
    
    public Ostos(Tuote tuote, int maara) {
        this.tuote = tuote;
        this.maara = maara;
    }

    public Tuote getTuote() {
        return tuote;
    }

    public void lisaaMaaraa(int lisays) {
        this.maara += lisays;
    }

    public int getMaara() {
        return maara;
    }

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
