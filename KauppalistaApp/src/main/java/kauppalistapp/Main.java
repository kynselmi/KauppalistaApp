package kauppalistapp;

import kauppalistapp.apurit.*;
import kauppalistapp.logiikka.*;
import kauppalistapp.sovellus.Sovellus;
import java.util.List;
import java.util.ArrayList;


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

