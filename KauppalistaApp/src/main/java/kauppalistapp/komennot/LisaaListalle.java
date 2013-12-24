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
        List<String> tallennetutListat = new ArrayList<String>();
        String listanNimi = this.lukija.lueTeksti("Anna listan nimi: ");
        Lista uusiLista = new Lista(listanNimi);
        for (Lista lista : super.tallennetutListat) {
            if (lista.getTiedosto().getNimi().equals(listanNimi)) {
                uusiLista = lista;
            }
            tallennetutListat.add(lista.getTiedosto().getNimi());
        }
        Lista tuoteLista = super.tiedosto.annaTuoteListana();
        ListastaTulostaja lt = new ListastaTulostaja();
        while (true) {
            lt.tulostaListasta(super.tiedosto.annaListanaRiviNumeroMukana());
            System.out.println("Listalla " + listanNimi + " on " + uusiLista.annaStringListana().size() + " tuotetta:");
            lt.tulostaListasta(uusiLista.annaStringListana());
            int lisattavanRivinumero = super.lukija.lueInteger("Anna lisattavan tuotteen rivinumero (x lopettaa): ");
            if (lisattavanRivinumero == -1) {
                break;
            }
            uusiLista.lisaaListalle(tuoteLista.annaRivi(lisattavanRivinumero), 1);            
        }
        tallennetutListat.add(listanNimi);
        this.tiedostonKirjoittaja.kirjoitaTiedostoon(uusiLista.annaStringListana(), listanNimi);
        this.tiedostonKirjoittaja.kirjoitaTiedostoon(tallennetutListat, "TallennetutListat");
        return true;
    }
    
    public void tulostaListat() {
        for (Lista lista : this.tallennetutListat) {
            System.out.println(lista.getTiedosto().getNimi());       
        }
        System.out.println("");
    }
}
