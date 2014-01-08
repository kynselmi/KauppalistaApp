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
import kauppalistapp.logiikka.Tiedosto;

/**
 *
 * @author Aleksi
 */
public class TiedostonKirjoittajaTest {

    private TiedostonKirjoittaja tk;
    private TiedostonLukija tl;
    private Tiedosto tiedosto;

    @Before
    public void setUp() {
        this.tk = new TiedostonKirjoittaja();
        this.tl = new TiedostonLukija();
        this.tiedosto = new Tiedosto("Testi");
    }

    @Test
    public void uuteenTiedostoonKirjoittaminenToimii() {
        this.tk.tyhjennaTiedosto(this.tiedosto);
        List<String> lista = new ArrayList<String>();
        lista.add("testi");
        this.tk.kirjoitaTiedostoon(lista, this.tiedosto);
        assertEquals("1@testi", this.tl.lueJaAnnaListana(this.tiedosto).get(0));
    }

    @Test
    public void vanhaanTiedostoonKirjoitetaanOikein() {
        this.tk.tyhjennaTiedosto(new Tiedosto("testi2"));
        ArrayList<String> vanhaTavara = new ArrayList<String>();        
        vanhaTavara.add("Testi");
        vanhaTavara.add("Test");
        vanhaTavara.add("T");
        
        this.tiedosto = new Tiedosto("testi2");
        this.tk.kirjoitaTiedostoon(vanhaTavara, new Tiedosto("testi2"));        
        
        List<String> lista = new ArrayList<String>();
        lista.add("lisattavaa");
        String tiedostonNimi = "testi2";
        this.tk.kirjoitaTiedostoon(lista, new Tiedosto(tiedostonNimi));
        List<String> ListaTiedostosta = this.tl.lueJaAnnaListana(this.tiedosto);
        assertEquals("1@Testi", ListaTiedostosta.get(0));
        assertEquals("2@Test", ListaTiedostosta.get(1));
        assertEquals("3@T", ListaTiedostosta.get(2));
        assertEquals("4@lisattavaa", ListaTiedostosta.get(3));
    }
    
    
    @Test
    public void tyhjentaaTiedoston() {
       this.tiedosto = new Tiedosto("testi3");
       List<String> lisattava = new ArrayList<String>();
       lisattava.add("tyhjennettava");
       
       this.tk.kirjoitaTiedostoon(lisattava, this.tiedosto);
    }
    

}
