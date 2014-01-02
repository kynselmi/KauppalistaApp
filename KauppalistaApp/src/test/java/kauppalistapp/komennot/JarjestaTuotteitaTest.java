package kauppalistapp.komennot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import kauppalistapp.logiikka.Tiedosto;
import kauppalistapp.apurit.TiedostonLukija;
import kauppalistapp.apurit.Lukija;
import java.util.List;
import java.util.ArrayList;
import kauppalistapp.logiikka.Lista;
import Testiapu.SyoteJaTulostusApuri;

public class JarjestaTuotteitaTest {

    private Tiedosto tuoteListaTesti;
    private Komento komento;
    private Lukija lukija;
    private List<Lista> tallennetutListat;
    private SyoteJaTulostusApuri SJTApuri;
    private TiedostonLukija tl;

    public JarjestaTuotteitaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.tuoteListaTesti = new Tiedosto("TuotteetTesti");
        this.lukija = new Lukija();
        this.tallennetutListat = new ArrayList<Lista>();
        this.komento = new JarjestaTuotteita(1, "Testi", this.lukija, this.tuoteListaTesti, this.tallennetutListat);
        this.SJTApuri = new SyoteJaTulostusApuri();
        this.tl = new TiedostonLukija();
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void jarjestaaLaskevasti() {
        System.setIn(this.SJTApuri.otaSyote("1"));
        this.komento.suorita();
        
        List<String> jarjestettavaLista = this.tl.annaListanaIlmanRiviNumeroa(this.tuoteListaTesti.getTiedosto());
        assertEquals(jarjestettavaLista.get(0), "1 - Kinkku, 30,50e");
    }
}
