
package kauppalistapp.komennot;
import kauppalistapp.apurit.*;
import java.util.List;

public class PoistaTuote extends Komento {

    public PoistaTuote(int numero, String nimi, Lukija lukija) {
        super(numero, nimi, lukija);
    }
    
    @Override
    public boolean suorita() {
        int poistettavanRivi = super.lukija.lueInteger("Syota poistettavan tuotteen rivinumero: ");
        TiedostonLukija tl = new TiedostonLukija();
        List<String> lista = tl.lueJaAnnaListana("Tuotteet.txt");
        lista.remove(poistettavanRivi-1);
        TiedostonKirjoittaja tk = new TiedostonKirjoittaja();
        tk.kirjoitaTiedostoon(lista, "Tuotteet.txt");
        return true;
    }
    
}
