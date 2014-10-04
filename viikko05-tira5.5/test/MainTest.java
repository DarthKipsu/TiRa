import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("5.5")
public class MainTest {
    public void testi(String esi, String sisa, String jalki) {
        String uusi = Main.jalki(esi, sisa);
        assertTrue("Kun esijärjestys on " + esi +
                   " ja sisäjärjestys on " + sisa +
                   ", jälkijärjestyksen tulisi olla " + jalki + 
                   ", mutta metodisi antaa " + uusi + ".", jalki.equals(uusi));
    }
    
    @Test(timeout=1000)
    public void esimerkit() {
        testi("BDACE", "DBCAE", "DCEAB");
        testi("ABCD", "DCBA", "DCBA");
        testi("ABCD", "ACDB", "DCBA");
        testi("GEABFCD", "AEBGCFD", "ABECDFG");
    }
    
    @Test(timeout=1000)
    public void pienet() {
        testi("A", "A", "A");
        
        testi("AB", "BA", "BA");
        testi("AB", "AB", "BA");
        
        testi("ABC", "CBA", "CBA");
        testi("ABC", "BCA", "CBA");
        testi("ABC", "BAC", "BCA");
        testi("ABC", "ACB", "CBA");
        testi("ABC", "ABC", "CBA");
        
        testi("ABCDEF", "DCBEFA", "DCFEBA");
        testi("ABCDEFG", "CDGFEBA", "GFEDCBA");
        testi("ABCDEFG", "ABCDFEG", "FGEDCBA");
    }
    
    @Test(timeout=1000)
    public void suuri1() {
        testi("KCJHIDAELQPWNMRFSOVXGBZUTY",
              "JCDIQLEAHPRMFSNWVOXKGZBTYU",
              "JDQLEAIRSFMNVXOWPHCZYTUBGK");
    }

    @Test(timeout=1000)
    public void suuri2() {
        testi("BNLCWXKVSTEQPFRUDMJAIYHZGO",
              "WCLVKSETQPFURXNBJAIZHYGOMD",
              "WCVEURFPQTSKXLNZHOGYIAJMDB");
    }

}
