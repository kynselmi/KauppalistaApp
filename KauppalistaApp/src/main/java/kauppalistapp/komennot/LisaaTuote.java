package kauppalistapp.komennot;

import kauppalistapp.logiikka.*;
import kauppalistapp.apurit.Lukija;
import java.util.ArrayList;
import java.util.List;
import kauppalistapp.kayttoliittyma.IO;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 *
 * Lisää Tuotelistalle Tuote-olioita
 */
public class LisaaTuote extends Komento {

    /**
     * LisaaTuote-olion konstruktori
     *
     * @param numero Komennon numero
     * @param nimi Komennon nimi
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param io IO-rajapinnan totetuttava olio
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public LisaaTuote(int numero, String nimi, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat, IO io) {
        super(numero, nimi, tallennetutTuotteet, tallennetutListat, io);
    }

    @Override
    public boolean suorita() {

        
        int eurot;
        int sentit;

        Tuote tuote;
            while (true) {
                this.io.tulostaTeksti("Voit syottaa tuotteita niin kauan kuin haluat. Syota nimeksi 'x' jos haluat lopettaa.");
                String nimi = this.io.lueTeksti("Anna tuotteen nimi: ");
                if (nimi.equals("x")) {
                    break;
                }
                eurot = this.io.lueInteger("Anna hinnasta eurot: ");
                sentit = this.io.lueInteger("Anna hinnasta sentit: ");
                if ((eurot|sentit)<0) {
                    eurot = 0;
                    sentit = 0;
                }
                if (eurot == 0 && sentit == 0) {
                    tuote = new Tuote(nimi);
                } else {
                    tuote = new Tuote(nimi, eurot, sentit);
                }
                this.tallennetutTuotteet.lisaaTuote(tuote);
            }
            
        super.tiedostonKirjoittaja.kirjoitaTiedostoon(super.tallennetutTuotteet.annaListana(), super.tallennetutTuotteet.getTiedosto());

        return true;
    }
}
