package kauppalistapp.komennot;

import java.util.ArrayList;
import java.util.List;
import kauppalistapp.apurit.*;
import kauppalistapp.kayttoliittyma.IO;
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
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     * @param io IO-rajapinnan totettava olio
     */
    public EtsiTuote(int numero, String nimi, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat, IO io) {
        super(numero, nimi, tallennetutTuotteet, tallennetutListat, io);
    }

    @Override
    public boolean suorita() {
        this.io.tulostaTeksti("Anna hakusana: ");
        String hakusana = this.io.lueTeksti();
        
        int montakoLoytyi = 0;
        List<Integer> loydetytTuotteet = super.tallennetutTuotteet.etsiTuotteita(hakusana);
        
        for (Integer riviNro : loydetytTuotteet) {            
                this.io.tulostaTeksti("  " + riviNro + super.tallennetutTuotteet.annaRivi(riviNro));
                montakoLoytyi++;
            
        }
        if (montakoLoytyi == 1) {
            this.io.tulostaTeksti("Hakusanallasi loytyi yksi tulos");
        }
        else if (montakoLoytyi == 0) {
            this.io.tulostaTeksti("Hakusanallasi ei loytynyt yhtaan tulosta");
        } else {
            this.io.tulostaTeksti("Hakusanallasi loytyi " + montakoLoytyi + " tulosta");
        }
        this.io.tulostaTeksti("");
        return true;
    }
}
