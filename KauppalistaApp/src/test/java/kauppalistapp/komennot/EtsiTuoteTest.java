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

public class EtsiTuoteTest {

    private SyoteJaTulostusApuri SJTApuri;
    private Lukija lukija;
    private Komento komento;

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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tulostaaOikeinKunTuoteLoytyy() {
        ByteArrayOutputStream tulostus = this.SJTApuri.tarkistaTulostus();
        System.setOut(new PrintStream(tulostus));
        System.setIn(this.SJTApuri.otaSyote("Maito"));
        this.lukija = new Lukija();
        this.komento = new EtsiTuote(1, "Testaa", this.lukija);
        this.komento.suorita();
        assertEquals("Anna tuotteen nimi:   1 - Maito, 1,50e Hakusanallasi löytyi yksi tulos  ", tulostus.toString());


    }
}
