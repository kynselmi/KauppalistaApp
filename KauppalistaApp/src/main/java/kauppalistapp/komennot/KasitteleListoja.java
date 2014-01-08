package kauppalistapp.komennot;

import java.util.List;
import java.util.TreeMap;
import kauppalistapp.apurit.Lukija;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tuotelista;

/**
 *
 * @author Aleksi
 */
public class KasitteleListoja extends Komento {

    private TreeMap<Integer, Komento> komennot;

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

    public void lisaaKomennot() {
        this.komennot.put(1, new LisaaListalle(1, "Lisää listalle", super.lukija, super.tallennetutTuotteet, super.tallennetutListat));
        this.komennot.put(2, new TarkasteleListoja(2, "Tarkastele listoja", super.lukija, super.tallennetutTuotteet, super.tallennetutListat));
    }

    public void tulostaKomennot() {
        tulostaTeksti("Komennot: ");
        for (int i = 1; i <= this.komennot.keySet().size(); i++) {
            tulostaTeksti(this.komennot.get(i));
        }
        tulostaTeksti("");
    }
    
        public void tulostaListat() {
            int riviNro = 1;
        for (Ostoslista ostoslista : this.tallennetutListat) {
            tulostaTeksti(riviNro + " " + ostoslista.getNimi());
            riviNro++;            
        }
        tulostaTeksti("");
    }
}
