package kauppalistapp.komennot;

import kauppalistapp.apurit.*;
import kauppalistapp.logiikka.*;
import java.util.List;
import java.util.ArrayList;

public class LisaaListalle extends Komento {

    public LisaaListalle(int numero, String nimi, Lukija lukija, Tiedosto tiedosto, List<Lista> tallennetutListat) {
        super(numero, nimi, lukija, tiedosto, tallennetutListat);
    }

    @Override
    public boolean suorita() {
        tulostaListat();
        Lista uusiLista = new Lista("valiaikainen");
        String listanNimi = this.lukija.lueTeksti("Anna listan nimi: ");

        boolean onkoListalla = false;
        for (Lista lista : this.tallennetutListat) {
            if (lista.getTiedosto().getNimi().equals(listanNimi)) {
                uusiLista = lista;
                onkoListalla = true;
                break;
            }
        }

        if (!onkoListalla) {
            uusiLista = new Lista(listanNimi);
        }
        uusiLista.lisaaTuotteetLinkedHashMappiin();
        Lista tuoteLista = super.tiedosto.annaTuoteListana();
        ListastaTulostaja lt = new ListastaTulostaja();
        while (true) {
            System.out.println("Listalla " + listanNimi + " on " + uusiLista.annaTuotteidenMaara() + " tuotetta:");
            lt.tulostaListasta(uusiLista.annaStringListanaMaaraMukana());
            System.out.println("");

            System.out.println("Lisättävät tuotteet:");
            lt.tulostaListasta(super.tiedosto.annaListanaRiviNumeroMukana());
            int lisattavanRivinumero = super.lukija.lueInteger("Anna lisattavan tuotteen rivinumero (x lopettaa): ");
            if (lisattavanRivinumero == -1) {
                break;
            }
            if (tuoteLista.annaRivi(lisattavanRivinumero) != null) {
                uusiLista.lisaaListalle(tuoteLista.annaRivi(lisattavanRivinumero));
            } else {
                System.out.println("Listalla ei ole antamaasi riviä");
            }

        }

        if (!onkoListalla) {
            for (Lista listalla : this.tallennetutListat) {
                if (listalla.getTiedosto().getNimi().equals(listanNimi)) {
                    this.tallennetutListat.remove(listalla);
                }
            }
        }
        super.tallennetutListat.add(uusiLista);

        List<String> uusiTallennetutListat = new ArrayList<String>();
        for (Lista listalla : this.tallennetutListat) {
            uusiTallennetutListat.add(listalla.getTiedosto().getNimi());
        }

        this.tiedostonKirjoittaja.kirjoitaTiedostoon(uusiLista.getTiedosto().annaListana(), listanNimi);
        this.tiedostonKirjoittaja.kirjoitaTiedostoon(uusiTallennetutListat, "TallennetutListat");
        return true;
    }

    /**
     * Tulostaa tallennetut listat rivittäin
     */
    public void tulostaListat() {
        for (Lista lista : this.tallennetutListat) {
            System.out.println(lista.getTiedosto().getNimi());
        }
        System.out.println("");
    }
}
