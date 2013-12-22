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
import java.util.ArrayList;

/**
 *
 * @author Aleksi
 */
public class TiedostonKirjoittajaTest {

    private TiedostonKirjoittaja tk;
    private TiedostonLukija tl;

    public TiedostonKirjoittajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.tk = new TiedostonKirjoittaja();
        this.tl = new TiedostonLukija();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void uuteenTiedostoonKirjoittaminenToimii() {
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("testi");
        String tiedostonNimi = "testiTiedosto.txt";
        this.tk.kirjoitaTiedostoon(lista, tiedostonNimi);
        assertEquals("1 - testi", this.tl.lueJaAnnaListana(tiedostonNimi).get(0));
    }

    @Test
    public void vanhaanTiedostoonKirjoitetaanOikein() {
        this.tk.tyhjennaTiedosto("testi2.txt");
        ArrayList<String> vanhaTavara = new ArrayList<String>();        
        vanhaTavara.add("Testi");
        vanhaTavara.add("Test");
        vanhaTavara.add("T");
            
        this.tk.kirjoitaTiedostoon(vanhaTavara, "testi2.txt");        
        
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("lisattavaa");
        String tiedostonNimi = "testi2.txt";
        this.tk.kirjoitaTiedostoon(lista, tiedostonNimi);
        List<String> ListaTiedostosta = this.tl.lueJaAnnaListana(tiedostonNimi);
        assertEquals("1 - Testi", ListaTiedostosta.get(0));
        assertEquals("2 - Test", ListaTiedostosta.get(1));
        assertEquals("3 - T", ListaTiedostosta.get(2));
        assertEquals("4 - lisattavaa", ListaTiedostosta.get(3));
    }
    
    @Test
    public void eiKaaduJosTiedostoaEiLoydyTyhjennettaessa() {
        this.tk.tyhjennaTiedosto("tataeioleolemassa.txt");        
    }
    

}
