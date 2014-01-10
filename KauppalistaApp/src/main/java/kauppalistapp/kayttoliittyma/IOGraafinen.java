package kauppalistapp.kayttoliittyma;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import kauppalistapp.apurit.Lukija;

/**
 *
 * @author Aleksi
 * 
 * Graafisen käyttöliittymän IO-implementaatio
 */
public class IOGraafinen implements IO {

    private JTextArea tekstialue;
    private JTextField kentta1;
    private JTextField kentta2;

    public IOGraafinen(JTextArea tekstialue) {
        this.tekstialue = tekstialue;

    }

    public IOGraafinen(JTextArea tekstialue, JTextField kentta1, JTextField kentta2) {
        this.tekstialue = tekstialue;
        this.kentta1 = kentta1;
        this.kentta2 = kentta2;
    }

    @Override
    public void tulostaTeksti(String teksti) {
        this.tekstialue.append(teksti + "\n");
    }

    @Override
    public void tulostaTekstiIlmanRivinVaihtoa(String teksti) {
        this.tekstialue.append(teksti);
    }

    @Override
    public int lueInteger() {
        return Integer.parseInt(this.kentta2.getText());
    }

    @Override
    public String lueTeksti() {      
        return this.kentta1.getText();
    }

    @Override
    public String lueTeksti(String teksti) {
        tulostaTekstiIlmanRivinVaihtoa(teksti);
        return this.kentta1.getText();
    }

    @Override
    public int lueInteger(String teksti) {
        tulostaTekstiIlmanRivinVaihtoa(teksti);
        return 1;
    }
}
