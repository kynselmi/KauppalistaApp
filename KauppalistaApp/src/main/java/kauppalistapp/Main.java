package kauppalistapp;

import java.io.IOException;
import kauppalistapp.apurit.*;
import java.util.ArrayList;
import java.io.File;
import kauppalistapp.sovellus.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import kauppalistapp.komennot.*;
public class Main {

    public static void main(String[] args) throws IOException {
//        Sovellus sv = new Sovellus();
//        sv.kaynnista();
        Lukija lukija = new Lukija();
        EtsiTuote et = new EtsiTuote(1, "Test", lukija);
        et.suorita();
        
    }


}
