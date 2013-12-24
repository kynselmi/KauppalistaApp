package kauppalistapp.apurit;

import java.util.Scanner;

public class Lukija {

    private Scanner lukija;

    public Lukija() {
        this.lukija = new Scanner(System.in);
    }

    public String lueTeksti() {
        String teksti = this.lukija.next();
        return teksti;
    }

    public String lueTeksti(String tekstia) {
        System.out.print(tekstia);
        String teksti = this.lukija.next();
        return teksti;
    }

    public int lueInteger() {
        String nro = "-1";
        try {
            nro = this.lukija.next();            
        } catch (Exception Ex) {
        }
        return Integer.parseInt(nro);
    }
    
        public int lueInteger(String teksti) {
        int numero = -1;
        System.out.print(teksti);
        try {
            String nro = this.lukija.next();
            numero = Integer.parseInt(nro);
        } catch (Exception Ex) {

        }
        return numero;
    }


}
