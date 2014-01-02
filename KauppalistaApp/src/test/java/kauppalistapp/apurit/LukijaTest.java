package kauppalistapp.apurit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import Testiapu.SyoteJaTulostusApuri;

public class LukijaTest {

    private Lukija lukija;
    SyoteJaTulostusApuri syo;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.syo = new SyoteJaTulostusApuri();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void lukeeString() {
        System.setIn(this.syo.otaSyote("Testi"));
        this.lukija = new Lukija();
        assertEquals("Testi", this.lukija.lueTeksti());
    }

    @Test
    public void lukeeStringTekstia() {
        System.setIn(this.syo.otaSyote("Testi"));
        this.lukija = new Lukija();
        assertEquals("Testi", this.lukija.lueTeksti("Test"));
    }

    @Test
    public void lukeeInt() {
        System.setIn(this.syo.otaSyote("5"));
        this.lukija = new Lukija();
        assertEquals(5, this.lukija.lueInteger());
    }
    
    @Test
    public void lukeeIntTekstia() {
        System.setIn(this.syo.otaSyote("10"));
        this.lukija = new Lukija();
        assertEquals(10, this.lukija.lueInteger("Testi"));
    }
}
