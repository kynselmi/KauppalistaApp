package kauppalistapp.apurit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import kauppalistapp.logiikka.Tiedosto;

public class TiedostonKirjoittaja {

    private FileWriter kirjoittaja;
    private TiedostonLukija tiedostonlukija;
    private Tiedosto tiedosto;

    public TiedostonKirjoittaja() {
        this.tiedostonlukija = new TiedostonLukija();
    }

    public void kirjoitaTiedostoon(List<String> lista, String tiedostonNimi) {
        //try {
        //    jarjestysluku = this.tiedostonlukija.riveja(tiedostonNimi) + 1;
        //} catch (Exception ex) {
        //}
        this.tiedosto = new Tiedosto(tiedostonNimi);
        ArrayList<String> kirjoitettavatRivit = new ArrayList<String>();

        if (this.tiedostonlukija.onkoSisaltoa(this.tiedosto.getTiedosto())) {
            List<String> vanhaLista = this.tiedostonlukija.lueJaAnnaListana(this.tiedosto.getTiedosto());
            for (String vanhaTieto : vanhaLista) {
                try {
                    kirjoitettavatRivit.add(vanhaTieto.split("-")[1].trim());
                } catch (Exception ex) {
                }
            }
        }

        for (String uusiTieto : lista) {
            kirjoitettavatRivit.add(uusiTieto);
        }
        try {
            this.kirjoittaja = new FileWriter(this.tiedosto.getTiedosto());
        } catch (Exception poikkeus) {
        }
        int riviNumero = 1;
        for (String kirjoitettava : kirjoitettavatRivit) {
            try {
                this.kirjoittaja.write(riviNumero + " - " + kirjoitettava + "\n");
                riviNumero++;
            } catch (Exception ex) {
            }
        }
        try {
            this.kirjoittaja.close();
        } catch (Exception ex) {
        }
    }

    public void tyhjennaTiedosto(String tiedostonNimi) {
        this.tiedosto = new Tiedosto(tiedostonNimi);
        try {
            this.kirjoittaja = new FileWriter(this.tiedosto.getTiedosto());
            this.kirjoittaja.write("");
        } catch (Exception ex) {
            System.out.println("Tiedostoa ei löytynyt");
        }
    }
}
