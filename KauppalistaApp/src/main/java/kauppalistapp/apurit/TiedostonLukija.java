package kauppalistapp.apurit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TiedostonLukija {

    public boolean onkoSisaltoa(String tiedosto) {
        try {
            Scanner lukija = new Scanner(new File(tiedosto));
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public List<String> lueJaAnnaListana(String tiedosto) {
        ArrayList<String> lista = new ArrayList<String>();
        try {
            Scanner lukija = new Scanner(new File(tiedosto));

            while (lukija.hasNextLine()) {
                lista.add(lukija.nextLine());
            }
        } catch (Exception ex) {
            return lista;
        }
        Collections.sort(lista);
        return lista;
    }

    public int riveja(String tiedosto) {
        int riveja = 0;
        try {
            Scanner lukija = new Scanner(new File(tiedosto));

            while (lukija.hasNext()) {
                lukija.nextLine();
                riveja++;
            }
        } catch (Exception ex) {
        }

        return riveja;
    }
    
    public List<String> annaListanaIlmanRiviNumeroa(String tiedostonNimi) {
        List<String> trimmattuLista = new ArrayList<String>();
        for (String trimmattava : this.lueJaAnnaListana(tiedostonNimi)) {
            trimmattuLista.add(trimmattava.split("-")[1].trim());
        }
        return trimmattuLista;
    }
}
