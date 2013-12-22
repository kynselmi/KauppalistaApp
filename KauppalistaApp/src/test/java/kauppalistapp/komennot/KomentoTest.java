package kauppalistapp.komennot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import kauppalistapp.apurit.Lukija;

public class KomentoTest {
    
    private Komento komento;
    private Lukija lukija;

    public KomentoTest() {
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
        this.komento = new LisaaListalle(1, "simo", this.lukija);
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void toStringOikein() {
        assertEquals(this.komento.toString(), "1 simo");
    }
}
