package kauppalistapp.komennot;

import kauppalistapp.apurit.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import kauppalistapp.apurit.ListanJarjestaja;

public class JarjestaTuotteita extends Komento {

    public JarjestaTuotteita(int numero, String nimi, Lukija lukija) {
        super(numero, nimi, lukija);
    }

    @Override
    public boolean suorita() {
        TiedostonLukija tl = new TiedostonLukija();
        TiedostonKirjoittaja tk = new TiedostonKirjoittaja();
        System.out.println("1 Aakkosjärjestykseen laskevasti");
        System.out.println("2 Aakkosjärjestykseen nousevasti");
        int komento = this.lukija.lueInteger("Anna komento: ");

        ListanJarjestaja jarjestaja = new ListanJarjestaja();
        List<String> muokattavaLista = tl.annaListanaIlmanRiviNumeroa("Tuotteet.txt");
        if (komento == 1) {
            muokattavaLista = jarjestaja.jarjestaAakkosjarjestykseenLaskevasti(muokattavaLista);
        }
        if (komento == 2) {
            muokattavaLista = jarjestaja.jarjestaAakkosjarjestykseenNousevasti(muokattavaLista);
        }
        tk.tyhjennaTiedosto("Tuotteet.txt");
        tk.kirjoitaTiedostoon(muokattavaLista, "Tuotteet.txt");
        return true;
    }
}
