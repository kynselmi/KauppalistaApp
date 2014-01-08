///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package kauppalistapp.apurit;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import kauppalistapp.logiikka.Tuote;
//import kauppalistapp.logiikka.Tuotelista;
//
//
///**
// *
// * @author Kärkkäinen Aleksi
// * @version 0.1
// */
//public class ListanJarjestaja {    
//    
//    
    /**
     * Jarjestaa List-olion laskevaan aakkosjärjestykseen
     * @param lista jarjestettava lista
     * @return jarjestetty lista
     */
//    public Tuotelista jarjestaAakkosjarjestykseenLaskevasti(Tuotelista tuotelista) {  
//        List<String> kaannettavaLista = tuotelista.annaListana();
//        Collections.sort(kaannettavaLista);
//        return kaannettavaLista;
//    }
    
    /**
     * Jarjestaa List-olion nousevaan aakkosjärjestykseen
     * @param tuotelista jarjestettava lista
     * @return jarjestetty lista
//     */
//    public Tuotelista jarjestaAakkosjarjestykseenNousevasti(Tuotelista tuotelista) {
//        return this.listanKaantaja(this.jarjestaAakkosjarjestykseenLaskevasti(tuotelista));
//    }
//    
//    private Tuotelista listanKaantaja(Tuotelista kaannettavaLista) {
//        List<Tuote> kaannettyLista = new ArrayList<Tuote>();         
//        int kaannettavanListanKoko = kaannettavaLista.annaKoko();
//        for (int i = 1; 0 <= kaannettavanListanKoko-i ; i++) {
//            kaannettyLista.add(kaannettavaLista.annaRivi(i));
//        }
//        
//        kaannettavaLista.tyhjennaTuotelista();
//        for (int i = 0; i<kaannettyLista.size(); i++) {
//            kaannettavaLista.lisaaTuote(kaannettyLista.get(i));
//        }
//        
//        return kaannettavaLista;
//    }
//    
//}
