
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

    public void setTiedosto(File tiedosto) {
        this.tiedosto = tiedosto;
    }
}
