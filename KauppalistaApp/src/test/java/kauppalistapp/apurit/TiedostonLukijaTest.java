/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kauppalistapp.apurit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

/**
 *
 * @author Aleksi
 */
public class TiedostonLukijaTest {
    
    private TiedostonLukija tl;
    
    public TiedostonLukijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.tl = new TiedostonLukija();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lukeeYhdenRivinTiedostosta() {
        List<String> lista = this.tl.lueJaAnnaListana("yhdenRivinLuettava.txt");
        assertEquals("testing", lista.get(0));
    }
    
    @Test
    public void lukeeUseammanRivinTiedostosta() {
        List<String> lista = this.tl.lueJaAnnaListana("useammanRivinLuettava.txt");
        assertEquals("testi1", lista.get(0));
        assertEquals("testi2", lista.get(1));
    }
    
    @Test
    public void eiKaaduJosEiLoydyTiedostoaLuettaessa() {
        this.tl.lueJaAnnaListana("tatatiedostoaeiole.txt");
    }
    
    @Test
    public void eiKaaduJosEiLoydyTiedostoaRiveja() {
        this.tl.riveja("tatatiedostoaeiole.txt");
    }
    
    @Test
    public void eiKaaduJoseiLoydyTiedostoaOnkoSisaltoa() {
        this.tl.onkoSisaltoa("tatatiedostoaeiole.txt");
    }
}
