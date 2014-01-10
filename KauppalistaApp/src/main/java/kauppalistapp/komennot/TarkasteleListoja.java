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
 * Tulostaa tallennettuja Ostoslistoja tarkastelua varten
 */
public class TarkasteleListoja extends Komento {

    /**
     * TarkateleListoja-olion konstruktori
     *
     * @param numero Komennon numero
     * @param nimi Komennon nimi
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param io IO-rajapinnan totetuttava olio
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public TarkasteleListoja(int numero, String nimi, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat, IO io) {
        super(numero, nimi, tallennetutTuotteet, tallennetutListat, io);

    }

    @Override
    public boolean suorita() {
        int riviNro = super.lukija.lueInteger("Anna tarkasteltavan listan rivinumero: ")-1;
        this.io.tulostaTeksti("");
        
        this.io.tulostaTeksti(super.tallennetutListat.get(riviNro).getNimi());
        this.io.tulostaTeksti(super.tallennetutListat.get(riviNro).toString());
        this.io.tulostaTeksti("Kokonaishinta: " + super.tallennetutListat.get(riviNro).kokonaisHinta());
        this.io.tulostaTeksti("");
        this.io.tulostaTeksti("");
        return true;
    }

    
}
