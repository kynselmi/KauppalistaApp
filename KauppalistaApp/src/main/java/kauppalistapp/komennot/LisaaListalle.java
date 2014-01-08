package kauppalistapp.komennot;

import java.io.IOException;
import kauppalistapp.apurit.*;
import kauppalistapp.logiikka.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kauppalistapp.kayttoliittyma.Sovellus;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class LisaaListalle extends Komento {

    /**
     * LisaaListalle-olion konstruktori
     *
     * @param numero Komennon numero
     * @param nimi Komennon nimi
     * @param lukija Lukija-tyyppiä oleva scanner-lukija
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public LisaaListalle(int numero, String nimi, Lukija lukija, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat) {
        super(numero, nimi, lukija, tallennetutTuotteet, tallennetutListat);
        this.tiedostonLukija = new TiedostonLukija();
    }

    @Override
    public boolean suorita() {
        tulostaListat();

        Ostoslista uusiLista = new Ostoslista("väliaikainen");
        String listanNimi = this.lukija.lueTeksti("Anna listan nimi: ");
        System.out.println("");

        boolean onkoListalla = false;
        for (Ostoslista ostoslista : super.tallennetutListat) {
            if (ostoslista.getNimi().equals(listanNimi)) {
                System.out.println("listalla olevat nimet ostolistat: " + ostoslista.getNimi());
                uusiLista = ostoslista;
                onkoListalla = true;
                break;
            }
        }

        if (!onkoListalla) {
            uusiLista = new Ostoslista(listanNimi);
        }


        while (true) {
            System.out.println("Listalla " + uusiLista.getNimi() + " on " + uusiLista.annaTuotteidenMaara() + " tuotetta:");
            System.out.println(uusiLista);
            System.out.println("");

            System.out.println("Lisättävät tuotteet:");
            System.out.println(super.tallennetutTuotteet);


            int lisattavanRivinumero = super.lukija.lueInteger("Anna lisattavan tuotteen rivinumero (kirjain lopettaa): ");

            if (lisattavanRivinumero == -1) {
                break;
            }
            if (super.tallennetutTuotteet.annaKoko() >= lisattavanRivinumero) {
                Tuote lisattava = super.tallennetutTuotteet.annaRivi(lisattavanRivinumero);
                Ostos ostos = new Ostos(lisattava, 1);
                uusiLista.lisaaOstos(ostos);
            } else {
                System.out.println("Listalla ei ole antamaasi riviä");
            }
        }

        if (!this.tallennetutListat.contains(uusiLista)) {
            this.tallennetutListat.add(uusiLista);

            List<String> tallennetutListatNimet = new ArrayList<String>();
            int i = 0;
            for (Ostoslista ostoslista : this.tallennetutListat) {
                tallennetutListatNimet.add(ostoslista.getNimi());
                i++;
            }
            Tiedosto tallennetutListat = new Tiedosto("TallennetutListat");
            super.tiedostonKirjoittaja.tyhjennaTiedosto(tallennetutListat);
            super.tiedostonKirjoittaja.kirjoitaTiedostoon(tallennetutListatNimet, tallennetutListat);
        }
        try {
            this.tiedostonKirjoittaja.kirjoitaTiedostoonOstoslista(uusiLista, new Tiedosto(listanNimi));
        } catch (IOException ex) {
        }
        return true;
    }

    /**
     * Tulostaa tallennetut listat rivittäin
     */
    public void tulostaListat() {
        for (Ostoslista ostoslista : this.tallennetutListat) {
            System.out.println(ostoslista.getNimi());
            System.out.println("");
        }
    }
}
