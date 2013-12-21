/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kauppalistapp.komennot;
import kauppalistapp.apurit.Lukija;
import kauppalistapp.apurit.TiedostonLukija;
import java.util.List;
import java.util.ArrayList;

public class TulostaTuotteet extends Komento {
    
    public TulostaTuotteet(int numero, String nimi, Lukija lukija) {
        super(numero, nimi, lukija);
    }

    @Override
    public boolean suorita() {
          TiedostonLukija tk = new TiedostonLukija();
          tulostus(tk.lueJaAnnaListana("Tuotteet.txt"));
          return true;
        
    }
    
    public void tulostus(List<String> lista) {
        System.out.println("Tuotteet:");
        for (String tuote : lista) {
            System.out.println(tuote);
        }
        System.out.println("");
    }
    
}
