package kauppalistapp.apurit;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tiedosto;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class TiedostonKirjoittaja {

    private FileWriter kirjoittaja;
    private TiedostonLukija tiedostonlukija;

    /**
     * TiedostonKirjoittaja-olion konstruktori
     */
    public TiedostonKirjoittaja() {
        this.tiedostonlukija = new TiedostonLukija();
    }

    /**
     * Kirjoittaa tekstitiedostoon
     *
     * @param kirjoitettavaLista tulostettava teksti listamuodossa
     * @param tiedostonNimi kirjoitettavan tiedoston nimi
     */
    public void kirjoitaTiedostoon(List<String> kirjoitettavaLista, Tiedosto tiedosto) {
        ArrayList<String> kirjoitettavatRivit = new ArrayList<String>();

        if (this.tiedostonlukija.onkoSisaltoa(tiedosto)) {
            List<String> vanhaLista = this.tiedostonlukija.annaListanaIlmanRiviNumeroa(tiedosto);
            for (String vanhaTieto : vanhaLista) {
                try {
                    kirjoitettavatRivit.add(vanhaTieto);
                } catch (Exception ex) {
                }
            }
        }

        for (String uusiTieto : kirjoitettavaLista) {
            kirjoitettavatRivit.add(uusiTieto);
        }
        try {
            this.kirjoittaja = new FileWriter(tiedosto.getTiedosto());
        } catch (Exception poikkeus) {
        }
        String kirjoitettavaTeksti = "";
        int riviNumero = 1;
        for (String kirjoitettava : kirjoitettavatRivit) {
            String[] kirjoitettavaLeikattu = kirjoitettava.split("#");
            String kirjoitettavaRivi = "";
            kirjoitettavaRivi += riviNumero;

            kirjoitettavaRivi += "@" + kirjoitettavaLeikattu[0];


            if (kirjoitettavaLeikattu.length > 1) {
                kirjoitettavaRivi += "#" + kirjoitettavaLeikattu[1];
            }
            if (kirjoitettavaLeikattu.length > 2) {
                kirjoitettavaRivi += "#" + kirjoitettavaLeikattu[2];
            }
            if (kirjoitettavaLeikattu.length > 3) {
                kirjoitettavaRivi += "#" + kirjoitettavaLeikattu[3];
            }
            riviNumero++;
            kirjoitettavaRivi += "\n";
            kirjoitettavaTeksti += kirjoitettavaRivi;
        }
        try {
            this.kirjoittaja.write(kirjoitettavaTeksti);
            this.kirjoittaja.close();
        } catch (IOException ex) {
        }
    }

    public void kirjoitaTiedostoonOstoslista(Ostoslista ostoslista, Tiedosto tiedosto) throws IOException {
        List<String> kirjoitettava = new ArrayList<String>();
        for (String listalla : ostoslista.annaListana()) {
            kirjoitettava.add(listalla);
        }
        
        tyhjennaTiedosto(tiedosto);
        
        this.kirjoittaja = new FileWriter(tiedosto.getTiedosto());
       
        for (String kirjoitettavaRivi : kirjoitettava) {
            this.kirjoittaja.write(kirjoitettavaRivi + "\n");
        }
        
        this.kirjoittaja.close();
    }

    /**
     * Tyhjentaa tekstitiedoston
     *
     * @param tiedostonNimi Tyhjennettavan tiedoston nimi
     */
    public void tyhjennaTiedosto(Tiedosto tiedosto) {
        try {
            this.kirjoittaja = new FileWriter(tiedosto.getTiedosto());
            this.kirjoittaja.write("");
        } catch (Exception ex) {
            System.out.println("Tiedostoa ei löytynyt");
        }
    }
}
