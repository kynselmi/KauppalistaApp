package kauppalistapp.komennot;

import java.util.List;
import java.util.TreeMap;
import kauppalistapp.apurit.Lukija;
import kauppalistapp.kayttoliittyma.IO;
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
     * @param tallennetutTuotteet Tallennetut Tuotteet
     * @param io IO-rajapinnan totetuttava olio
     * @param tallennetutListat Käyttäjän luomat tallennetut listat
     */
    public KasitteleListoja(int numero, String nimi, Tuotelista tallennetutTuotteet, List<Ostoslista> tallennetutListat, IO io) {
        super(numero, nimi, tallennetutTuotteet, tallennetutListat, io);
        this.komennot = new TreeMap<Integer, Komento>();
    }

    @Override
    public boolean suorita() {
        lisaaKomennot();
        boolean jatkuu = true;
        while (jatkuu) {
            tulostaKomennot();


            int komento = this.io.lueInteger("Anna komento (kirjain lopettaa): ");
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
        this.komennot.put(1, new TarkasteleListoja(1, "Tarkastele listoja", super.tallennetutTuotteet, super.tallennetutListat, this.io));
        this.komennot.put(2, new LisaaListalle(2, "Lisää listalle", super.tallennetutTuotteet, super.tallennetutListat, this.io));
        this.komennot.put(3, new PoistaListalta(3, "Poista listalta", super.tallennetutTuotteet, super.tallennetutListat, this.io));
    }

    /**
     * Tulostaa TreeMappiin tallennetut komennot
     */
    public void tulostaKomennot() {
        this.io.tulostaTeksti("Komennot: ");
        for (int i = 1; i <= this.komennot.keySet().size(); i++) {
            this.io.tulostaTeksti(this.komennot.get(i).toString());
        }
        this.io.tulostaTeksti("");
    }

    /**
     * Tulostaa tallennetut listat
     */
    public void tulostaListat() {
        int riviNro = 1;
        for (Ostoslista ostoslista : this.tallennetutListat) {
            this.io.tulostaTeksti(riviNro + " " + ostoslista.getNimi());
            riviNro++;
        }
        this.io.tulostaTeksti("");
    }
}
