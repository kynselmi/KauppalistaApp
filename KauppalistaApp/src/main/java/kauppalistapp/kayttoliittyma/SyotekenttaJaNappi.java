/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kauppalistapp.kayttoliittyma;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Aleksi
 */
public class SyotekenttaJaNappi {

    private JPanel paneeli;

    public SyotekenttaJaNappi(JButton nappi) {
        this.paneeli = new JPanel();

        JTextField kentta = new JTextField();
        kentta.setColumns(5);

        this.paneeli.add(kentta);
        this.paneeli.add(nappi);

    }

    public SyotekenttaJaNappi(JTextField kentta1, JTextField kentta2, JTextField kentta3, JButton nappi) {
        this.paneeli = new JPanel();

        kentta1.setColumns(10);
        kentta2.setColumns(10);
        kentta3.setColumns(10);

        this.paneeli.add(kentta1);
        this.paneeli.add(kentta2);
        this.paneeli.add(kentta3);
        this.paneeli.add(nappi);
    }

    public JPanel getPaneeli() {
        return paneeli;
    }
}
