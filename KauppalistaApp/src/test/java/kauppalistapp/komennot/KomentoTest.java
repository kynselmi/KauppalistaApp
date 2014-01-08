package kauppalistapp.komennot;

import java.util.ArrayList;
import java.util.List;
import kauppalistapp.apurit.Lukija;
import kauppalistapp.apurit.TiedostonKirjoittaja;
import kauppalistapp.apurit.TiedostonLukija;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tiedosto;
import kauppalistapp.logiikka.Tuote;
import kauppalistapp.logiikka.Tuotelista;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aleksi
 */
public abstract class KomentoTest {

    private int numero;
    private String nimi;
    protected Lukija lukija;
    protected TiedostonLukija tiedostonLukija;
    protected TiedostonKirjoittaja tiedostonKirjoittaja;
    protected Tuotelista tallennetutTuotteet;
    protected List<Ostoslista> tallennetutListat;

    public KomentoTest() {
        this.lukija = new Lukija();
        this.tiedostonLukija = new TiedostonLukija();
        this.tiedostonKirjoittaja = new TiedostonKirjoittaja();
        this.tallennetutTuotteet = new Tuotelista("TuotteetTesti");
        this.tallennetutListat = new ArrayList<Ostoslista>();
    }

    @Before
    public void setUp() {
        lisaaTuotteet();
        lisaaListat();
    }

    private void lisaaListat() {
        for (String tallennettuLista : this.tiedostonLukija.annaListanaIlmanRiviNumeroa(new Tiedosto("TallennetutListatTesti"))) {
            Ostoslista ostoslista = this.tiedostonLukija.annaOstoslistana(new Tiedosto(tallennettuLista));
            this.tallennetutListat.add(ostoslista);
        }
    }
    
        private void lisaaTuotteet() {
        TiedostonLukija tl = new TiedostonLukija();
        for (Tuote listalla : tl.annaTuoteListana(new Tiedosto("Tuotteet"))) {
            this.tallennetutTuotteet.lisaaTuote(listalla);
        }
    }
}
