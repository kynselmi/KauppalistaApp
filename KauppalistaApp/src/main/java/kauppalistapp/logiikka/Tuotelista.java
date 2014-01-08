/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kauppalistapp.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Aleksi
 */
public class Tuotelista{
    
    private List<Tuote> tuoteLista;
    private Tiedosto tiedosto;
    
    public Tuotelista(String nimi) {
        this.tuoteLista = new ArrayList<Tuote>();
        this.tiedosto = new Tiedosto(nimi);        
    }
    
    public void lisaaTuote(Tuote tuote) {
        this.tuoteLista.add(tuote);
    }
    
    public void poistaTuote(int riviNro) {
        this.tuoteLista.remove(riviNro-1);
    }
    
    public List<String> annaListana() {
        List<String> palautettava = new ArrayList<String>();
        for (Tuote listalla : this.tuoteLista) {
            String lisattava = listalla.getNimi() + "#" + listalla.getEurot() + "," + listalla.getSentit();
            palautettava.add(lisattava);
        }
        return palautettava;
    }
    
    public boolean onkoListalla(Tuote tuote) {
        boolean onkoListalla = false;
        for (Tuote listalla : this.tuoteLista) {
            if (listalla.equals(tuote)) {
                onkoListalla = true;
            }
        }
        return onkoListalla;
    }
    
    public List<Integer> etsiTuotteita(String hakusana) {
        List<Integer> palautettava = new ArrayList<Integer>();
        for (int i = 0; i < this.annaKoko(); i++) {
            if (this.tuoteLista.get(i).toString().contains(hakusana)) {
                palautettava.add(i+1);
            }
        }
        return palautettava;
    }
    
    @Override
    public String toString() {
        int riviNro = 1;
        String palautettava = "";
        for (Tuote listalla : this.tuoteLista) {
            palautettava += riviNro + " " + listalla.toString() + "\n";
            riviNro++;
        }
        return palautettava;
    }

    public Tiedosto getTiedosto() {
        return tiedosto;
    }
    
    public int annaKoko() {
        return this.tuoteLista.size();
    }
    
    public Tuote annaRivi(int riviNro) {
        return this.tuoteLista.get(riviNro-1);
    }
    
    public void tyhjennaTuotelista() {
        this.tuoteLista = new ArrayList<Tuote>();
    }  
    
    public void jarjestaAakkosjarjestykseenNousevasti() {
        Collections.sort(this.tuoteLista);
    }
    
    public void jarjestaAakkosjarjestykseenLaskevasti() {
        jarjestaAakkosjarjestykseenNousevasti();
        Collections.reverse(this.tuoteLista);
    }
}

