package kauppalistapp.apurit;

import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class TiedostonLukija {

    /**
     * Tarkistaa onko tiedostossa tekstiä
     *
     * @param tiedosto luettava tiedosto
     * @return true, jos tiedostossa on sisaltoa, muuten false.
     */
    public boolean onkoSisaltoa(File tiedosto) {
        try {
            Scanner lukija = new Scanner(tiedosto);
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
    public List<String> lueJaAnnaListana(File tiedosto) {
        ArrayList<String> lista = new ArrayList<String>();
        try {
            Scanner lukija = new Scanner(tiedosto);

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
    public int riveja(File tiedosto) {
        int riveja = 0;
        try {
            Scanner lukija = new Scanner(tiedosto);

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
    public List<String> annaListanaIlmanRiviNumeroa(File tiedostonNimi) {
        List<String> trimmattuLista = new ArrayList<String>();
        try {
            for (String trimmattava : this.lueJaAnnaListana(tiedostonNimi)) {  
                String leikattu = trimmattava.split("-")[1].trim();
                trimmattuLista.add(leikattu);
            }
        } catch (Exception ex) {
        }
        
        return trimmattuLista;
    }
}
