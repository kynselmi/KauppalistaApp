
package kauppalistapp.logiikka;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.List;

public class TiedostoonKirjoittaja {
    
    private Scanner lukija;
    private FileWriter kirjoittaja;
    
    public TiedostoonKirjoittaja(String listanNimi) {
        try {this.kirjoittaja = new FileWriter(listanNimi + ".txt");}
        catch (Exception poikkeus) {
        }
    }
    
    public void kirjoitaTuoteListastaListMuodossa(List<Tuote> tuotelista) {
        for (Tuote listalla : tuotelista) {
            try {
                this.kirjoittaja.write(listalla.toString() + "\n");
            }
            catch (Exception Ex) {                
            }
        }
        try {this.kirjoittaja.close();}
        catch (Exception e) {            
        }
    }    
    
}
