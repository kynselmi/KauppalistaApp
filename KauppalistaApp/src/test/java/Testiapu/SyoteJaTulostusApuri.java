package Testiapu;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class SyoteJaTulostusApuri {

    private ByteArrayInputStream syote;
    private ByteArrayOutputStream tulostus;

    public ByteArrayInputStream otaSyote(String syote) {
        this.syote = new ByteArrayInputStream(syote.getBytes());
        return this.syote;
    }

    public ByteArrayOutputStream tarkistaTulostus() {
        this.tulostus = new ByteArrayOutputStream();
        return this.tulostus;
    }

}
