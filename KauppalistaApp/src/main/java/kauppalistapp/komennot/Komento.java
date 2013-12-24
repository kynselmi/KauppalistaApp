
package kauppalistapp.komennot;
import kauppalistapp.apurit.*;
import kauppalistapp.logiikka.Tiedosto;
import kauppalistapp.logiikka.Lista;
import java.util.List;

public abstract class Komento {
    
    private int numero;
    private String nimi;
    protected Lukija lukija;
    protected TiedostonLukija tiedostonLukija;
    protected TiedostonKirjoittaja tiedostonKirjoittaja;
    protected Tiedosto tiedosto;
    protected List<Lista> tallennetutListat;
    
    public Komento(int numero, String nimi, Lukija lukija, Tiedosto tiedosto, List<Lista> tallennetutListat) {
        this.numero = numero;
        this.nimi = nimi;
        this.lukija = lukija;
        this.tiedostonLukija = new TiedostonLukija();
        this.tiedostonKirjoittaja = new TiedostonKirjoittaja();
        this.tiedosto = tiedosto;
        this.tallennetutListat = tallennetutListat;
        
    }
    
    @Override
    public String toString() {
        return this.numero + " " + this.nimi;
    }
    

    public abstract boolean suorita();
        
    
}
