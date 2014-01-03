package kauppalistapp.logiikka;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class Ostoslista {

    public String getNimi() {
        return nimi;
    }
    private String nimi;
    private ArrayList<Ostos> ostoslista;

    public Ostoslista(String nimi) {
        this.nimi = nimi;
        this.ostoslista = new ArrayList<Ostos>();
    }

    public void lisaaOstos(Ostos ostos) {
        if (this.ostoslista.contains(ostos)) {
            ostos.lisaaMaaraaYhdella();
        } else {
            this.ostoslista.add(ostos);
        }
    }

    public void lisaaOstoksiaListasta(List<String> lista) {
        for (String lisattava : lista) {
            String[] leikattu = lisattava.split(",");
            lisaaOstos(new Ostos(new Tuote(leikattu[0].trim(), Integer.parseInt(leikattu[1].trim()), Integer.parseInt(leikattu[2].split("e")[0])), 1));
        }
    }
        

    public int annaTuotteidenMaara() {
        int tuotteita = 0;
        for (Ostos ostos : this.ostoslista) {
            tuotteita += ostos.getMaara();
        }
        return tuotteita;
    }

    public Ostos annaOstosRivilta(int rivi) {
        return this.ostoslista.get(rivi - 1);
    }

    public boolean loytyykoRivia(int rivi) {
        try {
            this.ostoslista.get(rivi - 1);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    public List<String> annaListana() {
        List<String> lista = new ArrayList<String>();
        for (Ostos ostos : this.ostoslista) {
            lista.add(ostos.toString());
        }
        return lista;
    }

    @Override
    public String toString() {
        String palautettava = "";
        for (Ostos ostos : this.ostoslista) {
            palautettava += ostos + "\n";
        }
        return palautettava;
    }
    
    public String toStringIlmanMaaraa() {
        String palautettava = "";
        for (Ostos ostos : this.ostoslista) {
            palautettava +=  ostos.toStringIlmanMaaraa() + "\n";
        }
        return palautettava;
    }
}
