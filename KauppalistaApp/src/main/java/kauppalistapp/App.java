package kauppalistapp;

import kauppalistapp.logiikka.*;
import kauppalistapp.kayttoliittyma.*;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
            Tuote maito = new Tuote("Maito", 1);
            Tuote kala = new Tuote("Kala", 10);
            Tuote mehu = new Tuote("Mehu", 2);
            
            Lista lista = new Lista();
            
            lista.lisaaListalle(maito, 1);
            lista.lisaaListalle(kala, 1);
            lista.lisaaListalle(mehu, 3);
            
            TiedostoonKirjoittaja tk = new TiedostoonKirjoittaja("Lista1");
            tk.tallennaLista(lista.tuotteetListana());
    }
}
