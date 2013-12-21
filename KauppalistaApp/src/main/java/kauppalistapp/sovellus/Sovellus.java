package kauppalistapp.sovellus;

import kauppalistapp.komennot.*;
import kauppalistapp.apurit.Lukija;
import java.util.TreeMap;

public class Sovellus {

    private Lukija lukija;
    private TreeMap<Integer, Komento> komennot;

    public Sovellus() {
        this.komennot = new TreeMap<Integer, Komento>();
        this.lukija = new Lukija();
    }

    public void kaynnista() {
        System.out.println("*****KauppalistaApp*****");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        lisaaKomennot();
        
        boolean jatkuu = true;
        while (jatkuu) {
            tulostaKomennot();
            System.out.print("Anna komento (1-3): ");
            int komento = this.lukija.lueInteger();
            jatkuu = this.komennot.get(komento).suorita();            
        }

    }

    public void lisaaKomennot() {
        this.komennot.put(1, new TulostaTuotteet(1, "Tulosta tuotteet", this.lukija));
        this.komennot.put(2, new LisaaTuote(2, "Lisaa tuote", this.lukija));
        this.komennot.put(3, new PoistaTuote(3, "Poista tuote", this.lukija));
    }

    public void tulostaKomennot() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(this.komennot.get(i));
        }
    }
}
