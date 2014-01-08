package kauppalistapp.komennot;
import kauppalistapp.apurit.Lukija;
import java.util.List;
import java.util.ArrayList;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tiedosto;
import kauppalistapp.logiikka.Tuotelista;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class PoistaTuote extends Komento {

    /**
     * PoistaTuote-olion konstruktori
     * @param numero Komennon numero
     * @param nimi  Komennon nimi
     * @param lukija Lukija-tyyppiä oleva scanner-lukija
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public PoistaTuote(int numero, String nimi, Lukija lukija, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat) {
        super(numero, nimi, lukija, tallennetutTuotteet, tallennetutListat);
    }
    
    @Override
    public boolean suorita() {
        int poistettavanRivi = super.lukija.lueInteger("Syota poistettavan tuotteen rivinumero: ");
        List<String> lista = super.tiedostonLukija.annaListanaIlmanRiviNumeroa(super.tallennetutTuotteet.getTiedosto());
        lista.remove(poistettavanRivi-1);
        super.tallennetutTuotteet.poistaTuote(poistettavanRivi);
        super.tiedostonKirjoittaja.tyhjennaTiedosto(super.tallennetutTuotteet.getTiedosto());
        super.tiedostonKirjoittaja.kirjoitaTiedostoon(lista, super.tallennetutTuotteet.getTiedosto());
        return true;
    }
    
    /**
     * Leikkaa Listasta stringeja valilyonnit pois
     * @param lista Trimattava lista
     * @return Trimmattu lista
     */
    public List<String> trimmaaListaa(List<String> lista) {
        List<String> trimmattuLista = new ArrayList<String>();
        for (String listalla : lista) {
            trimmattuLista.add(listalla.trim());
        }
        
        return trimmattuLista;
    }
    
}
