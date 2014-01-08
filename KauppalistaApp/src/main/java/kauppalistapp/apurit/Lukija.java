package kauppalistapp.apurit;

import java.util.Scanner;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
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
        String teksti = this.lukija.nextLine();
        return teksti;
    }

    /**
     * Tulostaa parametrina annetun tekstin ja lukee tekstisyotteen
     *
     * @param tekstia tulostettava teksti
     * @return luettu teksti
     */
    public String lueTeksti(String tekstia) {
        System.out.print(tekstia);
        String teksti = this.lukija.next();
        return teksti;
    }

    /**
     * Tulostaa parametrina annetun tekstin ja lukee kokonaislukusyötteen
     * @return luetun kokonaisluvun
     */
    public int lueInteger() {
        String nro = "-1";
        try {
            nro = this.lukija.next();
        } catch (Exception Ex) {
        }
        return Integer.parseInt(nro);
    }

    /**
     * Tulostaa parametrina annetun tekstin ja lukee kokonaislukusyötteen
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
