package kauppalistapp.sovellus;

import kauppalistapp.komennot.*;
import kauppalistapp.apurit.Lukija;
import kauppalistapp.logiikka.Tiedosto;
import kauppalistapp.logiikka.Lista;
import java.util.TreeMap;
import java.util.ArrayList;

public class Sovellus {

    private Lukija lukija;
    private TreeMap<Integer, Komento> komennot;
    private Tiedosto kaytettavaTiedosto;
    private Tiedosto tallennetutListatTiedosto;
    private ArrayList<Lista> tallennetutListat;


    public Sovellus() {
        this.komennot = new TreeMap<Integer, Komento>();
        this.lukija = new Lukija();
        this.kaytettavaTiedosto = new Tiedosto("Tuotteet");
        this.tallennetutListatTiedosto = new Tiedosto("TallennetutListat");
        this.tallennetutListat = new ArrayList<Lista>();        
    }

    public void kaynnista() {
        System.out.println("*****KauppalistaApp*****");
        System.out.println("");
        
        
        lisaaKomennot();
        lisaaListat(this.tallennetutListatTiedosto);
        
        boolean jatkuu = true;
        while (jatkuu) {
            System.out.println("_________________________");
            System.out.println("Komennot:");
            System.out.println("");
            tulostaKomennot();
            System.out.print("Anna komento (1-" + this.komentojenMaara() + ": ");           
            int komento = this.lukija.lueInteger();
            System.out.println("");
            jatkuu = this.komennot.get(komento).suorita();            
        }

    }

    public void lisaaKomennot() {
        this.komennot.put(1, new TulostaTuotteet(1, "Tulosta tuotteet", this.lukija, this.kaytettavaTiedosto, this.tallennetutListat));
        this.komennot.put(2, new LisaaTuote(2, "Lisaa tuote", this.lukija, this.kaytettavaTiedosto, this.tallennetutListat));
        this.komennot.put(3, new PoistaTuote(3, "Poista tuote", this.lukija, this.kaytettavaTiedosto, this.tallennetutListat));
        this.komennot.put(4, new JarjestaTuotteita(4, "Jarjesta tuotteita", this.lukija, this.kaytettavaTiedosto, this.tallennetutListat));
        this.komennot.put(5, new EtsiTuote(5, "Etsi tuote", this.lukija, this.kaytettavaTiedosto, this.tallennetutListat));
        this.komennot.put(6, new LisaaListalle(6, "Lisaa listalle", this.lukija, this.kaytettavaTiedosto, this.tallennetutListat));
    }

    public void tulostaKomennot() {
        for (int i = 1; i <= 6; i++) {
            System.out.println(this.komennot.get(i));
        }
        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
    }
    
    public int komentojenMaara() {
        return this.komennot.keySet().size();
    }
    
    public void lisaaListat(Tiedosto tiedosto) {
        for (String listanNimi : this.tallennetutListatTiedosto.annaListana()) {
            this.tallennetutListat.add(new Lista(listanNimi));
                    
        }
    }
}
