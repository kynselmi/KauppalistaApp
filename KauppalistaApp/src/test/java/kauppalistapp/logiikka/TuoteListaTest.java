package kauppalistapp.logiikka;

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
        this.tuotelista = new Tuotelista("TuotteetTesti");
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
        this.tuotelista = new Tuotelista("TuotteetTesti");
        this.tuotelista.lisaaTuote(this.maito);
        assertEquals(this.tuotelista.annaKoko(), 1);

        this.tuotelista.tyhjennaTuotelista();
        assertEquals(this.tuotelista.annaKoko(), 0);
    }

    @Test
    public void antaaOikeanRivin() {
        this.tuotelista = new Tuotelista("TuotteetTesti");
        this.tuotelista.lisaaTuote(this.maito);
        this.tuotelista.lisaaTuote(this.kinkku);

        assertEquals(this.tuotelista.annaRivi(1), this.maito);
        assertEquals(this.tuotelista.annaRivi(2), this.kinkku);

        this.tuotelista.lisaaTuote(this.juusto);
        assertEquals(this.tuotelista.annaRivi(3), this.juusto);
    }

    @Test
    public void jarjestaaAakkosjarjestykseen() {
        this.tuotelista = new Tuotelista("TuotteetTesti");
        this.tuotelista.lisaaTuote(maito);
        this.tuotelista.lisaaTuote(juusto);
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
        this.tuotelista = new Tuotelista("TuotteetTesti");
        this.tuotelista.lisaaTuote(this.kinkku);
        this.tuotelista.lisaaTuote(this.maito);
        this.tuotelista.jarjestaAakkosjarjestykseenLaskevasti();
        assertEquals(this.tuotelista.annaRivi(1), this.maito);
        assertEquals(this.tuotelista.annaRivi(2), this.kinkku);

        this.tuotelista.lisaaTuote(juusto);
        this.tuotelista.jarjestaAakkosjarjestykseenLaskevasti();
        assertEquals(this.tuotelista.annaRivi(1), this.maito);
        assertEquals(this.tuotelista.annaRivi(2), this.kinkku);
        assertEquals(this.tuotelista.annaRivi(3), this.juusto);


    }
}
