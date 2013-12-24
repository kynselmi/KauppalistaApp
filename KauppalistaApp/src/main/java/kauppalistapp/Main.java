package kauppalistapp;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import kauppalistapp.sovellus.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import kauppalistapp.apurit.*;
import kauppalistapp.logiikka.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Sovellus sv = new Sovellus();
        sv.kaynnista();
    }


}
