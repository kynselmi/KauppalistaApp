package kauppalistapp.komennot;

import java.io.IOException;
import kauppalistapp.apurit.*;
import kauppalistapp.logiikka.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kauppalistapp.kayttoliittyma.IO;
import kauppalistapp.kayttoliittyma.Tekstikayttoliittyma;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 * 
 * Lisää tallennetulle tai tallennettavalle Ostoslistalle Ostoksia
 */
public class LisaaListalle extends Komento {

    /**
     * LisaaListalle-olion konstruktori
     *
     * @param numero Komennon numero
     * @param nimi Komennon nimi
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param io IO-rajapinnan totetuttava olio
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public LisaaListalle(int numero, String nimi, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat, IO io) {
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

        if (!onkoListalla) {
            uusiLista = new Ostoslista(listanNimi);
        }


        while (true) {
            this.io.tulostaTeksti("Listalla " + uusiLista.getNimi() + " on " + uusiLista.annaTuotteidenMaara() + " tuotetta:");
            this.io.tulostaTeksti(uusiLista.toString());
            this.io.tulostaTeksti("");

            this.io.tulostaTeksti("Lisättävät tuotteet:");
            this.io.tulostaTeksti(super.tallennetutTuotteet.toString());


            int lisattavanRivinumero = this.io.lueInteger("Anna lisattavan tuotteen rivinumero (kirjain lopettaa): ");                       

            if (lisattavanRivinumero == -1) {
                break;
            }
            if (super.tallennetutTuotteet.annaKoko() >= lisattavanRivinumero) {
                Tuote lisattava = super.tallennetutTuotteet.annaRivi(lisattavanRivinumero);
                Ostos ostos = new Ostos(lisattava, 1);
                uusiLista.lisaaOstos(ostos);
            } else {
                this.io.tulostaTeksti("Listalla ei ole antamaasi riviä");
            }
        }

        if (!this.tallennetutListat.contains(uusiLista)) {
            this.tallennetutListat.add(uusiLista);

            List<String> tallennetutListatNimet = new ArrayList<String>();
            int i = 0;
            for (Ostoslista ostoslista : this.tallennetutListat) {
                tallennetutListatNimet.add(ostoslista.getNimi());
                i++;
            }
            Tiedosto tallennetutListat = new Tiedosto("TallennetutListat");
            super.tiedostonKirjoittaja.tyhjennaTiedosto(tallennetutListat);
            super.tiedostonKirjoittaja.kirjoitaTiedostoon(tallennetutListatNimet, tallennetutListat);
        }
        try {
            this.tiedostonKirjoittaja.kirjoitaTiedostoonOstoslista(uusiLista, new Tiedosto(listanNimi));
        } catch (IOException ex) {
        }
        return true;
    }

}
