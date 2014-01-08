package kauppalistapp;

import kauppalistapp.apurit.*;
import kauppalistapp.logiikka.*;
import kauppalistapp.kayttoliittyma.Sovellus;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


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

