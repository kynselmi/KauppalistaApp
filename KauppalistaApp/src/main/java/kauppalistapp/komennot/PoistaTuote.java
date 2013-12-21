
package kauppalistapp.komennot;
import kauppalistapp.apurit.*;
import java.util.List;
import java.util.ArrayList;

public class PoistaTuote extends Komento {

    public PoistaTuote(int numero, String nimi, Lukija lukija) {
        super(numero, nimi, lukija);
    }
    
    @Override
    public boolean suorita() {
        int poistettavanRivi = super.lukija.lueInteger("Syota poistettavan tuotteen rivinumero: ");
        TiedostonLukija tl = new TiedostonLukija();
        List<String> lista = tl.annaListanaIlmanRiviNumeroa("Tuotteet.txt");
        lista.remove(poistettavanRivi-1);        
        TiedostonKirjoittaja tk = new TiedostonKirjoittaja();
        tk.tyhjennaTiedosto("Tuotteet.txt");
        tk.kirjoitaTiedostoon(lista, "Tuotteet.txt");
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
