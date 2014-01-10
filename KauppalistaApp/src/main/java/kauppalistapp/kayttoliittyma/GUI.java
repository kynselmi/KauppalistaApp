package kauppalistapp.kayttoliittyma;

/**
 *
 * @author Aleksi
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import kauppalistapp.apurit.Lukija;
import kauppalistapp.apurit.TiedostonLukija;
import kauppalistapp.komennot.EtsiTuote;
import kauppalistapp.komennot.JarjestaTuotteita;
import kauppalistapp.komennot.KasitteleListoja;
import kauppalistapp.komennot.Komento;
import kauppalistapp.komennot.LisaaTuote;
import kauppalistapp.komennot.Lopetus;
import kauppalistapp.komennot.PoistaTuote;
import kauppalistapp.komennot.TulostaTuotteet;
import kauppalistapp.logiikka.Ostoslista;
import kauppalistapp.logiikka.Tiedosto;
import kauppalistapp.logiikka.Tuote;
import kauppalistapp.logiikka.Tuotelista;

public class GUI implements Runnable {

    private JFrame paaikkuna;
    private JTextArea tekstikentta;
    private JTextField syotekentta1;
    private JTextField syotekentta2;
    private JTextField syotekentta3;
    private TreeMap<Integer, Komento> komennot;
    private Lukija lukija;
    private Tuotelista tallennetutTuotteet;
    private List<Ostoslista> tallennetutListat;
    private IO io;
    private JPanel nappaimet;
    private JTextField syoteSailo;

    public GUI() {
        this.paaikkuna = new JFrame("KauppalistApp");
        this.tekstikentta = new JTextArea();
        this.lukija = new Lukija();
        this.tallennetutTuotteet = new Tuotelista("Tuotteet");
        this.tallennetutListat = new ArrayList<Ostoslista>();
        this.syotekentta1 = new JTextField("");
        this.syotekentta2 = new JTextField("");
        this.syotekentta3 = new JTextField("");
        this.syoteSailo = new JTextField();
        this.io = new IOGraafinen(this.tekstikentta, this.syotekentta1, this.syotekentta2);

    }

    @Override
    public void run() {
        this.syoteSailo.setText("");
        this.komennot = new TreeMap<Integer, Komento>();
        lisaaTuotteet();
        lisaaListat();
        lisaaKomennot();

        this.paaikkuna.setPreferredSize(new Dimension(600, 400));
        this.paaikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        luoKomponentit(this.paaikkuna.getContentPane());

        this.paaikkuna.pack();
        this.paaikkuna.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());

        JButton syota = new JButton("Syota");
        SyotteenLukija syotteenlukija = new SyotteenLukija(this.syotekentta1, this.syoteSailo);
        syota.addActionListener(syotteenlukija);

        SyotekenttaJaNappi yksiKentta = new SyotekenttaJaNappi(syota);
        SyotekenttaJaNappi syotekenttaJaSyotaNappi = new SyotekenttaJaNappi(this.syotekentta1, this.syotekentta2, this.syotekentta3, syota);

        JButton tulostaTuotteet = new JButton("Tulosta tuotteet");
        tulostaTuotteet.addActionListener(new KomennonSuorittaja(this.komennot.get(1), this.tekstikentta));


        JButton lisaaTuote = new JButton("Lisää tuote");
        lisaaTuote.addActionListener(new KomennonSuorittaja(this.komennot.get(2), this.tekstikentta));

        JButton poistaTuote = new JButton("Poista tuote");
        poistaTuote.addActionListener(new KomennonSuorittaja(this.komennot.get(3), this.tekstikentta));

        JButton jarjestaTuotteita = new JButton("Järjestä tuotteita");
        jarjestaTuotteita.addActionListener(new KomennonSuorittaja(this.komennot.get(4), this.tekstikentta));

        JButton etsiTuote = new JButton("Etsi tuote");
        etsiTuote.addActionListener(new KomennonSuorittaja(this.komennot.get(5), this.tekstikentta));

        this.nappaimet = new JPanel();
        this.nappaimet.setLayout(new GridLayout(5, 1));
        this.nappaimet.add(tulostaTuotteet);
        this.nappaimet.add(lisaaTuote);
        this.nappaimet.add(poistaTuote);
        this.nappaimet.add(jarjestaTuotteita);
        this.nappaimet.add(etsiTuote);


        JPanel nappaimetJaTeksti = new JPanel();
        nappaimetJaTeksti.setLayout(new GridLayout(1, 2));

        nappaimetJaTeksti.add(this.nappaimet);
        nappaimetJaTeksti.add(this.tekstikentta);


        container.add(nappaimetJaTeksti, BorderLayout.CENTER);
        container.add(syotekenttaJaSyotaNappi.getPaneeli(), BorderLayout.SOUTH);

    }

    public boolean suoritaKomento(int komento) {
        return this.komennot.get(komento).suorita();
    }

    public void lisaaKomennot() {
        this.komennot.put(1, new TulostaTuotteet(1, "Tulosta tuotteet", this.tallennetutTuotteet, this.tallennetutListat, this.io));
        this.komennot.put(2, new LisaaTuote(2, "Lisaa tuote", this.tallennetutTuotteet, this.tallennetutListat, this.io));
        this.komennot.put(3, new PoistaTuote(3, "Poista tuote", this.tallennetutTuotteet, this.tallennetutListat, this.io));
        this.komennot.put(4, new JarjestaTuotteita(4, "Jarjesta tuotteita", this.tallennetutTuotteet, this.tallennetutListat, this.io));
        this.komennot.put(5, new EtsiTuote(5, "Etsi tuote", this.tallennetutTuotteet, this.tallennetutListat, this.io));
        this.komennot.put(6, new KasitteleListoja(6, "Kasittele listoja", this.tallennetutTuotteet, this.tallennetutListat, this.io));
        this.komennot.put(7, new Lopetus(7, "Lopeta", this.tallennetutTuotteet, this.tallennetutListat, this.io));
    }

    private void lisaaTuotteet() {
        TiedostonLukija tl = new TiedostonLukija();
        for (Tuote listalla : tl.annaTuoteListana(new Tiedosto("Tuotteet"))) {
            this.tallennetutTuotteet.lisaaTuote(listalla);
        }
    }

    private void lisaaListat() {
        TiedostonLukija tl = new TiedostonLukija();
        for (String tallennettuLista : tl.annaListanaIlmanRiviNumeroa(new Tiedosto("TallennetutListat"))) {
            Ostoslista ostoslista = tl.annaOstoslistana(new Tiedosto(tallennettuLista));
            this.tallennetutListat.add(ostoslista);
        }
    }
}
