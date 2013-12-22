package kauppalistapp.komennot;

import kauppalistapp.logiikka.*;
import kauppalistapp.apurit.Lukija;
import java.util.ArrayList;

public class LisaaTuote extends Komento {

    public LisaaTuote(int numero, String nimi, Lukija lukija) {
        super(numero, nimi, lukija);
    }

    @Override
    public boolean suorita() {
        int rivinumero = super.tiedostonLukija.riveja("Tuotteet.txt");
        ArrayList<String> lista;
        while (true) {
            Tuote tuote;
            System.out.println("Voit syottaa tuotteita niin kauan kuin haluat. Syota nimeksi 'x' jos haluat lopettaa.");
            String nimi = super.lukija.lueTeksti("Anna tuotteen nimi: ");
            if (nimi.equals("x")) {
                break;
            }
            int eurot = super.lukija.lueInteger("Anna hinnasta eurot: ");
            int sentit = super.lukija.lueInteger("Anna hinnasta sentit: ");
            if (eurot == 0 && sentit == 0) {
                tuote = new Tuote(nimi);
            } else {
                tuote = new Tuote(nimi, eurot, sentit);
            }

            lista = new ArrayList<String>();
            lista.add(tuote.toString());
            super.tiedostonKirjoittaja.kirjoitaTiedostoon(lista, "Tuotteet.txt");
            rivinumero++;
        }

        return true;


    }
}
