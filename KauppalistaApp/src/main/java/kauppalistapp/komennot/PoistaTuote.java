package kauppalistapp.komennot;
import kauppalistapp.apurit.Lukija;
import java.util.List;
import java.util.ArrayList;

public class PoistaTuote extends Komento {

    public PoistaTuote(int numero, String nimi, Lukija lukija) {
        super(numero, nimi, lukija);
    }
    
    @Override
    public boolean suorita() {
        int poistettavanRivi = super.lukija.lueInteger("Syota poistettavan tuotteen rivinumero: ");
        List<String> lista = super.tiedostonLukija.annaListanaIlmanRiviNumeroa("Tuotteet.txt");
        lista.remove(poistettavanRivi-1);        
        super.tiedostonKirjoittaja.tyhjennaTiedosto("Tuotteet.txt");
        super.tiedostonKirjoittaja.kirjoitaTiedostoon(lista, "Tuotteet.txt");
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
