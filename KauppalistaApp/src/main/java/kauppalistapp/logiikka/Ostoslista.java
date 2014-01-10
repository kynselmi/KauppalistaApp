package kauppalistapp.logiikka;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 * 
 * Ostoslista sisältää Ostos-olioita ja nimen
 */
public class Ostoslista implements Comparable<Ostoslista> {

    private String nimi;
    private ArrayList<Ostos> ostoslista;

    /**
     * Ostoslista-olion konstruktori
     *
     * @param nimi Ostoslistan nimi
     */
    public Ostoslista(String nimi) {
        this.nimi = nimi;
        this.ostoslista = new ArrayList<Ostos>();
    }

    /**
     * Lisaa Ostos-olion Ostoslistalle
     *
     * @param ostos lisattava ostos
     */
    public void lisaaOstos(Ostos ostos) {
        boolean onkoJoListalla = false;
        for (Ostos listalla : this.ostoslista) {
            if (listalla.getTuote().equals(ostos.getTuote())) {
                listalla.lisaaMaaraa(ostos.getMaara());
                onkoJoListalla = true;
            }
        }
        if (!onkoJoListalla) {
            this.ostoslista.add(ostos);
        }
    }
    
    /**
     * Poistaa annetun ostoksen listalta
     * 
     * @param ostos poistettava ostos
     */
    public void poistaOstos(Ostos ostos) {
        int rivi = -1;
        
        int riviNro = 0;
        for (Ostos listalla : this.ostoslista) {
            if (listalla.equals(ostos)) {
                rivi = riviNro;
            }
            riviNro++;
        }
        this.ostoslista.remove(rivi);
    }
    
    /**
     * Antaa annetulta rivinumerolta Ostoksen
     *
     * @param riviNro annettu rivinumero
     * @return rivinumerolla oleva ostos
     */
    public Ostos annaRivi(int riviNro) {        
        return this.ostoslista.get(riviNro-1);
    }
            

    /**
     * Antaa Ostoslistasta Tuote-olioiden määrän
     *
     * @return Tuote-olioiden määrä
     */
    public int annaTuotteidenMaara() {
        int tuotteita = 0;
        for (Ostos ostos : this.ostoslista) {
            tuotteita += ostos.getMaara();
        }
        return tuotteita;
    }

    /**
     * Antaa Ostoslistan Listana String-olioita valmiina annettavaksi TiedostonKirjoittajalle
     *
     * @return lista String-olioita
     * @see TiedostonKirjoittaja
     */
    public List<String> annaListana() {
        List<String> lista = new ArrayList<String>();
        for (Ostos ostos : this.ostoslista) {
            lista.add(ostos.getMaara() + "#" + ostos.getTuote().getNimi() + "#" + ostos.getTuote().getEurot() + "," + ostos.getTuote().getSentit());
        }
        return lista;
    }

    /**
     * Antaa Ostoslistan kokonaishinnan 
     *
     * @return hinta
     */
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
        int riviNro = 1;
        for (Ostos ostos : this.ostoslista) {
            palautettava += riviNro + "  " + ostos + "\n";
            riviNro++;
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
