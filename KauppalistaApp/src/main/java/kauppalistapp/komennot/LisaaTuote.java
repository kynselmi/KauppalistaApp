package kauppalistapp.komennot;
import kauppalistapp.logiikka.*;
import kauppalistapp.apurit.Lukija;

public class LisaaTuote extends Komento {

    public LisaaTuote(int numero, String nimi, Lukija lukija) {
        super(numero, nimi, lukija);
    }

    
    @Override
    public boolean suorita() {
        String nimi = super.lukija.lueTeksti("Anna tuotteen nimi: ");
        double hinta = super.lukija.lueLiukuluku("Anna tuotteen hinta: ");
        if (hinta == 0.0) {
            Tuote tuote = new Tuote(nimi);
        }
        else {
            Tuote tuote = new Tuote(nimi, hinta);
        }
        return true;
    }        


}
