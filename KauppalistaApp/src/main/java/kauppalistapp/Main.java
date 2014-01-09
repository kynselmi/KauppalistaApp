package kauppalistapp;

import javax.swing.SwingUtilities;
import kauppalistapp.kayttoliittyma.GUI;
import kauppalistapp.kayttoliittyma.Graafinenkayttoliittyma;
import kauppalistapp.kayttoliittyma.Tekstikayttoliittyma;


/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class Main {

    public static void main(String[] args) {        
        new Tekstikayttoliittyma().kaynnista();
//        new Graafinenkayttoliittyma().kaynnista();
    }
}

