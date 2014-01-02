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


    
}
