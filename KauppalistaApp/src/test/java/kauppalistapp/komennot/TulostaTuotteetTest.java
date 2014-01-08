package kauppalistapp.komennot;

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
public class TulostaTuotteetTest extends KomentoTest{
    
    public TulostaTuotteetTest() {
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
    public void tulostaaOikein() {
        Komento komento = new TulostaTuotteet(1, "Testi", super.lukija, super.tallennetutTuotteet, super.tallennetutListat);
        String verrattava = "1  Maito 2,00e\n2  Leipa 1,50e\n3  Liha 2,90e";
        assertEquals(verrattava, super.tallennetutTuotteet.toString());
    }
}
