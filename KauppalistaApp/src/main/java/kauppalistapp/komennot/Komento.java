
package kauppalistapp.komennot;
import java.util.ArrayList;
import kauppalistapp.apurit.*;
import kauppalistapp.logiikka.Tiedosto;
import kauppalistapp.logiikka.Ostoslista;
import java.util.List;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public abstract class Komento {
    
    private int numero;
    private String nimi;
    /**
     * Lukija-olio, johon on kapseloitu Scanner
     */
    protected Lukija lukija;
    /**
     * TiedostonLukija-olio, johon on kapseloitu tekstitiedostonlukija
     */
    protected TiedostonLukija tiedostonLukija;
    /**
     * TiedonKirjoittaja-olio, johon on kapseloitu tekstitiedostonkirjoittaja
     */
    protected TiedostonKirjoittaja tiedostonKirjoittaja;
    /**
     * Tallennetut tuotteet sisältävä Tiedosto-olio
     */
    protected Tiedosto tiedosto;
    /**
     * Käyttäjän tallentamat listat 
     */
    protected List<Ostoslista> tallennetutListat;
    
    /**
     * Komento-luokan konstruktori
     * @param numero Komennon numero
     * @param nimi  Komennon nimi
     * @param lukija Lukija-tyyppiä oleva scanner-lukija
     * @param tiedosto Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public Komento(int numero, String nimi, Lukija lukija, Tiedosto tiedosto, List<Ostoslista> tallennetutListat) {
        this.numero = numero;
        this.nimi = nimi;
        this.lukija = lukija;
        this.tiedostonLukija = new TiedostonLukija();
        this.tiedostonKirjoittaja = new TiedostonKirjoittaja();
        this.tiedosto = tiedosto;
        this.tallennetutListat = tallennetutListat;
        
    }
    
    /**
     * Korvaa toString-metodin Komentoluokalle
     * @return Komennon String-esitys
     */
    
    @Override
    public String toString() {
        return this.numero + " " + this.nimi;
    }
    
/**
 * Suorittaa komennon
 * @return Palauttaa totuusarvona true jos ohjelman tulee jatkua komennon suorittamisen jälkeen. Palauttaa false jos ohjelman tulee päättyä.
 */
    public abstract boolean suorita();
        
    
}
