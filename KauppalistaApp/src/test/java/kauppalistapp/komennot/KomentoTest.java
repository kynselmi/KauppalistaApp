package kauppalistapp.komennot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import kauppalistapp.apurit.Lukija;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tiedosto;
import java.util.List;
import java.util.ArrayList;

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
//    public void setUp() {
//        this.lukija = new Lukija();
//        Ostoslista lista = new Ostoslista("tallennetutListatTesti");
//        List<Ostoslista> listat = new ArrayList<Ostoslista>();
//        listat.add(lista);
//        Tiedosto testiTuotteet = new Tiedosto("testiTuotteet");
//        this.komento = new LisaaListalle(1, "simo", this.lukija, testiTuotteet, listat);
//    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void toStringOikein() {
        assertEquals(this.komento.toString(), "1 simo");
    }
}
