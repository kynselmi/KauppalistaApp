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
     * @param tiedosto Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public LisaaTuote(int numero, String nimi, Lukija lukija, Tiedosto tiedosto, List<Lista> tallennetutListat) {
        super(numero, nimi, lukija, tiedosto, tallennetutListat);
    }

    @Override
    public boolean suorita() {
        int rivinumero = super.tiedostonLukija.riveja(super.tiedosto.getTiedosto());
        ArrayList<String> lista;
        while (true) {
            Tuote tuote;
            System.out.println("Voit syottaa tuotteita niin kauan kuin haluat. Syota nimeksi 'x' jos haluat lopettaa.");
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

            lista = new ArrayList<String>();
            lista.add(tuote.toString());
            super.tiedostonKirjoittaja.kirjoitaTiedostoon(lista, this.tiedosto.getNimi());
            rivinumero++;
        }

        return true;


    }
}
