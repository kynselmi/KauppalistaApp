package kauppalistapp.komennot;
import kauppalistapp.apurit.Lukija;
import java.util.List;
import java.util.ArrayList;
import kauppalistapp.kayttoliittyma.IO;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tiedosto;
import kauppalistapp.logiikka.Tuotelista;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 * 
 * Poistaa tuotteen Tuotelistalta
 */
public class PoistaTuote extends Komento {

    /**
     * PoistaTuote-olion konstruktori
     * @param numero Komennon numero
     * @param nimi  Komennon nimi
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param io IO-rajapinnan totetuttava olio
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public PoistaTuote(int numero, String nimi, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat, IO io) {
        super(numero, nimi, tallennetutTuotteet, tallennetutListat, io);
    }
    
    @Override
    public boolean suorita() {
        int poistettavanRivi = this.io.lueInteger("Syota poistettavan tuotteen rivinumero: ");
        List<String> lista = super.tiedostonLukija.annaListanaIlmanRiviNumeroa(super.tallennetutTuotteet.getTiedosto());
        lista.remove(poistettavanRivi-1);
        super.tallennetutTuotteet.poistaTuote(poistettavanRivi);
        super.tiedostonKirjoittaja.tyhjennaTiedosto(super.tallennetutTuotteet.getTiedosto());
        super.tiedostonKirjoittaja.kirjoitaTiedostoon(lista, super.tallennetutTuotteet.getTiedosto());
        return true;
    }

}
