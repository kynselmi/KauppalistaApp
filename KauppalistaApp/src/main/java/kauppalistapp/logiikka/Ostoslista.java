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
            if (listalla.getTuote().compareTo(ostos.getTuote()) == 0) {
                listalla.lisaaMaaraa(ostos.getMaara());
                onkoJoListalla = true;
            }
        }
        if (!onkoJoListalla) {
            this.ostoslista.add(ostos);
        }
    }

    public int annaTuotteidenMaara() {
        int tuotteita = 0;
        for (Ostos ostos : this.ostoslista) {
            tuotteita += ostos.getMaara();
        }
        return tuotteita;
    }

    public List<String> annaListana() {
        List<String> lista = new ArrayList<String>();
        for (Ostos ostos : this.ostoslista) {
            lista.add(ostos.getMaara() + "#" + ostos.getTuote().getNimi() + "#" + ostos.getTuote().getEurot() + "," + ostos.getTuote().getSentit());
        }
        return lista;
    }

    public String kokonaisHinta() {
        int eurot = 0;
        int sentit = 0;
        for (Ostos listalla : this.ostoslista) {
            eurot += listalla.getTuote().getEurot() * listalla.getMaara();
            sentit += listalla.getTuote().getSentit() * listalla.getMaara();
        }
        eurot += sentit / 100;
        sentit = sentit % 100;

        if (sentit > 10) {
            return eurot + "," + sentit + "e";
        } else {
            return eurot + ",0" + sentit + "e";
        }

    }

    @Override
    public String toString() {
        String palautettava = "";
        for (Ostos ostos : this.ostoslista) {
            palautettava += ostos + "\n";
        }
        return palautettava;
    }

    public String getNimi() {
        return nimi;
    }

    public ArrayList<Ostos> getOstoslista() {
        return ostoslista;
    }

    @Override
    public int compareTo(Ostoslista ostoslista) {
        return this.nimi.hashCode() - ostoslista.getNimi().hashCode();
    }
}
