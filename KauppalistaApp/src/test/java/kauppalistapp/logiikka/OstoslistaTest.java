/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kauppalistapp.logiikka;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aleksi
 */
public class OstoslistaTest {

    private Ostoslista ostoslista;
    private Ostos kaksiMaitoa;
    private Ostos kinkku;

    public OstoslistaTest() {
    }

    @Before
    public void setUp() {
        this.ostoslista = new Ostoslista("Testilista");
        this.kaksiMaitoa = new Ostos(new Tuote("Maito", 1, 50), 2);
        this.kinkku = new Ostos(new Tuote("Kinkku", 12, 5), 1);
    }

    @Test
    public void equalsMetodiToimii() {
        assertTrue(this.ostoslista.compareTo(new Ostoslista("Testilista")) == 0);
        assertFalse(this.ostoslista.compareTo(new Ostoslista("erilista")) == 0);
    }

    @Test
    public void OstoslistalleLisaysToimii() {
        this.ostoslista.lisaaOstos(this.kaksiMaitoa);
        assertEquals(this.ostoslista.getOstoslista().get(0), this.kaksiMaitoa);

        this.ostoslista.lisaaOstos(this.kinkku);
        assertEquals(this.ostoslista.getOstoslista().get(0), this.kaksiMaitoa);
        assertEquals(this.ostoslista.getOstoslista().get(1), this.kinkku);
    }

    @Test
    public void antaaOikeanTuotteidenMaaran() {
        this.ostoslista.lisaaOstos(this.kaksiMaitoa);
        assertEquals(this.ostoslista.annaTuotteidenMaara(), 2);

        this.ostoslista.lisaaOstos(this.kinkku);
        System.out.println("kinkun määrä: " + this.kinkku.getMaara());
        assertEquals(this.ostoslista.annaTuotteidenMaara(), 3);

        this.ostoslista.lisaaOstos(this.kinkku);
        this.ostoslista.lisaaOstos(this.kinkku);
        assertEquals(this.ostoslista.annaTuotteidenMaara(), 6);

    }

    @Test
    public void antaaKokonaishinnan() {
        this.ostoslista.lisaaOstos(this.kaksiMaitoa);
        assertEquals(this.ostoslista.kokonaisHinta(), "3,00e");

        this.ostoslista.lisaaOstos(this.kinkku);
        assertEquals(this.ostoslista.kokonaisHinta(), "15,05e");

        this.ostoslista.lisaaOstos(this.kaksiMaitoa);
        assertEquals(this.ostoslista.kokonaisHinta(), "18,05e");
    }

    @Test
    public void antaaListanaOikein() {
        this.ostoslista.lisaaOstos(this.kaksiMaitoa);
        List<String> lista = this.ostoslista.annaListana();
        assertEquals(lista.get(0), "2#Maito#1,50");
                
        this.ostoslista.lisaaOstos(this.kaksiMaitoa);
        lista = this.ostoslista.annaListana();
        assertEquals(lista.get(0), "4#Maito#1,50");
        
        this.ostoslista.lisaaOstos(this.kinkku);
        lista = this.ostoslista.annaListana();
        assertEquals(lista.get(0), "4#Maito#1,50");
        assertEquals(lista.get(1), "1#Kinkku#12,5");        
    }
    
    @Test
    public void toStringToimii() {
        this.ostoslista.lisaaOstos(this.kaksiMaitoa);
        assertEquals(this.ostoslista.toString(), "2x   Maito 1,50e\n");
        
        this.ostoslista.lisaaOstos(this.kinkku);
        assertEquals(this.ostoslista.toString(), "2x   Maito 1,50e\n     Kinkku 12,05e\n");
    }
}
