package kauppalistapp.apurit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class ListanJarjestajaTest {

    private List<String> jarjestettava;
    private ListanJarjestaja listanJarjestaja;

    public ListanJarjestajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.jarjestettava = new ArrayList<String>();
        this.listanJarjestaja = new ListanJarjestaja();
        this.jarjestettava.add("Tauno");
        this.jarjestettava.add("Bertta");
        this.jarjestettava.add("Zorro");
        this.jarjestettava.add("Kake");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void laittaaAakkosjarjestykseenLaskevasti() {
        this.jarjestettava = this.listanJarjestaja.jarjestaAakkosjarjestykseenLaskevasti(this.jarjestettava);
        assertEquals("Bertta", this.jarjestettava.get(0));
        assertEquals("Kake", this.jarjestettava.get(1));
        assertEquals("Tauno", this.jarjestettava.get(2));
        assertEquals("Zorro", this.jarjestettava.get(3));
    }

    @Test
    public void laittaaAakkosjarjestykseenNousevasti() {
        this.jarjestettava = this.listanJarjestaja.jarjestaAakkosjarjestykseenNousevasti(this.jarjestettava);
        assertEquals("Bertta", this.jarjestettava.get(3));
        assertEquals("Kake", this.jarjestettava.get(2));
        assertEquals("Tauno", this.jarjestettava.get(1));
        assertEquals("Zorro", this.jarjestettava.get(0));
    }
}
