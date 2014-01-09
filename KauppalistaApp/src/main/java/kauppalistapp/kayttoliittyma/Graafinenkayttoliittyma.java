package kauppalistapp.kayttoliittyma;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import javax.swing.SwingUtilities;
import kauppalistapp.apurit.Lukija;
import kauppalistapp.komennot.EtsiTuote;
import kauppalistapp.komennot.JarjestaTuotteita;
import kauppalistapp.komennot.KasitteleListoja;
import kauppalistapp.komennot.Komento;
import kauppalistapp.komennot.LisaaTuote;
import kauppalistapp.komennot.Lopetus;
import kauppalistapp.komennot.PoistaTuote;
import kauppalistapp.komennot.TulostaTuotteet;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tuotelista;

/**
 *
 * @author Aleksi
 */
public class Graafinenkayttoliittyma implements IO {

    private GUI kayttoliittyma;
    private TreeMap<Integer, Komento> komennot;
    private Lukija lukija;
    private Tuotelista tallennetutTuotteet;
    private List<Ostoslista> tallennetutListat;

    
    public Graafinenkayttoliittyma() {
        this.kayttoliittyma = new GUI();
        this.lukija = new Lukija();
        this.tallennetutTuotteet = new Tuotelista("Tuotteet");
        this.tallennetutListat = new ArrayList<Ostoslista>();

    }

    public void kaynnista() {
        SwingUtilities.invokeLater(this.kayttoliittyma);
        this.komennot = new TreeMap<Integer, Komento>();
        
        boolean suoritetaan = true;
        while (suoritetaan) {
            if (kayttoliittyma.nappiaPainettu()) {
                suoritaKomento(lueInteger());
            }
            
        }
    }
    
    public boolean suoritaKomento(int komento) {
        return this.komennot.get(komento).suorita();
    }

    @Override
    public void tulostaTeksti(String teksti) {
        this.kayttoliittyma.vaihdaTekstikentta(teksti);
    }

    @Override
    public int lueInteger() {
        return kayttoliittyma.annaSyoteKentasta();
    }

    @Override
    public void tulostaTekstiIlmanRivinVaihtoa(String teksti) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void lisaaKomennot() {
        this.komennot.put(1, new TulostaTuotteet(1, "Tulosta tuotteet", this.lukija, this.tallennetutTuotteet, this.tallennetutListat));
        this.komennot.put(2, new LisaaTuote(2, "Lisaa tuote", this.lukija, this.tallennetutTuotteet, this.tallennetutListat));
        this.komennot.put(3, new PoistaTuote(3, "Poista tuote", this.lukija, this.tallennetutTuotteet, this.tallennetutListat));
        this.komennot.put(4, new JarjestaTuotteita(4, "Jarjesta tuotteita", this.lukija, this.tallennetutTuotteet, this.tallennetutListat));
        this.komennot.put(5, new EtsiTuote(5, "Etsi tuote", this.lukija, this.tallennetutTuotteet, this.tallennetutListat));
        this.komennot.put(6, new KasitteleListoja(6, "Kasittele listoja", this.lukija, this.tallennetutTuotteet, this.tallennetutListat));
        this.komennot.put(7, new Lopetus(7, "Lopeta", this.lukija, this.tallennetutTuotteet, this.tallennetutListat));
    }
}
