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
 * @ver 0.4
 * 
 * Tuotelista sisältää Tuote-olioita ja Tiedosto-olion
 */
public class Tuotelista{
    
    private List<Tuote> tuoteLista;
    private Tiedosto tiedosto;
    
    /**
     * Tuotelista-olion konstruktori
     * 
     * @param nimi Tuotelistan nimi
     */
    public Tuotelista(String nimi) {
        this.tuoteLista = new ArrayList<Tuote>();
        this.tiedosto = new Tiedosto(nimi);        
    }
    
    /**
     * 
     * Lisaa tuotteen Tuotelistalle
     *
     * @param tuote lisattava tuote
     */
    public void lisaaTuote(Tuote tuote) {
        this.tuoteLista.add(tuote);
    }
    
    /**
     * Poistaa tuotteen Tuotelistalta
     *
     * @param riviNro poistettavan tuotteen rivinumero
     */
    public void poistaTuote(int riviNro) {
        this.tuoteLista.remove(riviNro-1);
    }
    
    /**
     * Antaa Tuotelistan Listan String-olioita
     *
     * @return lista String-olioita
     */
    public List<String> annaListana() {
        List<String> palautettava = new ArrayList<String>();
        for (Tuote listalla : this.tuoteLista) {
            String lisattava = listalla.getNimi() + "#" + listalla.getEurot() + "," + listalla.getSentit();
            palautettava.add(lisattava);
        }
        return palautettava;
    }
    
    /**
     * Tarkistaa onko tuote listalla
     *
     * @param tuote tarkistettava tuote
     * @return true, jos tuote on listalla. False muuten
     */
    public boolean onkoListalla(Tuote tuote) {
        boolean onkoListalla = false;
        for (Tuote listalla : this.tuoteLista) {
            if (listalla.equals(tuote)) {
                onkoListalla = true;
            }
        }
        return onkoListalla;
    }
    
    /**
     * Etsii tuotteita hakusanalla Tuotelistalta
     *
     * @param hakusana
     * @return List löydettyjen tuotteiden rivinumeroista
     */
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
    
    /**
     * Antaa Tuotelistan koon
     *
     * @return koko
     */
    public int annaKoko() {
        return this.tuoteLista.size();
    }
    
    /**
     * Antaa rivin Tuotelistalta
     *
     * @param riviNro
     * @return haettu rivi
     */
    public Tuote annaRivi(int riviNro) {
        return this.tuoteLista.get(riviNro-1);
    }
    
    /**
     * Tyhjentää tuotelistan
     *
     */
    public void tyhjennaTuotelista() {
        this.tuoteLista = new ArrayList<Tuote>();
    }  
    
    /**
     * Järjestää Tuotelistan aakkosjärjestykseen
     *
     */
    public void jarjestaAakkosjarjestykseenNousevasti() {
        Collections.sort(this.tuoteLista);
    }
    
    /**
     * Järjestää Tuotelistan käänteiseen aakkosjärjestykseen
     */
    public void jarjestaAakkosjarjestykseenLaskevasti() {
        jarjestaAakkosjarjestykseenNousevasti();
        Collections.reverse(this.tuoteLista);
    }
}

