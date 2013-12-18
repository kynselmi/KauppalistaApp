package kauppalistapp.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class TiedostoonKirjoittaja {

    private Scanner lukija;
    private FileWriter kirjoittaja;

    public TiedostoonKirjoittaja(String listanNimi) {
        try {
            this.kirjoittaja = new FileWriter(listanNimi + ".txt");
        } catch (Exception poikkeus) {
        }
    }

    public void kirjoitaTuoteListastaList(List<Tuote> tuotelista) {
        for (Tuote listalla : tuotelista) {
            try {
                this.kirjoittaja.write(listalla.toString() + "\n");
            } catch (Exception Ex) {
            }
        }
        try {
            this.kirjoittaja.close();
        } catch (Exception e) {
        }
    }

    public void kirjoitaTuotelistastaMap (Map<Tuote, Integer> tuotelista) throws FileNotFoundException, IOException {
        for (Tuote listalla : tuotelista.keySet()) {
            try {
                this.kirjoittaja.write(tuotelista.get(listalla) + "x " + listalla.toString());
            } catch (Exception Ex) {
            }
        }
        this.kirjoittaja.close();
    }
}
