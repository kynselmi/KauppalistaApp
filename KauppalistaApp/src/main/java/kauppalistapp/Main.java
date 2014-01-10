package kauppalistapp;

import javax.swing.SwingUtilities;
import kauppalistapp.kayttoliittyma.GUI;
import kauppalistapp.kayttoliittyma.Tekstikayttoliittyma;


/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class Main {

    public static void main(String[] args) {        
        new Tekstikayttoliittyma().kaynnista();
//        GUI kayttis = new GUI();
//        SwingUtilities.invokeLater(kayttis);
    }
}

