
package kauppalistapp.logiikka;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import kauppalistapp.apurit.*;

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
    
//    /**
//     * Antaa tekstitiedoston List-muodossa.
//     * 
//     * Jokaiselle taulukon sarakkeelle tallennettaan yksi rivi tekstitiedostosta. Rivinumero jätetään tähän listaan.
//     * @return Tekstitiedosto list-muodossa, jossa jokainen tiedoston rivi on yksi taulukon rivi
//     */
//    public List<String> annaListanaRiviNumeroMukana() {
//        TiedostonLukija tl = new TiedostonLukija();
//        return tl.lueJaAnnaListana(this.tiedosto);
//    }
//    
//    /**
//     * Antaa tekstitiedoston List-muodossa.
//     * 
//     * Jokaiselle taulukon sarakkeelle tallennettaan yksi rivi tekstitiedostosta.
//     * @return Tekstitiedosto list-muodossa, jossa jokainen tiedoston rivi on yksi taulukon rivi
//     */
//    public List<String> annaListana() {
//        TiedostonLukija tl = new TiedostonLukija();
//        List<String> tuotelista = tl.annaListanaIlmanRiviNumeroa(this.tiedosto);
//        return tuotelista;
//    }
//    
//    public Ostoslista annaOstosListana() {
//        Ostoslista palautettava = new Ostoslista(getNimi());
//        palautettava.lisaaOstoksiaListasta(annaListana());
//        return palautettava;
//    }       
}
