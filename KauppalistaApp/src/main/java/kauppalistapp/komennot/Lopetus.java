package kauppalistapp.komennot;

import java.util.List;
import kauppalistapp.apurit.Lukija;
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
     * @param lukija Lukija-tyyppiä oleva scanner-lukija
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public Lopetus(int numero, String nimi, Lukija lukija, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat) {
        super(numero, nimi, lukija, tallennetutTuotteet, tallennetutListat);
    }

    @Override
    public boolean suorita() {
        return false;
    }

}
