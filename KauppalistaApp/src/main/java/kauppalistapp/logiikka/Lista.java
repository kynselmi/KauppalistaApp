package kauppalistapp.logiikka;

import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;

public class Lista {

    private TreeMap<Tuote, Integer> maaranTietavaLista;
    private Tiedosto tiedosto;

    public Lista(String nimi) {
        this.maaranTietavaLista = new TreeMap<Tuote, Integer>();
        this.tiedosto = new Tiedosto(nimi);        
    }
    
    public void lisaaTuotteetTreeMappiin() {
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

    public void lisaaListalle(Tuote tuote, int maara) {        
        if (this.maaranTietavaLista.containsKey(tuote)) {
            this.maaranTietavaLista.put(tuote, this.maaranTietavaLista.get(tuote) + maara);
        } else {
            this.maaranTietavaLista.put(tuote, maara);
        }
    }

    public List<Tuote> tuotteetListana() {
        List<Tuote> tuoteLista = new ArrayList<Tuote>();
        for (Tuote tuote : this.maaranTietavaLista.keySet()) {
            tuoteLista.add(tuote);
        }
        return tuoteLista;
    }

    public TreeMap<Tuote, Integer> getMaaranTietavaLista() {
        return maaranTietavaLista;
    }

    public Tuote annaRivi(int riviNumero) {
        Tuote palautettavaTuote;
        try {
            palautettavaTuote = this.tuotteetListana().get(riviNumero);
        }   catch (Exception ex) {
            palautettavaTuote = null;
        }
        return palautettavaTuote;
    }

    public Tiedosto getTiedosto() {
        return tiedosto;
    }
    
    public List<String> annaStringListana() {
        List<String> StringLista = new ArrayList<String>();
        for (Tuote tuote : this.maaranTietavaLista.keySet()) {
            StringLista.add(tuote.toString());
        }
        return StringLista;
    }
    
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
