package kauppalistapp.apurit;

import java.util.Scanner;

public class Lukija {

    private Scanner lukija;

    public Lukija() {
        this.lukija = new Scanner(System.in);
    }

    public String lueTeksti() {
        String teksti = this.lukija.nextLine();
        return teksti;
    }

    public String lueTeksti(String tekstia) {
        System.out.println(tekstia);
        String teksti = this.lukija.nextLine();
        return teksti;
    }

    public int lueInteger() {
        int nro = -150;
        try {
            nro = Integer.parseInt(this.lukija.nextLine());
        } catch (Exception Ex) {
            System.out.println("Syötteesi ei ole kokonaisluku");

        }
        return nro;
    }

    public double lueLiukuluku() {
        return lukija.nextDouble();
    }

    public double lueLiukuluku(String tekstia) {
        System.out.println(tekstia);
        return lukija.nextDouble();
    }
}
