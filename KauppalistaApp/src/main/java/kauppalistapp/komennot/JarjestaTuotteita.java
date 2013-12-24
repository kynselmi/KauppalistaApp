package kauppalistapp.komennot;

import kauppalistapp.apurit.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import kauppalistapp.apurit.ListanJarjestaja;
import kauppalistapp.logiikka.Lista;
import kauppalistapp.logiikka.Tiedosto;

public class JarjestaTuotteita extends Komento {

    public JarjestaTuotteita(int numero, String nimi, Lukija lukija, Tiedosto tiedosto, List<Lista> tallennetutListat) {
        super(numero, nimi, lukija, tiedosto, tallennetutListat);
    }

    @Override
    public boolean suorita() {
        TiedostonKirjoittaja tk = new TiedostonKirjoittaja();
        System.out.println("1 Aakkosjärjestykseen laskevasti");
        System.out.println("2 Aakkosjärjestykseen nousevasti");
        int komento = this.lukija.lueInteger("Anna komento: ");

        ListanJarjestaja jarjestaja = new ListanJarjestaja();
        List<String> muokattavaLista = super.tiedostonLukija.annaListanaIlmanRiviNumeroa(super.tiedosto.getTiedosto());
        if (komento == 1) {
            muokattavaLista = jarjestaja.jarjestaAakkosjarjestykseenLaskevasti(muokattavaLista);
        }
        if (komento == 2) {
            muokattavaLista = jarjestaja.jarjestaAakkosjarjestykseenNousevasti(muokattavaLista);
        }
        tk.tyhjennaTiedosto(this.tiedosto.getNimi());
        tk.kirjoitaTiedostoon(muokattavaLista, this.tiedosto.getNimi());
        return true;
    }
}
