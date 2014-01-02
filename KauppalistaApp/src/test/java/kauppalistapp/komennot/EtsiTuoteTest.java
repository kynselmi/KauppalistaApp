package kauppalistapp.komennot;

import kauppalistapp.apurit.Lukija;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Testiapu.SyoteJaTulostusApuri;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import kauppalistapp.logiikka.*;
import java.util.List;
import java.util.ArrayList;

public class EtsiTuoteTest {

    private SyoteJaTulostusApuri SJTApuri;
    private Lukija lukija;
    private Komento komento;
    private Tiedosto tallennetutTuotteetTesti;
    private List<Lista> tallennetutListat;

    public EtsiTuoteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.lukija = new Lukija();
        this.SJTApuri = new SyoteJaTulostusApuri();
        this.tallennetutListat = new ArrayList<Lista>();
        this.tallennetutTuotteetTesti = new Tiedosto("TuotelistaTestaus");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tulostaaOikeinKunTuoteLoytyy() {


        String[] oikein = {
            "Anna tuotteen nimi:   1 - Maito ",
            "Hakusanallasi loytyi yksi tulos "};

        ByteArrayOutputStream tulostus = this.SJTApuri.tarkistaTulostus();
        System.setOut(new PrintStream(tulostus));
        System.setIn(this.SJTApuri.otaSyote("Maito"));
        this.lukija = new Lukija();
        this.komento = new EtsiTuote(1, "Testaa", this.lukija, this.tallennetutTuotteetTesti, this.tallennetutListat);
        this.komento.suorita();
        String[] tuloste = tulostus.toString().split("\n");
        String test = tuloste[0];
        assertEquals("Anna tuotteen nimi:   1 - Maito ", test);
    }
}
