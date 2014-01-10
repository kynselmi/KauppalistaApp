package kauppalistapp.apurit;

import java.util.Scanner;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 *
 * Lukija kapseloi sisäänsä Scanner-olion, joka lukee käyttäjän antaman syötteen
 */
public class Lukija {

    private Scanner lukija;

    /**
     * Lukija-olion konstuktori
     */
    public Lukija() {
        this.lukija = new Scanner(System.in);
    }

    /**
     * Lukee tekstisyotteen
     *
     * @return luettu teksti
     */
    public String lueTeksti() {
        String teksti = this.lukija.next();
        return teksti;
    }

    /**
     * Tulostaa parametrina annetun tekstin ja lukee tekstisyotteen
     *
     * @param tekstia tulostettava teksti
     * @return luettu teksti
     */
    public String lueTeksti(String tekstia) {
        String teksti = this.lukija.next();
        return teksti;
    }

    /**
     * Tulostaa parametrina annetun tekstin ja lukee kokonaislukusyötteen
     *
     * @return luetun kokonaisluvun
     */
    public int lueInteger() {
        int numero = -1;
        try {
            String nro = this.lukija.next();
            numero = Integer.parseInt(nro);
        } catch (Exception Ex) {
        }
        return numero;
    }

    /**
     * Tulostaa parametrina annetun tekstin ja lukee kokonaislukusyötteen
     *
     * @param teksti tulostettava teksti
     * @return
     */
    public int lueInteger(String teksti) {
        int numero = -1;
        System.out.print(teksti);
        try {
            String nro = this.lukija.next();
            numero = Integer.parseInt(nro);
        } catch (Exception Ex) {
        }
        return numero;
    }
}
