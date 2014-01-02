package kauppalistapp.logiikka;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

/**
 *
 * @author Kärkkäinen Aleksi
 * @version 0.1
 */
public class Lista {

    private LinkedHashMap<Tuote, Integer> maaranTietavaLista;
    private Tiedosto tiedosto;

    /**
     * Lista-olion konstruktori
     * @param nimi Listan nimi
     */
    public Lista(String nimi) {
        this.maaranTietavaLista = new LinkedHashMap<Tuote, Integer>();
        this.tiedosto = new Tiedosto(nimi);        
    }
    
    /**
     * Lisaa tuotteet Tiedostosta LinkedHashMappiin
     */
    public void lisaaTuotteetLinkedHashMappiin() {
        Lista lista = this.tiedosto.annaTuoteListana();
        for (int i = 0; i < lista.annaStringListana().size(); i++) {
            Tuote lisattava = lista.annaRivi(i);
            if (this.maaranTietavaLista.containsKey(lisattava)) {                
                this.maaranTietavaLista.put(lisattava, this.maaranTietavaLista.get(lisattava)+1);
            }
            else {
                this.maaranTietavaLista.put(lisattava, 1);
            }
        }        
    }
    
   
    /**
     * Lisaa LinkehHashMappiin tuotteen. Jos tuote on jo listalla, lisataan vain maaraa yhdella. 
     * @param tuote Lisattava tuote
     */
    public void lisaaListalle(Tuote tuote) {        
        if (this.maaranTietavaLista.containsKey(tuote)) {
            this.maaranTietavaLista.put(tuote, this.maaranTietavaLista.get(tuote) + 1);
        } else {
            this.maaranTietavaLista.put(tuote, 1);
        }
    }

    /**
     * Antaa LinkedHashMapin tuotteet listamuodossa
     * @return Listan, jossa Tuote-olioita
     * @see Tuote
     */
    public List<Tuote> tuotteetListana() {
        List<Tuote> tuoteLista = new ArrayList<Tuote>();
        for (Tuote tuote : this.maaranTietavaLista.keySet()) {
            tuoteLista.add(tuote);
        }
        return tuoteLista;
    }
    
    public LinkedHashMap<Tuote, Integer> getMaaranTietavaLista() {
        return maaranTietavaLista;
    }

    /**
     * Antaa rivinumeron mukaan tuotteen tuotelistalta
     * @param riviNumero Tuotteen rivinumero tuotelistalla
     * @return Tuote, joka on parametrinä annetulla rivillä
     */
    public Tuote annaRivi(int riviNumero) {
        Tuote palautettavaTuote;
        try {
            palautettavaTuote = this.tuotteetListana().get(riviNumero-1);
        }   catch (Exception ex) {
            palautettavaTuote = null;
        }
        return palautettavaTuote;
    }

 
    public Tiedosto getTiedosto() {
        return tiedosto;
    }
    
    /**
     * Antaa Lista-olion List-muodossa
     * @return Listalla olevien tuotteiden String-esitykset List-muodossa
     */
    public List<String> annaStringListana() {
        List<String> StringLista = new ArrayList<String>();
        for (Tuote tuote : this.maaranTietavaLista.keySet()) {
            StringLista.add(tuote.toString());
        }
        return StringLista;
    }
    
    /**
     * Antaa Lista-olion määrän kanssa List-muodossa
     * @return Listalla olevien tuotteiden String-esitykset lisättynä kappalemäärällä List-muodossa
     */
    public List<String> annaStringListanaMaaraMukana() {
        List<String> StringLista = new ArrayList<String>();
        for (Tuote tuote : this.maaranTietavaLista.keySet()) {
            if (this.maaranTietavaLista.get(tuote)==1) {
                StringLista.add(tuote.toString());
            }
            else {
                StringLista.add(this.maaranTietavaLista.get(tuote) + "x " + tuote.toString());
            }
        }
        return StringLista;
    }
    
    /**
     * Antaa tuotteiden määrän listalla
     * @return tuotteiden kappalemäärä
     */
    public int annaTuotteidenMaara() {
        int tuotteidenMaara = 0;
        for (Tuote tuote : this.maaranTietavaLista.keySet()) {
            tuotteidenMaara += this.maaranTietavaLista.get(tuote);
        }
        return tuotteidenMaara;
    }
    
    @Override
    public String toString() {
        String tulostus = "";
        for (String listalla : this.annaStringListana()) {
            tulostus += listalla + "\n";
        }
        return tulostus;
    }
    
}
