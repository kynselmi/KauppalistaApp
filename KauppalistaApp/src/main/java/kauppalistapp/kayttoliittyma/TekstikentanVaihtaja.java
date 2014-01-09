
package kauppalistapp.kayttoliittyma;

import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Aleksi
 */

public class TekstikentanVaihtaja implements ActionListener {

    private JTextField tekstikentta;
    private int komento;

    public TekstikentanVaihtaja(JTextField tekstikentta, int komento) {        
        this.tekstikentta = tekstikentta;
        this.komento = komento;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.tekstikentta.setText("" + this.komento);
              
    }
}
