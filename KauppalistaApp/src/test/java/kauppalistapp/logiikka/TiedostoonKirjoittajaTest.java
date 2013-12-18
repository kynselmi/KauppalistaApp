package kauppalistapp.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import kauppalistapp.logiikka.Tuote;
import java.util.Scanner;


public class TiedostoonKirjoittajaTest {
    
    private TiedostoonKirjoittaja tk;
    private Scanner lukija;
    
    public TiedostoonKirjoittajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.tk = new TiedostoonKirjoittaja("PekanLista");
        this.lukija = new Scanner("PekanLista.txt");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void kirjoittaaTekstitiedostoon() {
        List<Tuote> lista = new ArrayList<Tuote>();
        lista.add(new Tuote("Maito"));
        this.tk.kirjoitaTuoteListastaListMuodossa(lista);
        assertEquals(this.lukija.nextLine(), "Maito");
    }

}