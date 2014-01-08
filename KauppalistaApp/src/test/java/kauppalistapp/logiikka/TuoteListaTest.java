package kauppalistapp.logiikka;

import java.util.List;
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
public class TuoteListaTest {

    private Tuotelista tuotelista;
    private Tuote maito;
    private Tuote kinkku;
    private Tuote juusto;

    public TuoteListaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.tuotelista = new Tuotelista("TuotteetTesti");
        this.maito = new Tuote("Maito", 1, 50);
        this.kinkku = new Tuote("Kinkku", 12, 90);
        this.juusto = new Tuote("Juusto", 3, 50);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void lisaaTuotteen() {
        this.tuotelista.lisaaTuote(this.maito);
        assertEquals(this.tuotelista.annaKoko(), 1);
        assertEquals(this.tuotelista.annaRivi(1), this.maito);
    }

    @Test
    public void antaaKoonOikein() {
        this.tuotelista.lisaaTuote(this.maito);
        assertEquals(this.tuotelista.annaKoko(), 1);

        this.tuotelista.lisaaTuote(this.kinkku);
        assertEquals(this.tuotelista.annaKoko(), 2);

        this.tuotelista.lisaaTuote(this.juusto);
        assertEquals(this.tuotelista.annaKoko(), 3);

        this.tuotelista.lisaaTuote(new Tuote("Leipa", 1, 50));
        this.tuotelista.lisaaTuote(new Tuote("Suola", 2, 40));
        this.tuotelista.lisaaTuote(new Tuote("Pippuri", 0, 95));
        assertEquals(this.tuotelista.annaKoko(), 6);
    }

    @Test
    public void tyhjentaaTuotelistan() {
        this.tuotelista.lisaaTuote(this.maito);
        assertEquals(this.tuotelista.annaKoko(), 1);

        this.tuotelista.tyhjennaTuotelista();
        assertEquals(this.tuotelista.annaKoko(), 0);
    }

    @Test
    public void antaaOikeanRivin() {
        this.tuotelista.lisaaTuote(this.maito);
        this.tuotelista.lisaaTuote(this.kinkku);

        assertEquals(this.tuotelista.annaRivi(1), this.maito);
        assertEquals(this.tuotelista.annaRivi(2), this.kinkku);

        this.tuotelista.lisaaTuote(this.juusto);
        assertEquals(this.tuotelista.annaRivi(3), this.juusto);
    }

    @Test
    public void jarjestaaAakkosjarjestykseen() {
        this.tuotelista.lisaaTuote(maito);
        this.tuotelista.lisaaTuote(this.juusto);
        this.tuotelista.jarjestaAakkosjarjestykseenNousevasti();
        assertEquals(this.tuotelista.annaRivi(1), this.juusto);
        assertEquals(this.tuotelista.annaRivi(2), this.maito);

        this.tuotelista.lisaaTuote(this.kinkku);
        this.tuotelista.jarjestaAakkosjarjestykseenNousevasti();
        assertEquals(this.tuotelista.annaRivi(1), this.juusto);
        assertEquals(this.tuotelista.annaRivi(2), this.kinkku);
        assertEquals(this.tuotelista.annaRivi(3), this.maito);
    }

    @Test
    public void jarjestaaKaanteiseenAakkosjarjestykseen() {
        this.tuotelista.lisaaTuote(this.kinkku);
        this.tuotelista.lisaaTuote(this.maito);
        this.tuotelista.jarjestaAakkosjarjestykseenLaskevasti();
        assertEquals(this.tuotelista.annaRivi(1), this.maito);
        assertEquals(this.tuotelista.annaRivi(2), this.kinkku);

        this.tuotelista.lisaaTuote(this.juusto);
        this.tuotelista.jarjestaAakkosjarjestykseenLaskevasti();
        System.out.println(this.tuotelista.annaRivi(1));
        assertEquals(this.tuotelista.annaRivi(1), this.maito);
        assertEquals(this.tuotelista.annaRivi(2), this.kinkku);
        assertEquals(this.tuotelista.annaRivi(3), this.juusto);
    }

    @Test
    public void poistaaTuotteen() {
        this.tuotelista.lisaaTuote(maito);
        this.tuotelista.poistaTuote(1);
        assertEquals(0, this.tuotelista.annaKoko());

        this.tuotelista.lisaaTuote(maito);
        this.tuotelista.lisaaTuote(this.kinkku);
        this.tuotelista.poistaTuote(1);
        assertEquals(this.tuotelista.annaKoko(), 1);
        assertEquals(this.tuotelista.annaRivi(1), this.kinkku);
    }

    @Test
    public void tarkistaaOnkoListalla() {
        this.tuotelista.lisaaTuote(maito);
        assertTrue(this.tuotelista.onkoListalla(maito));
        assertFalse(this.tuotelista.onkoListalla(this.kinkku));

        this.tuotelista.lisaaTuote(this.kinkku);
        assertTrue(this.tuotelista.onkoListalla(this.kinkku));
        assertFalse(this.tuotelista.onkoListalla(this.juusto));

        this.tuotelista.lisaaTuote(this.juusto);
        assertTrue(this.tuotelista.onkoListalla(this.juusto));
    }

    @Test
    public void etsiiTuotteitaAntaaRiviNumerot() {
        this.tuotelista.lisaaTuote(this.maito);
        List<Integer> loytyneet = this.tuotelista.etsiTuotteita("Maito");
        assertEquals(loytyneet.size(), 1);
        int riviNumero = loytyneet.get(0);
        assertEquals(riviNumero, 1);

        this.tuotelista.lisaaTuote(this.kinkku);
        loytyneet = this.tuotelista.etsiTuotteita("Maito");
        assertEquals(loytyneet.size(), 1);
        riviNumero = loytyneet.get(0);
        assertEquals(riviNumero, 1);
    }
    
    @Test
    public void toStringToimiiOikein() {
        this.tuotelista.lisaaTuote(this.maito);
        assertEquals(this.tuotelista.toString(), "1   Maito 1,50e\n");
        
        this.tuotelista.lisaaTuote(this.kinkku);
        assertEquals(this.tuotelista.toString(), "1   Maito 1,50e\n2   Kinkku 12,90e\n");
        
        this.tuotelista.lisaaTuote(juusto);
        assertEquals(this.tuotelista.toString(), "1   Maito 1,50e\n2   Kinkku 12,90e\n3   Juusto 3,50e\n");
    }
    
    @Test
    public void antaaListana() {
        this.tuotelista.lisaaTuote(maito);
        List<String> lista = this.tuotelista.annaListana();
        assertEquals(lista.get(0), "Maito#1,50");
        
        this.tuotelista.lisaaTuote(juusto);
        this.tuotelista.lisaaTuote(kinkku);
        lista = this.tuotelista.annaListana();
        assertEquals(lista.get(0), "Maito#1,50");
        assertEquals(lista.get(1), "Juusto#3,50");
        assertEquals(lista.get(2), "Kinkku#12,90");        
    }
}
