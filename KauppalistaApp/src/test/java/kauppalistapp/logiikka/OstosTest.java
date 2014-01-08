package kauppalistapp.logiikka;

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
public class OstosTest {

    private Ostos ostos;
    private Tuote maito;
    

    public OstosTest() {
    }

    @Before
    public void setUp() {
        this.maito = new Tuote("Maito", 1, 50);
        this.ostos = new Ostos(this.maito, 1);
    }

    @Test
    public void lisaaMaaraaYhdella() {
        this.ostos.lisaaMaaraaYhdella();
        assertEquals(this.ostos.getMaara(), 2);

        this.ostos.lisaaMaaraaYhdella();
        this.ostos.lisaaMaaraaYhdella();
        assertEquals(this.ostos.getMaara(), 4);
    }
    
    @Test
    public void compareToToimii() {
        Ostos aiemminJarjestyksessa = new Ostos(new Tuote("Kinkku", 12, 90), 1);
        assertTrue(this.ostos.compareTo(aiemminJarjestyksessa) > 0);
        
        Ostos myohemminJarjestyksessa = new Ostos(new Tuote("Suola", 2, 45), 1);
        assertTrue(this.ostos.compareTo(myohemminJarjestyksessa) < 0);
    }
    
    @Test
    public void toStringToimii() {
        assertEquals(this.ostos.toString(), "   " + this.maito.toString());
        
        this.ostos.lisaaMaaraaYhdella();
        assertEquals(this.ostos.toString(), "2x " + this.maito.toString());
    }
}
