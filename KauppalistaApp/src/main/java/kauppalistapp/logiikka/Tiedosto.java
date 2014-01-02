
package kauppalistapp.logiikka;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import kauppalistapp.apurit.*;
import kauppalistapp.logiikka.Lista;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class Tiedosto {
    
    private File tiedosto;
    private String nimi;
    
    /**
     * Tiedosto-olion konstruktori
     * @param nimi Tiedoston nimi
     */
    public Tiedosto(String nimi) {
        this.nimi = nimi;
        this.tiedosto = new File(nimi + ".txt");
    }

    public File getTiedosto() {
        return tiedosto;
    }

    public String getNimi() {
        return nimi;
    }
    
    /**
     * Antaa tekstitiedoston List-muodossa.
     * 
     * Jokaiselle taulukon sarakkeelle tallennettaan yksi rivi tekstitiedostosta. Rivinumero jätetään tähän listaan.
     * @return Tekstitiedosto list-muodossa, jossa jokainen tiedoston rivi on yksi taulukon rivi
     */
    public List<String> annaListanaRiviNumeroMukana() {
        TiedostonLukija tl = new TiedostonLukija();
        return tl.lueJaAnnaListana(this.tiedosto);
    }
    
    /**
     * Antaa tekstitiedoston List-muodossa.
     * 
     * Jokaiselle taulukon sarakkeelle tallennettaan yksi rivi tekstitiedostosta.
     * @return Tekstitiedosto list-muodossa, jossa jokainen tiedoston rivi on yksi taulukon rivi
     */
    public List<String> annaListana() {
        TiedostonLukija tl = new TiedostonLukija();
        List<String> tuotelista = tl.annaListanaIlmanRiviNumeroa(this.tiedosto);
        return tuotelista;
    }
    
    /**
     * Antaa Tiedostosta Tuote-olioita sisältävän Lista-olion
     * @return Lista-olion, jossa Tiedoston tekstimuodossa olevat tuotteet
     */
    public Lista annaTuoteListana() {
        Lista tuoteLista = new Lista("Blaablaa");
        Tuote lisattavaTuote;
        for (String tuote : this.annaListana()) {            
            String[] tuoteHajotettuna = tuote.split(",");
            String nimi = tuoteHajotettuna[0].trim();
            try {
                int eurot = Integer.parseInt(tuoteHajotettuna[1].trim());
                int sentit = Integer.parseInt(tuoteHajotettuna[2].trim());
                lisattavaTuote = new Tuote(nimi, eurot, sentit);
            } catch (Exception ex) {
                lisattavaTuote = new Tuote(nimi);
            }
            tuoteLista.lisaaListalle(lisattavaTuote);
        }
        return tuoteLista;
    }
    
   
    
    
}
