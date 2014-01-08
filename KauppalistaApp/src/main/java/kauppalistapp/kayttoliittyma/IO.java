package kauppalistapp.kayttoliittyma;

/**
 *
 * @author Aleksi
 * @ver 0.4
 * Rajapinta tekstinTulostukseen komentoriville
 */
public interface IO {
    
    /**
     *
     * Tulostaa annetun objectin (voi siis tulostaa Stringeja ja .toString() muotoja olioista
     * 
     * @param teksti tulostettava asia
     */
    public void tulostaTeksti(Object teksti); 
        
}
