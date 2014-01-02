package kauppalistapp.komennot;

import java.util.List;
import kauppalistapp.apurit.*;
import kauppalistapp.logiikka.Lista;
import kauppalistapp.logiikka.Tiedosto;

/**
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class EtsiTuote extends Komento {
    
    /**
     * EtsiTuote-komennon konstruktori
     * @param numero Komennon numero
     * @param nimi  Komennon nimi
     * @param lukija Lukija-tyyppiä oleva scanner-lukija
     * @param tiedosto Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public EtsiTuote(int numero, String nimi, Lukija lukija, Tiedosto tiedosto, List<Lista> tallennetutListat) {
        super(numero, nimi, lukija, tiedosto, tallennetutListat);
    }

    @Override
    public boolean suorita() {
        String hakusana = super.lukija.lueTeksti("Anna tuotteen nimi: ");
        int montakoLoytyi = 0;
        for (String listalla : super.tiedostonLukija.lueJaAnnaListana(super.tiedosto.getTiedosto())) {
            if (listalla.contains(hakusana)) {
                System.out.println("  " + listalla);
                montakoLoytyi++;
            }
        }
        if (montakoLoytyi == 1) {
            System.out.println("Hakusanallasi loytyi yksi tulos");
        }
        else if (montakoLoytyi == 0) {
            System.out.println("Hakusanallasi ei loytynyt yhtaan tulosta");
        } else {
            System.out.println("Hakusanallasi loytyi " + montakoLoytyi + " tulosta");
        }
        System.out.println("");
        return true;
    }
}
