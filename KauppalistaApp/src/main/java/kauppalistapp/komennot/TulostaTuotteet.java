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
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     * @param io  IO-rajapinnan totetuttava olio
     */
    public TulostaTuotteet(int numero, String nimi, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat, IO io) {
        super(numero, nimi, tallennetutTuotteet, tallennetutListat, io);
    }

    @Override
    public boolean suorita() {
          this.io.tulostaTeksti(super.tallennetutTuotteet.toString());
          return true;        
    }   

}
