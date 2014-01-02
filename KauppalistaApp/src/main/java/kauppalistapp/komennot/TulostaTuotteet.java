package kauppalistapp.komennot;
import kauppalistapp.apurit.Lukija;
import java.util.List;
import kauppalistapp.logiikka.Lista;
import kauppalistapp.logiikka.Tiedosto;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class TulostaTuotteet extends Komento {
    
    /**
     * TulostaTuotteet-olion konstruktori
     * @param numero Komennon numero
     * @param nimi  Komennon nimi
     * @param lukija Lukija-tyyppiä oleva scanner-lukija
     * @param tiedosto Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public TulostaTuotteet(int numero, String nimi, Lukija lukija, Tiedosto tiedosto, List<Lista> tallennetutListat) {
        super(numero, nimi, lukija, tiedosto, tallennetutListat);
    }

    @Override
    public boolean suorita() {
          tulostus(super.tiedostonLukija.lueJaAnnaListana(super.tiedosto.getTiedosto()));
          return true;
        
    }
    
    /**
     * Tulostaa listan Stringeja yksi per rivi
     * @param lista Tulostettava lista tuotteita
     */
    public void tulostus(List<String> lista) {
        System.out.println("Tuotteet:");
        for (String tuote : lista) {
            System.out.println("  " + tuote);
        }
        System.out.println("");
    }
    
}
