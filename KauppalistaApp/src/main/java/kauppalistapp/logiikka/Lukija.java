
package kauppalistapp.logiikka;
import java.util.Scanner;

public class Lukija {
    
    private Scanner lukija;
    
    public Lukija() {
        this.lukija = new Scanner(System.in);
    }
    
    public String lueTeksti() {
        String teksti = this.lukija.nextLine();
        return teksti;
    }
    
    public int lueNumero() {
        int nro = Integer.parseInt(this.lukija.nextLine());
        return nro;
    }
     
}
