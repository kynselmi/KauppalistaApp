
package kauppalistapp.apurit;
import java.util.List;

public class ListastaTulostaja {
    
    public void tulostaListasta(List<String> lista) {
        for (String listalla : lista) {
            System.out.println(listalla);
        }
    }
    
}
