package kauppalistapp.logiikka;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Lista {

    private HashMap<Tuote, Integer> maaranTietavaLista;

    public Lista() {
        this.maaranTietavaLista = new HashMap<Tuote, Integer>();
    }

    public void lisaaListalle(Tuote tuote, int maara) {
        if (this.maaranTietavaLista.containsKey(tuote)) {
            this.maaranTietavaLista.put(tuote, this.maaranTietavaLista.get(tuote) + maara);
        } else {
            this.maaranTietavaLista.put(tuote, maara);
        }
    }

    public List tuotteetListana() {
        List<Tuote> tuoteLista = new ArrayList<Tuote>();
        for (Tuote tuote : this.maaranTietavaLista.keySet()) {
            tuoteLista.add(tuote);
        }
        return tuoteLista;
    }

    public HashMap<Tuote, Integer> getMaaranTietavaLista() {
        return maaranTietavaLista;
    }
}
