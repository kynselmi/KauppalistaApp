package kauppalistapp.apurit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class TiedostonKirjoittaja {

    private FileWriter kirjoittaja;
    private String tiedosto;

    public TiedostonKirjoittaja(String tiedosto) throws IOException {
        this.tiedosto = tiedosto;
        this.kirjoittaja = new FileWriter(this.tiedosto);
    }

    public void kirjoitaTiedostoon(List<String> lista) throws FileNotFoundException, IOException {
        TiedostonLukija tiedostonlukija = new TiedostonLukija(this.tiedosto);
         int jarjestysluku = tiedostonlukija.riveja() + 1;
         ArrayList<String> kirjoitettavatRivit = new ArrayList<String>();

        if (tiedostonlukija.onkoSisaltoa()) {
            
            for (String vanhaTieto : tiedostonlukija.lueJaAnnaListana()) {
                kirjoitettavatRivit.add(vanhaTieto);
            }
        }
        for (String uusiTieto : lista) {
            kirjoitettavatRivit.add(jarjestysluku + " " + uusiTieto);
            jarjestysluku++;
        }
        for (String kirjoitettava : kirjoitettavatRivit) {
            this.kirjoittaja.write(kirjoitettava);
        }
    }

    public String getTiedosto() {
        return this.tiedosto;
    }
}
