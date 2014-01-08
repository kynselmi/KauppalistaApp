package kauppalistapp.komennot;

import kauppalistapp.apurit.*;
import java.util.List;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tuotelista;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class JarjestaTuotteita extends Komento {

    /**
     * JarjestaTuotteita-komennon konstruktori
     * @param numero Komennon numero
     * @param nimi  Komennon nimi
     * @param lukija Lukija-tyyppiä oleva scanner-lukija
     * @param tiedosto Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public JarjestaTuotteita(int numero, String nimi, Lukija lukija, Tuotelista tiedosto, List<Ostoslista> tallennetutListat) {
        super(numero, nimi, lukija, tiedosto, tallennetutListat);
    }

    @Override
    public boolean suorita() {
        TiedostonKirjoittaja tk = new TiedostonKirjoittaja();
        tulostaTeksti("1 Aakkosjärjestykseen");
        tulostaTeksti("2 Käänteiseen aakkosjärjestykseen");
        int komento = this.lukija.lueInteger("Anna komento: ");

        if (komento == 1) {
            super.tallennetutTuotteet.jarjestaAakkosjarjestykseenNousevasti();
        }
        if (komento == 2) {
            super.tallennetutTuotteet.jarjestaAakkosjarjestykseenLaskevasti();
        }
        tk.tyhjennaTiedosto(super.tallennetutTuotteet.getTiedosto());
        tk.kirjoitaTiedostoon(super.tallennetutTuotteet.annaListana(), super.tallennetutTuotteet.getTiedosto());
        return true;
    }
}
