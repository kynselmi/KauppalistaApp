
package kauppalistapp.apurit;
import java.util.List;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class ListastaTulostaja {
    
    /**
     * Tulostaa List-olion
     * @param lista List-muotoinen olio
     */
    public void tulostaListasta(List<String> lista) {
        for (String listalla : lista) {
            System.out.println(listalla);
        }
    }
    
}
