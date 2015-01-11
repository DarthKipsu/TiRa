import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("11.5")
public class MainTest {
    private String kaarilista(int[] mista, int[] minne, int[] matka) {
        String tulos = "";
        for (int i = 0; i < mista.length; i++) {
            if (tulos.equals("")) tulos = mista[i] + "-" + minne[i] + "(" + matka[i] + ")";
            else tulos += ", "  + mista[i] + "-" + minne[i] + "(" + matka[i] + ")";
        }
        return "[" + tulos + "]";
    }    
    
    public void pieniTesti(int n, int[] mista, int[] minne, int[] matka, long tulos) {
        String sisalto = kaarilista(mista, minne, matka);
        long uusi = Main.reittimaara(n, mista, minne, matka);
        assertTrue("Kun kaupunkeja on " + n + " ja tiet ovat " + sisalto +
                   ", lyhimpiä reittejä on " + tulos +
                   ", mutta metodisi antaa " + uusi + ".",
                   tulos == uusi);
    }
    
    public void suuriTesti(int n, int[] mista, int[] minne, int[] matka, long tulos) {
        long uusi = Main.reittimaara(n, mista, minne, matka);
        assertTrue("Metodisi toimii väärin suurella syötteellä.",
                   tulos == uusi);
    }
        
    @Test(timeout=1000)
    public void esimerkit() {
        pieniTesti(3, new int[] {1, 2}, new int[] {2, 3}, new int[] {5, 3}, 1);        
        pieniTesti(3, new int[] {1, 2, 1}, new int[] {2, 3, 3}, new int[] {2, 3, 5}, 2);
        pieniTesti(5, new int[] {1, 1, 1, 2, 3, 4}, new int[] {2, 3, 4, 5, 5, 5}, new int[] {1, 1, 1, 1, 1, 1}, 3);
        pieniTesti(5, new int[] {1, 1, 1, 2, 3, 4}, new int[] {2, 3, 4, 5, 5, 5}, new int[] {1, 2, 2, 1, 1, 1}, 1);        
    }
    
    @Test(timeout=1000)
    public void pienet() {
        pieniTesti(2, new int[] {}, new int[] {}, new int[] {}, 0);
        pieniTesti(2, new int[] {1}, new int[] {2}, new int[] {5}, 1);
        
        pieniTesti(3, new int[] {1, 2}, new int[] {2, 3}, new int[] {5, 5}, 1);
        pieniTesti(3, new int[] {1, 2, 1}, new int[] {2, 3, 3}, new int[] {1, 2, 3}, 2);
        pieniTesti(3, new int[] {1, 2, 1}, new int[] {2, 3, 3}, new int[] {3, 2, 1}, 1);
        
        pieniTesti(4, new int[] {1, 1, 2, 3}, new int[] {2, 3, 4, 4}, new int[] {2, 1, 1, 1}, 1);
        pieniTesti(4, new int[] {1, 1, 2, 3}, new int[] {2, 3, 4, 4}, new int[] {1, 1, 1, 1}, 2);
        
        pieniTesti(6, new int[] {1, 2, 3, 4, 5}, new int[] {2, 3, 4, 5, 6}, new int[] {1, 1, 1, 1, 1}, 1);
        pieniTesti(4, new int[] {1, 2, 3}, new int[] {2, 3, 4}, new int[] {999999999, 999999999, 999999999}, 1);
    }
    
    @Test(timeout=1000)
    public void suuri1() {
        int n = 100000;
        int[] mista = new int[n-1];
        int[] minne = new int[n-1];
        int[] matka = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            mista[i] = i+1;
            minne[i] = i+2;
            matka[i] = 1;
        }
        suuriTesti(n, mista, minne, matka, 1);
    }
    
    @Test(timeout=1000)
    public void suuri2() {
        int n = 100000;
        int[] mista = new int[n-1];
        int[] minne = new int[n-1];
        int[] matka = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            mista[i] = i+1;
            minne[i] = i+2;
            matka[i] = 999999999;
        }
        suuriTesti(n, mista, minne, matka, 1);
    }

    public void hassuTesti(int n) {
        int[] mista = new int[(n-1)/3*4];
        int[] minne = new int[(n-1)/3*4];
        int[] matka = new int[(n-1)/3*4];
        int c = 0;
        long maara = 1;
        for (int i = 0; i < (n-1)/3*4; i += 4) {
            mista[i] = i+1-c;
            minne[i] = i+2-c;
            mista[i+1] = i+1-c;
            minne[i+1] = i+3-c;
            mista[i+2] = i+2-c;
            minne[i+2] = i+4-c;
            mista[i+3] = i+3-c;
            minne[i+3] = i+4-c;
            matka[i] = 1;
            matka[i+1] = 1;
            matka[i+2] = 1;
            matka[i+3] = 1;
            c++;
            maara *= 2;
        }
        suuriTesti(n, mista, minne, matka, maara);        
    }
    
    @Test(timeout=1000)
    public void suuri3() {
        hassuTesti(40);
    }

    @Test(timeout=1000)
    public void suuri4() {
        hassuTesti(100);
    }
    
    @Test(timeout=1000)
    public void suuri5() {
        hassuTesti(160);
    }
    
}
