package kauppalistapp.apurit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TiedostonLukija {
    private Scanner tiedostonLukija;
    
    public TiedostonLukija(String tiedosto) throws FileNotFoundException {
        this.tiedostonLukija = new Scanner(new File(tiedosto));
    }
    
    public boolean onkoSisaltoa() {
        if (this.tiedostonLukija.hasNext()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public List<String> lueJaAnnaListana() {
        ArrayList<String> lista = new ArrayList<String>();
        while (this.tiedostonLukija.hasNext()) {
            lista.add(this.tiedostonLukija.nextLine());
        }
        return lista;
    }
    
    public int riveja() throws FileNotFoundException {
        int riveja = 0;
        while (this.tiedostonLukija.hasNext()) {
            this.tiedostonLukija.nextLine();
            riveja++;
        }

        return riveja;
    }
}
