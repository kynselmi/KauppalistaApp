package kauppalistapp;

import java.io.IOException;
import kauppalistapp.apurit.*;
import java.util.ArrayList;
import java.io.File;

public class App {

    public static void main(String[] args) throws IOException {
        TiedostonKirjoittaja tk = new TiedostonKirjoittaja("src/pekka2.txt");
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Simo");
        lista.add("Kalevi");
        lista.add("Seppo");
        tk.kirjoitaTiedostoon(lista);
        
        TiedostonLukija tl = new TiedostonLukija("pekka2.txt");
        System.out.println(tl.onkoSisaltoa());
        System.out.println(tl.lueJaAnnaListana());
        

    }
}
