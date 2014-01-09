package kauppalistapp.komennot;
import java.util.ArrayList;
import kauppalistapp.apurit.Lukija;
import java.util.List;
import kauppalistapp.kayttoliittyma.IO;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tiedosto;
import kauppalistapp.logiikka.Tuotelista;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 * 
 * Tulostaa Tuotelitsaan tallennetut Tuotteet
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
          tulostaTeksti(super.tallennetutTuotteet.toString());
          return true;
        
    }   

}
