package kauppalistapp;

import kauppalistapp.logiikka.Tiedosto;
import kauppalistapp.sovellus.Sovellus;


/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class Main {


    public static void main(String[] args) {
        Sovellus sv = new Sovellus();
        sv.kaynnista();
    }
}

