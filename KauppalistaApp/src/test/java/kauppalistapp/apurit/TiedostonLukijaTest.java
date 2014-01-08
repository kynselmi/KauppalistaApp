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
import kauppalistapp.logiikka.Tiedosto;

/**
 *
 * @author Aleksi
 */
public class TiedostonLukijaTest {
    
    private TiedostonLukija tl;
    
    public TiedostonLukijaTest() {
    }
    
    @Before
    public void setUp() {
        this.tl = new TiedostonLukija();
    }

    @Test
    public void lukeeYhdenRivinTiedostosta() {
        List<String> lista = this.tl.lueJaAnnaListana(new Tiedosto("yhdenRivinLuettava"));
        assertEquals("testing", lista.get(0));
    }
    
    @Test
    public void lukeeUseammanRivinTiedostosta() {
        List<String> lista = this.tl.lueJaAnnaListana(new Tiedosto("useammanRivinLuettava"));
        assertEquals("testi1", lista.get(0));
        assertEquals("testi2", lista.get(1));
    }
    
    @Test
    public void eiKaaduJosEiLoydyTiedostoaLuettaessa() {
        this.tl.lueJaAnnaListana(new Tiedosto("tatatiedostoaeiole"));
    }
    
    @Test
    public void eiKaaduJosEiLoydyTiedostoaRiveja() {
        this.tl.riveja(new Tiedosto("tatatiedostoaeiole"));
    }
    
    @Test
    public void eiKaaduJoseiLoydyTiedostoaOnkoSisaltoa() {
        this.tl.onkoSisaltoa(new Tiedosto("tatatiedostoaeiole"));
    }
    
    @Test
    public void antaaOikeanRivimaaranYksi() {
        assertEquals(this.tl.riveja(new Tiedosto("yhdenRivinLuettava")), 1);
    }
    
    @Test
    public void antaaOikeanRivimaaranUseampi() {
        assertEquals(this.tl.riveja(new Tiedosto("useammanRivinLuettava")), 2);
    }

}
