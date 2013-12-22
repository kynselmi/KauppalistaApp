package kauppalistapp.komennot;

import kauppalistapp.apurit.Lukija;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EtsiTuoteTest {

    private Komento komento;
    private Lukija lukija;

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
        this.komento = new EtsiTuote(1, "Testaa", this.lukija);        
    }

    @After
    public void tearDown() {
    }

}
