package kauppalistapp.komennot;
import kauppalistapp.apurit.Lukija;
import java.util.List;

public class TulostaTuotteet extends Komento {
    
    public TulostaTuotteet(int numero, String nimi, Lukija lukija) {
        super(numero, nimi, lukija);
    }

    @Override
    public boolean suorita() {
          tulostus(super.tiedostonLukija.lueJaAnnaListana("Tuotteet.txt"));
          return true;
        
    }
    
    public void tulostus(List<String> lista) {
        System.out.println("Tuotteet:");
        for (String tuote : lista) {
            System.out.println("  " + tuote);
        }
        System.out.println("");
    }
    
}
