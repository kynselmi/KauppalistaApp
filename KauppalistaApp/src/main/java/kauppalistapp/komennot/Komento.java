
package kauppalistapp.komennot;
import kauppalistapp.apurit.Lukija;

public abstract class Komento {
    
    private int numero;
    private String nimi;
    protected Lukija lukija;
    
    public Komento(int numero, String nimi, Lukija lukija) {
        this.numero = numero;
        this.nimi = nimi;
        this.lukija = lukija;
    }
    

    public abstract boolean suorita();
        
    
}
