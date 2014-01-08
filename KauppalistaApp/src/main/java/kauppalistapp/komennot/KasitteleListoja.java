package kauppalistapp.komennot;

import java.util.List;
import java.util.TreeMap;
import kauppalistapp.apurit.Lukija;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tuotelista;

/**
 *
 * @author Aleksi
 * @ver 0.4
 *
 * Tallennettujen listojen käsittelyyn. Sisältää Komento-olioita.
 */
public class KasitteleListoja extends Komento {

    private TreeMap<Integer, Komento> komennot;

    /**
     * KasitteleListoja-olion konstruktori
     *
     * @param numero Komennon numero
     * @param nimi Komennon nimi
     * @param lukija Lukija-tyyppiä oleva scanner-lukija
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public KasitteleListoja(int numero, String nimi, Lukija lukija, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat) {
        super(numero, nimi, lukija, tallennetutTuotteet, tallennetutListat);
        this.komennot = new TreeMap<Integer, Komento>();
    }

    @Override
    public boolean suorita() {
        lisaaKomennot();
        boolean jatkuu = true;
        while (jatkuu) {
            tulostaKomennot();


            int komento = super.lukija.lueInteger("Anna komento (kirjain lopettaa): ");
            if (komento == -1) {
                break;
            }
            System.out.println("");

            tulostaListat();

            jatkuu = this.komennot.get(komento).suorita();
        }

        return true;
    }

    /**
     * Lisaa kaytettavat komennot TreeMappiin
     */
    public void lisaaKomennot() {
        this.komennot.put(1, new LisaaListalle(1, "Lisää listalle", super.lukija, super.tallennetutTuotteet, super.tallennetutListat));
        this.komennot.put(2, new TarkasteleListoja(2, "Tarkastele listoja", super.lukija, super.tallennetutTuotteet, super.tallennetutListat));
    }

    /**
     * Tulostaa TreeMappiin tallennetut komennot
     */
    public void tulostaKomennot() {
        tulostaTeksti("Komennot: ");
        for (int i = 1; i <= this.komennot.keySet().size(); i++) {
            tulostaTeksti(this.komennot.get(i));
        }
        tulostaTeksti("");
    }

    /**
     * Tulostaa tallennetut listat
     */
    public void tulostaListat() {
        int riviNro = 1;
        for (Ostoslista ostoslista : this.tallennetutListat) {
            tulostaTeksti(riviNro + " " + ostoslista.getNimi());
            riviNro++;
        }
        tulostaTeksti("");
    }
}
