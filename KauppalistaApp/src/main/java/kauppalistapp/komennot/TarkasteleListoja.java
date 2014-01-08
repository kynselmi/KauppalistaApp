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
 * Tulostaa tallennettuja Ostoslistoja tarkastelua varten
 */
public class TarkasteleListoja extends Komento {

    /**
     * TarkateleListoja-olion konstruktori
     *
     * @param numero Komennon numero
     * @param nimi Komennon nimi
     * @param lukija Lukija-tyyppiä oleva scanner-lukija
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public TarkasteleListoja(int numero, String nimi, Lukija lukija, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat) {
        super(numero, nimi, lukija, tallennetutTuotteet, tallennetutListat);

    }

    @Override
    public boolean suorita() {
        int riviNro = super.lukija.lueInteger("Anna tarkasteltavan listan rivinumero: ")-1;
        tulostaTeksti("");
        
        tulostaTeksti(super.tallennetutListat.get(riviNro).getNimi());
        tulostaTeksti(super.tallennetutListat.get(riviNro));
        tulostaTeksti("Kokonaishinta: " + super.tallennetutListat.get(riviNro).kokonaisHinta());
        tulostaTeksti("");
        tulostaTeksti("");
        return true;
    }
    
}
