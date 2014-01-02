/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kauppalistapp.apurit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class ListanJarjestaja {    
    
    /**
     * Jarjestaa List-olion laskevaan aakkosjärjestykseen
     * @param lista jarjestettava lista
     * @return jarjestetty lista
     */
    public List<String> jarjestaAakkosjarjestykseenLaskevasti(List<String> lista) {   
        Collections.sort(lista);
        return lista;
    }
    
    /**
     * Jarjestaa List-olion nousevaan aakkosjärjestykseen
     * @param lista jarjestettava lista
     * @return jarjestetty lista
     */
    public List<String> jarjestaAakkosjarjestykseenNousevasti(List<String> lista) {
        return this.listanKaantaja(this.jarjestaAakkosjarjestykseenLaskevasti(lista));
    }
    
    private List<String> listanKaantaja(List<String> kaannettavaLista) {
        List<String> kaannettyLista = new ArrayList<String>();
        int kaannettavanListanKoko = kaannettavaLista.size();
        for (int i = 1; 0 <= kaannettavanListanKoko-i ; i++) {
            kaannettyLista.add(kaannettavaLista.get(kaannettavanListanKoko-i));
        }
        return kaannettyLista;
    }
    
}
