package kauppalistapp;

import kauppalistapp.logiikka.*;
import kauppalistapp.kayttoliittyma.*;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
