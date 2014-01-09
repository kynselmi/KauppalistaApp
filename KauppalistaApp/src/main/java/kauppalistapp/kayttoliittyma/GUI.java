package kauppalistapp.kayttoliittyma;

/**
 *
 * @author Aleksi
 */
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUI implements Runnable {

    private JFrame paaikkuna;
    private JTextArea tekstikentta;
    private JTextField syotekentta;

    public GUI() {
        this.paaikkuna = new JFrame("KauppalistApp");
        this.tekstikentta = new JTextArea("Moro");
        this.syotekentta = new JTextField("0");
    }

    @Override
    public void run() {

        this.paaikkuna.setPreferredSize(new Dimension(600, 400));
        this.paaikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        luoKomponentit(this.paaikkuna.getContentPane());

        this.paaikkuna.pack();
        this.paaikkuna.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        JPanel nappaimet = new JPanel();
        nappaimet.setLayout(new GridLayout(5, 1));
        JButton tulosta = new JButton("Tulosta tuotteet");
        TekstikentanVaihtaja tv = new TekstikentanVaihtaja(this.syotekentta, 1);
        tulosta.addActionListener(tv);
        nappaimet.add(new JButton("Tulosta tuotteet"));
        
        
        container.add(nappaimet);
        container.add(this.tekstikentta);
        container.add(this.syotekentta);
    }

    public void vaihdaTekstikentta(String teksti) {
        this.tekstikentta.append(teksti + "\n");
    }
    
    public int annaSyoteKentasta() {
        return Integer.parseInt(this.syotekentta.getText());
    }
    
    public boolean nappiaPainettu() {
        boolean palautettava = false;
        if (!this.syotekentta.getText().equals("0")) {
            palautettava = true;
        }
        return palautettava;
    }
}
