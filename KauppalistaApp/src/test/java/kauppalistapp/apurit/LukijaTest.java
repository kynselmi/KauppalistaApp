package kauppalistapp.apurit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;

public class LukijaTest {
    
    private Lukija lukija;
    private Lukija lukijaInt;
    private ByteArrayInputStream syote;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.syote = new ByteArrayInputStream("Testi".getBytes());
        System.setIn(this.syote);
        this.lukija = new Lukija();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void lukeeString() {
        assertEquals("Testi", this.lukija.lueTeksti());
    }
    
    @Test
    public void lukeeStringTekstia() {
        assertEquals("Testi", this.lukija.lueTeksti("Test"));
    }
    
 //   @Test
 //   public void lukeeInt() {
//        assertEquals(5, this.lukija.lueInteger());
 //   }
}
