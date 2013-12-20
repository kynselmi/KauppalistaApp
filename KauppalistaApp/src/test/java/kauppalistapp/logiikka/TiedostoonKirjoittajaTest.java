package kauppalistapp.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

public class TiedostoonKirjoittajaTest {

    private TiedostoonKirjoittaja tk;
    private Scanner lukija;
    private File listatiedosto;
    private List<Tuote> lista;

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
        this.listatiedosto = new File("PekanLista.txt");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kirjoittaaTekstitiedostoonListasta() throws FileNotFoundException {
        this.lukija = new Scanner(this.listatiedosto);
        this.lista = new ArrayList<Tuote>();
        lista.add(new Tuote("Maito"));
        this.tk.kirjoitaTuotelistastaList(lista);
        assertEquals(this.lukija.nextLine(), "Maito");
    }

    @Test
    public void kirjoittaaTekstitiedostoonMapista() throws FileNotFoundException {
        Map<Tuote, Integer> lista = new HashMap<Tuote, Integer>();
        lista.put(new Tuote("Maito"), 3);
        try {
            this.tk.kirjoitaTuotelistastaMap(lista);
        } catch (Exception Ex) {
        }
        this.lukija = new Scanner(this.listatiedosto);
        assertEquals(this.lukija.nextLine(), "3x Maito");
    }
    
    @Test
    public void kirjoittaaUseammanRivinOikeinListasta() throws FileNotFoundException {
        this.lista = new ArrayList<Tuote>();
        this.lista.add(new Tuote("Maito"));
        this.lista.add(new Tuote("Leipä",2));
        this.tk.kirjoitaTuotelistastaList(lista);
        this.lukija = new Scanner(this.listatiedosto);
        assertEquals(this.lukija.nextLine(), "Maito");
        assertEquals(this.lukija.nextLine(), "Leipä, 2.0e");
    }
    
}