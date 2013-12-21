package kauppalistapp.komennot;
import kauppalistapp.apurit.*;
import kauppalistapp.logiikka.*;


public class LisaaListalle extends Komento {
    
    public LisaaListalle(int numero, String nimi, Lukija lukija) {
        super(numero, nimi, lukija);
    }

    @Override
    public boolean suorita() {
        Lista tuotelista = new Lista();
        while (true) {
            int lisattavanRivinumero =  super.lukija.lueInteger("Anna lisattavan tuotteen rivinumero: ");
            Komento EtsiTuote = new EtsiTuote(1, "Etsii", this.lukija);
            EtsiTuote.suorita();
            break;
        }
        return true;
    }
    
}
