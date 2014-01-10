package kauppalistapp.kayttoliittyma;

import kauppalistapp.komennot.*;
import kauppalistapp.apurit.Lukija;
import kauppalistapp.logiikka.*;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import kauppalistapp.apurit.TiedostonLukija;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 *
 * Ohjelman suoritus tapahtuu tässä luokassa
 */
public class Tekstikayttoliittyma {

    private TreeMap<Integer, Komento> komennot;
    private Tuotelista tallennetutTuotteet;
    private List<Ostoslista> tallennetutListat;
    private IO io;

    /**
     * Sovellus-olion konstruktori
     */
    public Tekstikayttoliittyma() {
        this.komennot = new TreeMap<Integer, Komento>();
        this.tallennetutTuotteet = new Tuotelista("Tuotteet");
        this.tallennetutListat = new ArrayList<Ostoslista>();
        this.io = new IOTeksti();
    }

    /**
     * Kaynnistaa sovelluksen
     */
    public void kaynnista() {

        this.io.tulostaTeksti("*****KauppalistaApp*****");
        this.io.tulostaTeksti("");

        lisaaTuotteet();
        lisaaListat();
        lisaaKomennot();

        boolean jatkuu = true;
        while (jatkuu) {
            this.io.tulostaTeksti("_________________________");
            this.io.tulostaTeksti("Komennot:");
            this.io.tulostaTeksti("");
            tulostaKomennot();
            this.io.tulostaTekstiIlmanRivinVaihtoa("Anna komento (1-" + this.komentojenMaara() + "): ");
            int komento = this.io.lueInteger();
            this.io.tulostaTeksti("");
            if (komento != -1) {
                jatkuu = this.komennot.get(komento).suorita();
            }
        }

    }

    /**
     * Lisää sovelluksen komennot
     */
    public void lisaaKomennot() {
        this.komennot.put(1, new TulostaTuotteet(1, "Tulosta tuotteet", this.tallennetutTuotteet, this.tallennetutListat, this.io));
        this.komennot.put(2, new LisaaTuote(2, "Lisaa tuote", this.tallennetutTuotteet, this.tallennetutListat, this.io));
        this.komennot.put(3, new PoistaTuote(3, "Poista tuote", this.tallennetutTuotteet, this.tallennetutListat, this.io));
        this.komennot.put(4, new JarjestaTuotteita(4, "Jarjesta tuotteita", this.tallennetutTuotteet, this.tallennetutListat, this.io));
        this.komennot.put(5, new EtsiTuote(5, "Etsi tuote", this.tallennetutTuotteet, this.tallennetutListat, this.io));
        this.komennot.put(6, new KasitteleListoja(6, "Kasittele listoja", this.tallennetutTuotteet, this.tallennetutListat, this.io));
        this.komennot.put(7, new Lopetus(7, "Lopeta", this.tallennetutTuotteet, this.tallennetutListat, this.io));
    }

    /**
     * Tulostaa sovelluksen komennot
     */
    public void tulostaKomennot() {
        for (int i = 1; i <= this.komentojenMaara(); i++) {
            this.io.tulostaTeksti(this.komennot.get(i).toString());
        }
        this.io.tulostaTeksti("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
    }

    /**
     * Antaa komentojen maaran
     *
     * @return komentojen maara
     */
    public int komentojenMaara() {
        return this.komennot.keySet().size();
    }

    private void lisaaTuotteet() {
        TiedostonLukija tl = new TiedostonLukija();
        for (Tuote listalla : tl.annaTuoteListana(new Tiedosto("Tuotteet"))) {
            this.tallennetutTuotteet.lisaaTuote(listalla);
        }
    }

    /**
     * Lisaa tallennetut listat taulukkoon
     */
    private void lisaaListat() {
        TiedostonLukija tl = new TiedostonLukija();
        for (String tallennettuLista : tl.annaListanaIlmanRiviNumeroa(new Tiedosto("TallennetutListat"))) {
            Ostoslista ostoslista = tl.annaOstoslistana(new Tiedosto(tallennettuLista));
            this.tallennetutListat.add(ostoslista);
        }
    }
}
