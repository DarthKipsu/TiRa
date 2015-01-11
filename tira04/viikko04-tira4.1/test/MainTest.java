import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("4.1")
public class MainTest {
    public void pieniTesti(String mjono, boolean tulos) {
        boolean uusi = Main.sulutus(mjono);
        if (tulos) {
            assertTrue("Merkkijono " + mjono + " on sulutettu oikein, " +
                       "mutta metodisi palauttaa 'false'.", uusi == tulos);
        } else {
            assertTrue("Merkkijono " + mjono + " on sulutettu väärin, " +
                       "mutta metodisi palauttaa 'true'.", uusi == tulos);            
        }
    }

    public void suuriTesti(String mjono, boolean tulos) {
        boolean uusi = Main.sulutus(mjono);
        assertTrue("Metodi toimii väärin suurella syötteellä.", uusi == tulos);
    }
    
    
    @Test(timeout=1000)
    public void esimerkit() {
        pieniTesti("((()))", true);
        pieniTesti("(())()", true);
        pieniTesti("(()))(", false);
        pieniTesti("())(()", false);
    }
    
    @Test(timeout=1000)
    public void pienet() {
        pieniTesti("(", false);
        pieniTesti(")", false);
        
        pieniTesti("((", false);
        pieniTesti("()", true);
        pieniTesti(")(", false);
        pieniTesti("))", false);
        
        pieniTesti("(((", false);
        pieniTesti("(()", false);
        pieniTesti("()(", false);
        pieniTesti("())", false);
        pieniTesti(")((", false);
        pieniTesti(")()", false);
        pieniTesti("))(", false);
        pieniTesti(")))", false);
        
        pieniTesti("((((", false);
        pieniTesti("((()", false);
        pieniTesti("(()(", false);
        pieniTesti("(())", true);
        pieniTesti("()((", false);
        pieniTesti("()()", true);
        pieniTesti("())(", false);
        pieniTesti("()))", false);
        pieniTesti(")(((", false);
        pieniTesti(")(()", false);
        pieniTesti(")()(", false);
        pieniTesti(")())", false);
        pieniTesti("))((", false);
        pieniTesti("))()", false);
        pieniTesti(")))(", false);
        pieniTesti("))))", false);
        
        pieniTesti("(()())(()())(()())", true);
        pieniTesti("(()())(()())(()()", false);
        pieniTesti("(()()))((()())", false);
        pieniTesti("()()()(())()()()", true);
        pieniTesti("()()()(()))()()", false);
        pieniTesti("()()()(())()(()", false);
        pieniTesti("()(())((()))(((())))((((()))))", true);
        pieniTesti("()(())((()))(((())))((((())))", false);
    }    

    @Test(timeout=1000)
    public void suuri1() {    
        int n = 100000;
        char[] mjono = new char[n];
        for (int i = 0; i < n; i++) {
            if (i%2 == 0) mjono[i] = '(';
            else mjono[i] = ')';
        }
        suuriTesti(new String(mjono), true);
    }
    
    @Test(timeout=1000)
    public void suuri2() {
        int n = 100000;
        char[] mjono = new char[n];
        for (int i = 0; i < n; i++) {
            if (i < n/2) mjono[i] = '(';
            else mjono[i] = ')';
        }
        suuriTesti(new String(mjono), true);
    }
    
    @Test(timeout=1000)
    public void suuri3() {
        int n = 100000;
        char[] mjono = new char[n];
        for (int i = 0; i < n; i++) {
            mjono[i] = '(';
        }
        suuriTesti(new String(mjono), false);
    }

    @Test(timeout=1000)
    public void suuri4() {
        int n = 100000;
        char[] mjono = new char[n];
        for (int i = 0; i < n; i++) {
            mjono[i] = ')';
        }
        suuriTesti(new String(mjono), false);
    }
    
    
    @Test(timeout=1000)
    public void suuri5() {
        int n = 100000;
        char[] mjono = new char[n];
        for (int i = 0; i < n; i++) {
            if (i <= n/2) mjono[i] = '(';
            else mjono[i] = ')';
        }
        suuriTesti(new String(mjono), false);
    }
    
    
}
