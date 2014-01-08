package kauppalistapp.komennot;

import kauppalistapp.logiikka.*;
import kauppalistapp.apurit.Lukija;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class LisaaTuote extends Komento {

    /**
     * LisaaTuote-olion konstruktori
     * @param numero Komennon numero
     * @param nimi  Komennon nimi
     * @param lukija Lukija-tyyppiä oleva scanner-lukija
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public LisaaTuote(int numero, String nimi, Lukija lukija, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat) {
        super(numero, nimi, lukija, tallennetutTuotteet, tallennetutListat);
    }

    @Override
    public boolean suorita() {
        ArrayList<String> lista;
        while (true) {
            Tuote tuote;
            tulostaTeksti("Voit syottaa tuotteita niin kauan kuin haluat. Syota nimeksi 'x' jos haluat lopettaa.");
            String nimi = super.lukija.lueTeksti("Anna tuotteen nimi: ");
            if (nimi.equals("x")) {
                break;
            }
            int eurot = super.lukija.lueInteger("Anna hinnasta eurot: ");
            int sentit = super.lukija.lueInteger("Anna hinnasta sentit: ");
            if (eurot == 0 && sentit == 0) {
                tuote = new Tuote(nimi);
            } else {
                tuote = new Tuote(nimi, eurot, sentit);
            }
            super.tallennetutTuotteet.lisaaTuote(tuote);            
        }
        super.tiedostonKirjoittaja.kirjoitaTiedostoon(super.tallennetutTuotteet.annaListana(), super.tallennetutTuotteet.getTiedosto());

        return true;
       
    }
}
