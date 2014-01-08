package kauppalistapp.komennot;

import java.util.ArrayList;
import java.util.List;
import kauppalistapp.apurit.*;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tiedosto;
import kauppalistapp.logiikka.Tuote;
import kauppalistapp.logiikka.Tuotelista;

/**
 * @author Kärkkäinen Aleksi
 * @version 0.1
 * 
 * Etsii Tuotteen Tuotelistalta
 */
public class EtsiTuote extends Komento {
    
    /**
     * EtsiTuote-komennon konstruktori
     * @param numero Komennon numero
     * @param nimi  Komennon nimi
     * @param lukija Lukija-tyyppiä oleva scanner-lukija
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public EtsiTuote(int numero, String nimi, Lukija lukija, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat) {
        super(numero, nimi, lukija, tallennetutTuotteet, tallennetutListat);
    }

    @Override
    public boolean suorita() {
        String hakusana = super.lukija.lueTeksti("Anna tuotteen nimi: ");
        
        int montakoLoytyi = 0;
        List<Integer> loydetytTuotteet = super.tallennetutTuotteet.etsiTuotteita(hakusana);
        
        for (Integer riviNro : loydetytTuotteet) {            
                tulostaTeksti("  " + riviNro + super.tallennetutTuotteet.annaRivi(riviNro));
                montakoLoytyi++;
            
        }
        if (montakoLoytyi == 1) {
            tulostaTeksti("Hakusanallasi loytyi yksi tulos");
        }
        else if (montakoLoytyi == 0) {
            tulostaTeksti("Hakusanallasi ei loytynyt yhtaan tulosta");
        } else {
            tulostaTeksti("Hakusanallasi loytyi " + montakoLoytyi + " tulosta");
        }
        tulostaTeksti("");
        return true;
    }
}
