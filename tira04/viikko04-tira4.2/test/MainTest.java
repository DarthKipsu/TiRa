import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("4.2")
public class MainTest {
    public void testi(String ohjelma, int tulos) {
        int uusi = Main.laskin(ohjelma);
        assertTrue("Ohjelman '" + ohjelma + "' tulisi tuottaa tulos " + tulos +
                   ", mutta metodisi antaa tuloksen " + uusi + ".", tulos == uusi);
    }
    
    
    @Test(timeout=1000)
    public void esimerkit() {
        testi("@+", 2);
        testi("@@**", 1);
        testi("@+@+@+", 8);
        testi("@@@+++", 4);
    }    
    
    @Test(timeout=1000)
    public void testit() {
        testi("@", 1);
        testi("@@", 1);
        testi("@@@", 1);
        
        testi("@+", 2);
        testi("@+@+", 4);
        testi("@+@+@+", 8);
        testi("@+@+@+@+", 16);
        testi("@+@+@+@+@+", 32);
        testi("@+@+@+@+@+@+", 64);
        
        testi("@*", 1);
        testi("@*@*", 1);
        testi("@*@*@*", 1);
        
        testi("@+@*", 4);
        testi("@+@*@*", 16);
        testi("@+@*@*@*", 256);
        testi("@+@*@*@*@*", 65536);
        
        testi("@@+@@+++", 7);
        testi("@@+@@+@@++++", 15);
        testi("@@+@@+@@+@@+++++", 31);
        testi("@@+@@+@@+@@+@@++++++", 63);
        
        testi("@@@@@@@@@+++++++++@@@@@@@@********", 1000000000);
        
        testi("@@@@++++@*@@@+++@@**", 1000000);
    }        
    
}
