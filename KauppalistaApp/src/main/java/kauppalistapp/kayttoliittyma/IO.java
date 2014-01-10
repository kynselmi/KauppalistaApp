package kauppalistapp.kayttoliittyma;

/**
 *
 * @author Aleksi
 * @ver 0.4 Rajapinta tekstinTulostukseen komentoriville
 */
public interface IO {

    /**
     *
     * Tulostaa annetun tekstin ja rivinvaihdon
     * 
     *
     * @param teksti tulostettava teksti
     */
    public void tulostaTeksti(String teksti);

    /**
     * Tulostaa annetun tekstin 
     *
     * @param teksti tulostettava teksti
     */
    public void tulostaTekstiIlmanRivinVaihtoa(String teksti);

    /**
     * Lukee tekstia
     *
     * @return luettu teksti
     */
    public String lueTeksti();
    
    /**
     * Tulostaa parametrinä annetun tekstin ja lukee tekstin
     *
     * @param teksti tulostettava teksti
     * @return luettu teksti
     */
    public String lueTeksti(String teksti);

    /**
     * Lukee kokonaisluvun
     *
     * @return luettu kokonaisluku
     */
    public int lueInteger();
    
    /**
     * Tulostaa parametrinä annetun tekstin ja lukee kokonaisluvun
     *
     * @param teksti tulostettava teksti
     * @return luettu kokonaisluku
     */
    public int lueInteger(String teksti);
}
