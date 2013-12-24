package kauppalistapp.komennot;
import kauppalistapp.apurit.Lukija;
import java.util.List;
import java.util.ArrayList;
import kauppalistapp.logiikka.Lista;
import kauppalistapp.logiikka.Tiedosto;

public class PoistaTuote extends Komento {

    public PoistaTuote(int numero, String nimi, Lukija lukija, Tiedosto tiedosto, List<Lista> tallennetutListat) {
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
    
    public List<String> trimmaaListaa(List<String> lista) {
        List<String> trimmattuLista = new ArrayList<String>();
        for (String listalla : lista) {
            trimmattuLista.add(listalla.trim());
        }
        
        return trimmattuLista;
    }
    
}
