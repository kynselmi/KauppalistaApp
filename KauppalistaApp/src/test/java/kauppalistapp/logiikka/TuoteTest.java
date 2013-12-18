package kauppalistapp.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TuoteTest {
    
    public TuoteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void toStringToimiiOikeinIlmanHintaa() {
        Tuote maito = new Tuote("Maito");
        assertEquals("Maito", maito.toString());
    }
    
    @Test
    public void toStringToimiiOikeinHinnanKanssa() {
        Tuote maito = new Tuote("Maito", 2);
        assertEquals("Maito, 2.0e", maito.toString());
    }
    
}