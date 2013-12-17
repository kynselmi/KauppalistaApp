package kauppalistapp.kayttoliittyma;

import java.awt.Dimension;
import java.awt.Container;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;

public class Kayttoliittyma implements Runnable {

    private JFrame paaikkuna;

    @Override
    public void run() {
        this.paaikkuna = new JFrame("KauppalistApp");
        
        this.paaikkuna.setPreferredSize(new Dimension(500, 500));
        this.paaikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        luoKomponentit(this.paaikkuna.getContentPane());

        this.paaikkuna.pack();
        this.paaikkuna.setVisible(true);
    }
    
        public void luoKomponentit(Container cont) {
            CardLayout komponenttienSijoittelu = new CardLayout(20, 20);
            cont.setLayout(komponenttienSijoittelu);
            
            cont.add(new JLabel("Jotai"));
        }
}
