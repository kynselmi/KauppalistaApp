/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kauppalistapp.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aleksika
 */
public class ListaTest {

    private Lista testiLista;

    public ListaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.testiLista = new Lista("testi");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void listalleLisaaminenOnnistuu() {
        Tuote testituote = new Tuote("Testituote");
        this.testiLista.lisaaListalle(testituote);
        int maara = testiLista.getMaaranTietavaLista().get(testituote);
        assertEquals(maara, 1);
    }

    @Test
    public void listalleLisataanOikeinKunTuoteOnJoListalla() {
        Tuote testituote = new Tuote("Testituote");
        this.testiLista.lisaaListalle(testituote);
        this.testiLista.lisaaListalle(testituote);
        int maara = testiLista.getMaaranTietavaLista().get(testituote);
        assertEquals(maara, 2);
    }
 
}