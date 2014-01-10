/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kauppalistapp.komennot;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kauppalistapp.apurit.Lukija;
import kauppalistapp.apurit.TiedostonLukija;
import kauppalistapp.kayttoliittyma.IO;
import kauppalistapp.logiikka.Ostos;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tiedosto;
import kauppalistapp.logiikka.Tuotelista;

/**
 *
 * @author Aleksi
 * 
 * Poistaa Ostos-olion Ostoslistalta
 */
public class PoistaListalta extends Komento {

    /**
     *
     * @param numero
     * @param nimi
     * @param tallennetutTuotteet
     * @param tallennetutListat
     * @param io
     */
    public PoistaListalta(int numero, String nimi, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat, IO io) {
        super(numero, nimi, tallennetutTuotteet, tallennetutListat, io);
        this.tiedostonLukija = new TiedostonLukija();
    }

    @Override
    public boolean suorita() {
        Ostoslista uusiLista = new Ostoslista("väliaikainen");
        String listanNimi = this.io.lueTeksti("Anna listan nimi: ");
        this.io.tulostaTeksti("");


        boolean onkoListalla = false;
        for (Ostoslista ostoslista : super.tallennetutListat) {
            if (ostoslista.getNimi().equals(listanNimi)) {
                this.io.tulostaTeksti(ostoslista.getNimi());
                uusiLista = ostoslista;
                onkoListalla = true;
                break;
            }
        }



        if (onkoListalla) {
            this.io.tulostaTeksti(uusiLista.toString());
            int poistettavanRivi = this.io.lueInteger("Syota poistettavan tuotteen rivinumero: ");

            if (poistettavanRivi >= 1) {
                Ostos poistettava = uusiLista.annaRivi(poistettavanRivi);
                uusiLista.poistaOstos(poistettava);
                super.tiedostonKirjoittaja.tyhjennaTiedosto(new Tiedosto(uusiLista.getNimi()));
                try {
                    super.tiedostonKirjoittaja.kirjoitaTiedostoonOstoslista(uusiLista, new Tiedosto(listanNimi));
                } catch (IOException ex) {
                }
            }
        } else {
            this.io.tulostaTeksti("Hakemaasi listaa ei löytynyt");
        }

        return true;
    }
}
