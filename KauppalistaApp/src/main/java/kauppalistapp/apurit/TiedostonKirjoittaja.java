package kauppalistapp.apurit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class TiedostonKirjoittaja {

    private FileWriter kirjoittaja;
    private TiedostonLukija tiedostonlukija;

    public TiedostonKirjoittaja() {
        this.tiedostonlukija = new TiedostonLukija();
    }

    public void kirjoitaTiedostoon(List<String> lista, String tiedostonNimi) {
        int jarjestysluku = 1;
        try {
            jarjestysluku = this.tiedostonlukija.riveja(tiedostonNimi) + 1;
        } catch (Exception ex) {
        }

        ArrayList<String> kirjoitettavatRivit = new ArrayList<String>();

        if (this.tiedostonlukija.onkoSisaltoa(tiedostonNimi)) {
            for (String vanhaTieto : this.tiedostonlukija.lueJaAnnaListana(tiedostonNimi)) {
                kirjoitettavatRivit.add(vanhaTieto);
            }
        }
        for (String uusiTieto : lista) {
            kirjoitettavatRivit.add(jarjestysluku + " " + uusiTieto);
            jarjestysluku++;
        }
        try {
            this.kirjoittaja = new FileWriter(tiedostonNimi);
        } catch (Exception poikkeus) {
        }
        for (String kirjoitettava : kirjoitettavatRivit) {
            try {
                this.kirjoittaja.write(kirjoitettava + "\n");
            } catch (Exception ex) {
            }
        }
        try {
            this.kirjoittaja.close();
        } catch (Exception ex) {
        }
    }

    public void tyhjennaTiedosto(String tiedostonNimi) {
        try {
            this.kirjoittaja = new FileWriter(tiedostonNimi);
            this.kirjoittaja.write("");
        } catch (Exception ex) {
            System.out.println("Tiedostoa ei löytynyt");
        }
    }
}
