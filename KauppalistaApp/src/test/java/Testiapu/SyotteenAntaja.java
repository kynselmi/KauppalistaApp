package Testiapu;

import java.io.ByteArrayInputStream;
public class SyotteenAntaja {
    
    private ByteArrayInputStream syote;
    
    public void syotaString(String syote) {
        this.syote = new ByteArrayInputStream(syote.getBytes());
        System.setIn(this.syote);
    }
    
}
