
package kauppalistapp.komennot;
import kauppalistapp.apurit.*;

public abstract class Komento {
    
    private int numero;
    private String nimi;
    protected Lukija lukija;
    protected TiedostonLukija tiedostonLukija;
    protected TiedostonKirjoittaja tiedostonKirjoittaja;
    
    public Komento(int numero, String nimi, Lukija lukija) {
        this.numero = numero;
        this.nimi = nimi;
        this.lukija = lukija;
        this.tiedostonLukija = new TiedostonLukija();
        this.tiedostonKirjoittaja = new TiedostonKirjoittaja();
    }
    
    @Override
    public String toString() {
        return this.numero + " " + this.nimi;
    }
    

    public abstract boolean suorita();
        
    
}
