package kauppalistapp;

import kauppalistapp.logiikka.*;
import kauppalistapp.kayttoliittyma.*;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
            Tuote maito = new Tuote("Maito");
            Tuote kala = new Tuote("Kala", 10);
            Tuote mehu = new Tuote("Mehu", 2);
            
            Lista lista = new Lista();
            
            lista.lisaaListalle(maito, 1);
            lista.lisaaListalle(kala, 1);
            lista.lisaaListalle(mehu, 3);

            System.out.println(maito.getHinta());
    }
}
