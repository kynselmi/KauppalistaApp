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
import java.io.InputStream;
import java.io.ByteArrayInputStream;

/**
 *
 * @author Aleksi
 */
public class LukijaTest {

    private Lukija lukija;

    public LukijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void lukeeString() {        
        String syote = "Pekka";
        System.setIn(new java.io.ByteArrayInputStream(syote.getBytes()));
        String testi = this.lukija.lueTeksti();
        assertEquals(testi, "Pekka");
        
    }
}
