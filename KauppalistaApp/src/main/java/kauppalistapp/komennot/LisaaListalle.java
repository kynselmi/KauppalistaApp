package kauppalistapp.komennot;

import kauppalistapp.apurit.*;
import kauppalistapp.logiikka.*;
import java.util.List;
import java.util.ArrayList;
import kauppalistapp.sovellus.Sovellus;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class LisaaListalle extends Komento {

    private List<Ostoslista> tallennetutListat;

    /**
     * LisaaListalle-olion konstruktori
     *
     * @param numero Komennon numero
     * @param nimi Komennon nimi
     * @param lukija Lukija-tyyppiä oleva scanner-lukija
     * @param tiedosto Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public LisaaListalle(int numero, String nimi, Lukija lukija, Tiedosto tiedosto, List<Ostoslista> tallennetutListat) {
        super(numero, nimi, lukija, tiedosto, tallennetutListat);
        this.tallennetutListat = new ArrayList<Ostoslista>();
    }

    @Override
    public boolean suorita() {
        tulostaListat();

        Ostoslista uusiLista = new Ostoslista("väliaikainen");
        String listanNimi = this.lukija.lueTeksti("Anna listan nimi: ");
        System.out.println("");

        boolean onkoListalla = false;
        for (Ostoslista ostoslista : this.tallennetutListat) {
            if (ostoslista.getNimi().equals(listanNimi)) {
                uusiLista = ostoslista;
                onkoListalla = true;
                break;
            }
        }

        if (!onkoListalla) {
            uusiLista = new Ostoslista(listanNimi);
            this.tallennetutListat.add(uusiLista);
        }

        Ostoslista tuoteLista = super.tiedosto.annaOstosListana();
        while (true) {
            System.out.println("Listalla " + uusiLista.getNimi() + " on " + uusiLista.annaTuotteidenMaara() + " tuotetta:");
            System.out.println(uusiLista);
            System.out.println("");

            System.out.println("Lisättävät tuotteet:");
            System.out.println(tuoteLista.toStringIlmanMaaraa());

            int lisattavanRivinumero = super.lukija.lueInteger("Anna lisattavan tuotteen rivinumero (kirjain lopettaa): ");
            if (lisattavanRivinumero == -1) {
                break;
            }
            if (tuoteLista.loytyykoRivia(lisattavanRivinumero)) {
                uusiLista.lisaaOstos(tuoteLista.annaOstosRivilta(lisattavanRivinumero));
            } else {
                System.out.println("Listalla ei ole antamaasi riviä");
            }
        }

        if (!this.tallennetutListat.contains(uusiLista)) {
            this.tallennetutListat.add(uusiLista);

            List<String> tallennetutListatNimet = new ArrayList<String>();
            for (Ostoslista ostoslista : this.tallennetutListat) {
                tallennetutListatNimet.add(ostoslista.getNimi());
            }

            super.tiedostonKirjoittaja.kirjoitaTiedostoon(tallennetutListatNimet, "TallennetutListat");
        }

        this.tiedostonKirjoittaja.kirjoitaTiedostoon(uusiLista.annaListana(), listanNimi);
        return true;
    }

    /**
     * Tulostaa tallennetut listat rivittäin
     */
    public void tulostaListat() {
        for (Ostoslista ostoslista : this.tallennetutListat) {
            System.out.println(ostoslista.getNimi());
        }
        System.out.println("");
    }
}
