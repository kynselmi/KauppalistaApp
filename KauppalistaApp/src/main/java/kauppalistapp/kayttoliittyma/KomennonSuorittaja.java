/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kauppalistapp.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import kauppalistapp.komennot.Komento;

/**
 *
 * @author Aleksi
 */
public class KomennonSuorittaja implements ActionListener {
    
    private Komento komento;
    private JTextArea tekstikentta;
    
    public KomennonSuorittaja(Komento komento, JTextArea tekstikentta) {
        this.komento = komento;
        this.tekstikentta = tekstikentta;
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tekstikentta.setText("");
        this.komento.suorita();
    }
    
}
