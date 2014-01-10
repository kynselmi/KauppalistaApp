
package kauppalistapp.kayttoliittyma;

import kauppalistapp.apurit.Lukija;

/**
 *
 * @author Aleksi
 * 
 * Tekstikäyttöliittyman IO-implementaatio
 */
public class IOTeksti implements IO {
    
    private Lukija lukija;

    public IOTeksti() {
        this.lukija = new Lukija();
    }

    @Override
    public void tulostaTeksti(String teksti) {
        System.out.println(teksti);
    }

    @Override
    public void tulostaTekstiIlmanRivinVaihtoa(String teksti) {
        System.out.print(teksti);
    }

    @Override
    public int lueInteger() {        
        return this.lukija.lueInteger();
    }

    @Override
    public String lueTeksti() {
        return this.lukija.lueTeksti();
    }

    @Override
    public String lueTeksti(String teksti) {
        System.out.print(teksti);
        return this.lukija.lueTeksti();
    }

    @Override
    public int lueInteger(String teksti) {
        tulostaTekstiIlmanRivinVaihtoa(teksti);
        return this.lukija.lueInteger();
    }
    
}
