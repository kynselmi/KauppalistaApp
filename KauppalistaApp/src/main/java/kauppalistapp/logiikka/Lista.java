package kauppalistapp.logiikka;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Lista {

    private HashMap<Tuote, Integer> maaranTietavaLista;
    private Tiedosto tiedosto;

    public Lista(String nimi) {
        this.maaranTietavaLista = new HashMap<Tuote, Integer>();
        this.tiedosto = new Tiedosto(nimi);
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

    public HashMap<Tuote, Integer> getMaaranTietavaLista() {
        return maaranTietavaLista;
    }

    public Tuote annaRivi(int riviNumero) {
        int rivi = 1;
        Tuote palautettavaTuote = null;
        for (Tuote tuote : this.maaranTietavaLista.keySet()) {
            if (rivi == riviNumero) {
                palautettavaTuote = tuote;
            }
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
    
}
