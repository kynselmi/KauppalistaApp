package kauppalistapp.komennot;

import java.util.List;
import kauppalistapp.apurit.Lukija;
import kauppalistapp.kayttoliittyma.IO;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tuotelista;

/**
 *
 * @author Aleksi
 * @ver 0.4
 *
 * Lopettaa ohjelman
 */
public class Lopetus extends Komento {

    /**
     * Lopetus-olion konstruktori
     *
     * @param numero Komennon numero
     * @param nimi Komennon nimi
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param io IO-rajapinnan totetuttava olio
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public Lopetus(int numero, String nimi, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat, IO io) {
        super(numero, nimi, tallennetutTuotteet, tallennetutListat, io);
    }

    @Override
    public boolean suorita() {
        return false;
    }

}
