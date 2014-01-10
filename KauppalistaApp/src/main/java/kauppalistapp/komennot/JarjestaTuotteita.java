package kauppalistapp.komennot;

import kauppalistapp.apurit.*;
import java.util.List;
import kauppalistapp.kayttoliittyma.IO;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tuotelista;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 * 
 * Jarjestaa Tuotelistan tuotteet
 */
public class JarjestaTuotteita extends Komento {

    /**
     * JarjestaTuotteita-komennon konstruktori
     * @param numero Komennon numero
     * @param nimi  Komennon nimi
     * @param tallennetutTuotteet 
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     * @param io  IO-rajapinnan toteuttava olio
     */
    public JarjestaTuotteita(int numero, String nimi, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat, IO io) {
        super(numero, nimi, tallennetutTuotteet, tallennetutListat, io);
    }

    @Override
    public boolean suorita() {
        TiedostonKirjoittaja tk = new TiedostonKirjoittaja();
        this.io.tulostaTeksti("1 Aakkosjärjestykseen");
        this.io.tulostaTeksti("2 Käänteiseen aakkosjärjestykseen");
        int komento = this.io.lueInteger("Anna komento: ");

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
