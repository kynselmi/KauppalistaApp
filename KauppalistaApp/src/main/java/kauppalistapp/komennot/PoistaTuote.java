package kauppalistapp.komennot;
import kauppalistapp.apurit.Lukija;
import java.util.List;
import java.util.ArrayList;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tiedosto;

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
     * @param tiedosto Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public PoistaTuote(int numero, String nimi, Lukija lukija, Tiedosto tiedosto, List<Ostoslista> tallennetutListat) {
        super(numero, nimi, lukija, tiedosto, tallennetutListat);
    }
    
    @Override
    public boolean suorita() {
        int poistettavanRivi = super.lukija.lueInteger("Syota poistettavan tuotteen rivinumero: ");
        List<String> lista = super.tiedostonLukija.annaListanaIlmanRiviNumeroa(super.tiedosto.getTiedosto());
        lista.remove(poistettavanRivi-1);        
        super.tiedostonKirjoittaja.tyhjennaTiedosto(this.tiedosto.getNimi());
        super.tiedostonKirjoittaja.kirjoitaTiedostoon(lista, this.tiedosto.getNimi());
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
