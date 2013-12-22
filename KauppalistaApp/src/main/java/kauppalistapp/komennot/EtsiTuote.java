package kauppalistapp.komennot;

import kauppalistapp.apurit.*;

public class EtsiTuote extends Komento {

    public EtsiTuote(int numero, String nimi, Lukija lukija) {
        super(numero, nimi, lukija);
    }

    @Override
    public boolean suorita() {
        String hakusana = super.lukija.lueTeksti("Anna tuotteen nimi: ");
        int montakoLoytyi = 0;
        for (String listalla : super.tiedostonLukija.lueJaAnnaListana("Tuotteet.txt")) {
            if (listalla.contains(hakusana)) {
                System.out.println("  " + listalla);
                montakoLoytyi++;
            }
        }
        if (montakoLoytyi == 1) {
            System.out.println("Hakusanallasi löytyi yksi tulos");
        }
        else if (montakoLoytyi == 0) {
            System.out.println("Hakusanallasi ei loytynyt yhtaan tulosta");
        } else {
            System.out.println("Hakusanallasi löytyi " + montakoLoytyi + " tulosta");
        }
        System.out.println("");
        return true;
    }
}
