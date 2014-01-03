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
import kauppalistapp.logiikka.Ostoslista;
import Testiapu.SyoteJaTulostusApuri;

public class JarjestaTuotteitaTest {

    private Tiedosto tuoteListaTesti;
    private Komento komento;
    private Lukija lukija;
    private Tiedosto tallennetutListatTiedosto;
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
        this.tallennetutListatTiedosto = new Tiedosto("TallennetutListatTesti");
        this.komento = new JarjestaTuotteita(1, "Testi", this.lukija, this.tuoteListaTesti, this.tallennetutListatTiedosto);
        this.SJTApuri = new SyoteJaTulostusApuri();
        this.tl = new TiedostonLukija();
    }

    @After
    public void tearDown() {
    }
    

    
}
