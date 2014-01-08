package kauppalistapp.komennot;
import java.util.ArrayList;
import kauppalistapp.apurit.Lukija;
import java.util.List;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tiedosto;
import kauppalistapp.logiikka.Tuotelista;

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
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public TulostaTuotteet(int numero, String nimi, Lukija lukija, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat) {
        super(numero, nimi, lukija, tallennetutTuotteet, tallennetutListat);
    }

    @Override
    public boolean suorita() {
          System.out.println(super.tallennetutTuotteet.toString());
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
