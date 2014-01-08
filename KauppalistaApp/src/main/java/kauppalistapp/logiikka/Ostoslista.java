package kauppalistapp.logiikka;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class Ostoslista implements Comparable<Ostoslista> {

    private String nimi;
    private ArrayList<Ostos> ostoslista;

    public Ostoslista(String nimi) {
        this.nimi = nimi;
        this.ostoslista = new ArrayList<Ostos>();
    }

    public void lisaaOstos(Ostos ostos) {
        boolean onkoJoListalla = false;
        for (Ostos listalla : this.ostoslista) {
            if (listalla.getTuote().equals(ostos.getTuote())) {
                listalla.lisaaMaaraaYhdella();
                onkoJoListalla = true;
            }
        }
        if (!onkoJoListalla) {
            this.ostoslista.add(ostos);
        }
    }

    public void lisaaOstoksiaListasta(List<String> lista) {
        for (String lisattava : lista) {
            String[] leikattu = lisattava.split("#");
            lisaaOstos(new Ostos(new Tuote(leikattu[0], Integer.parseInt(leikattu[1].split(",")[0]), Integer.parseInt(leikattu[1].split(",")[1])), 1));
        }
    }
    
    public void lisaaOstoksiaListastaTuotteita(List<Tuote> lista) {
        for (Tuote listalla : lista) {
            this.ostoslista.add(new Ostos(listalla, 1));
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

    public int montakoRivia() {
        return this.ostoslista.size();
    }

    public List<String> annaListana() {
        List<String> lista = new ArrayList<String>();
        for (Ostos ostos : this.ostoslista) {
            lista.add(ostos.getMaara() + "#" + ostos.getTuote().getNimi() + "#" + ostos.getTuote().getEurot() + "," + ostos.getTuote().getSentit());
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
            palautettava += ostos.toStringIlmanMaaraa() + "\n";
        }
        return palautettava;
    }

    public String getNimi() {
        return nimi;
    }

    @Override
    public int compareTo(Ostoslista ostoslista) {
        return this.nimi.hashCode() - ostoslista.getNimi().hashCode();
    }
    
}
