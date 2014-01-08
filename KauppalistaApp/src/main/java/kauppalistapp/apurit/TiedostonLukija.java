package kauppalistapp.apurit;

import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import kauppalistapp.logiikka.Ostos;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tiedosto;
import kauppalistapp.logiikka.Tuote;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 * 
 * Lukee Tiedosto-olion tekstitiedostosta tekstiä
 */
public class TiedostonLukija {

    /**
     * Tarkistaa onko tiedostossa tekstiä
     *
     * @param tiedosto luettava tiedosto
     * @return true, jos tiedostossa on sisaltoa, muuten false.
     */
    public boolean onkoSisaltoa(Tiedosto tiedosto) {
        try {
            Scanner lukija = new Scanner(tiedosto.getTiedosto());
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    /**
     * Lukee annetun tiedoston
     *
     * @param tiedosto Luettava tiedosto
     * @return Luettu teksti listamuodossa
     */
    public List<String> lueJaAnnaListana(Tiedosto tiedosto) {
        ArrayList<String> lista = new ArrayList<String>();
        try {
            Scanner lukija = new Scanner(tiedosto.getTiedosto());

            while (lukija.hasNextLine()) {
                lista.add(lukija.nextLine());
            }
        } catch (Exception ex) {
            return lista;
        }
        Collections.sort(lista);
        return lista;
    }

    /**
     * Antaa tiedoston rivimäärän
     *
     * @param tiedosto Luettava tiedosto
     * @return tiedoston rivimäärä
     */
    public int riveja(Tiedosto tiedosto) {
        int riveja = 0;
        try {
            Scanner lukija = new Scanner(tiedosto.getTiedosto());

            while (lukija.hasNext()) {
                lukija.nextLine();
                riveja++;
            }
        } catch (Exception ex) {
        }

        return riveja;
    }

    /**
     * Antaa tiedoston listamuodossa ilman rivi numeroita
     *
     * @param tiedostonNimi Luettavan tiedoston nimi
     * @return List-olio, jossa jokainen rivi tiedostosta on yhdellä rivillä
     * taulukossa
     */
    public List<String> annaListanaIlmanRiviNumeroa(Tiedosto tiedostonNimi) {
        List<String> trimmattuLista = new ArrayList<String>();
        try {
            for (String trimmattava : this.lueJaAnnaListana(tiedostonNimi)) {  
                String leikattu = trimmattava.split("@")[1].trim();
                trimmattuLista.add(leikattu);
            }
        } catch (Exception ex) {
        }        
        return trimmattuLista;
    }
    
    /**
     * Antaa tallennetusta Tiedosto-oliosta tekstimuotoisen esityksen ja muuntaa sen listaksi Tuotteita
     *
     * @param tiedosto Tiedosto, jossa haluttu lista Tuotteita Stringinä
     * @return Lista Tuote-olioita
     */
    public List<Tuote> annaTuoteListana(Tiedosto tiedosto) {
        List<Tuote> tuoteLista = new ArrayList<Tuote>();
        for (String listalla : this.annaListanaIlmanRiviNumeroa(tiedosto)) {
            String[] paloiteltu = listalla.split("#");
            Tuote lisattavaTuote = new Tuote(paloiteltu[0]);
            if (paloiteltu.length == 2) {
                lisattavaTuote.setHinta(Integer.parseInt(paloiteltu[1].split(",")[0]), Integer.parseInt(paloiteltu[1].split(",")[1]));
            }
            tuoteLista.add(lisattavaTuote);
        }
        return tuoteLista;
    }
    
    /**
     * Lukee Tiedosto-oliosta tallennetut Ostos-oliot ja antaa ne Ostoslistana
     * 
     *
     * @param tiedosto Tiedosto, jossa haluttu tekstitiedosto Ostoslistaksi muunnettavaksi
     * @return Ostoslista muodossa lista Ostos-olioita
     */
    public Ostoslista annaOstoslistana(Tiedosto tiedosto) {
        Ostoslista ostoslista = new Ostoslista(tiedosto.getNimi());
        for (String listalla : this.lueJaAnnaListana(tiedosto)) {
            String[] listallaLeikattuna = listalla.split("#");
            Ostos ostos = new Ostos(new Tuote(listallaLeikattuna[1]), Integer.parseInt(listallaLeikattuna[0]));            
            if (listallaLeikattuna.length>2) {
                ostos.getTuote().setHinta(Integer.parseInt(listallaLeikattuna[2].split(",")[0]), Integer.parseInt(listallaLeikattuna[2].split(",")[1]));
            }
            ostoslista.lisaaOstos(ostos);
        }
        return ostoslista;
    }
    

}
