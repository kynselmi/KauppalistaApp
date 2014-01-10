
package kauppalistapp.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Aleksi
 */
public class TekstikentanVaihtaja implements ActionListener {
    
    private JPanel vanha;
    private JPanel uusi;
    
    public TekstikentanVaihtaja(JPanel vanha, JPanel uusi) {
        this.vanha = vanha;
        this.uusi = uusi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.vanha = this.uusi;
    }
    
}
