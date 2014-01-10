package kauppalistapp.kayttoliittyma;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
/**
 *
 * @author Aleksi
 */
public class SyotteenLukija implements ActionListener  {
    
    private JTextField syotekentta;
    private JTextField syoteSailo;

    public SyotteenLukija(JTextField syotekentta, JTextField syoteSailo) {
       this.syotekentta = syotekentta;
       this.syoteSailo = syoteSailo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.syoteSailo.setText(this.syotekentta.getText());
    }
    
    
    
}
