import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("10.4")
public class MainTest {
    private String kaarilista(int[] mista, int[] minne) {
        String tulos = "";
        for (int i = 0; i < mista.length; i++) {
            if (tulos.equals("")) tulos = mista[i] + "-" + minne[i];
            else tulos += ", "  + mista[i] + "-" + minne[i];
        }
        return "[" + tulos + "]";
    }
    
    public void pieniTesti(int n, int[] mista, int[] minne, boolean tulos) {
        String sisalto = kaarilista(mista, minne);
        boolean uusi = Main.lahjajako(n, mista, minne);
        if (tulos) {
            assertTrue("Kun henkilöitä on " + n + " ja ystävyydet ovat " + sisalto +
                       ", lahjojen jakaminen on mahdollista" +
                       ", mutta metodisi palauttaa 'false'.", tulos == uusi);
        } else {
            assertTrue("Kun henkilöitä on " + n + " ja ystävyydet ovat " + sisalto +
                       ", lahjojen jakaminen ei ole mahdollista" +
                       ", mutta metodisi palauttaa 'true'.", tulos == uusi);
        }
    }
    
    public void suuriTesti(int n, int[] mista, int[] minne, boolean tulos) {
        boolean uusi = Main.lahjajako(n, mista, minne);
        assertTrue("Metodisi toimii väärin suurella syötteellä.", tulos == uusi);
    }
    
    @Test(timeout=1000)
    public void esimerkit() {
        pieniTesti(4, new int[] {1, 2, 3}, new int[] {2, 3, 4}, true);
        pieniTesti(4, new int[] {1, 1, 1}, new int[] {2, 3, 4}, true);
        pieniTesti(3, new int[] {1, 2, 3}, new int[] {2, 3, 1}, false);
        pieniTesti(4, new int[] {1, 2, 3}, new int[] {2, 3, 1}, false);
    }

    @Test(timeout=1000)
    public void pienet() {
        pieniTesti(1, new int[] {}, new int[] {}, true);

        pieniTesti(2, new int[] {}, new int[] {}, true);
        pieniTesti(2, new int[] {1}, new int[] {2}, true);

        pieniTesti(3, new int[] {}, new int[] {}, true);
        pieniTesti(3, new int[] {1}, new int[] {2}, true);
        pieniTesti(3, new int[] {1, 2}, new int[] {2, 3}, true);
        pieniTesti(3, new int[] {1, 1}, new int[] {2, 3}, true);
        pieniTesti(3, new int[] {1, 3, 2}, new int[] {3, 2, 1}, false);
        
        pieniTesti(4, new int[] {4, 4, 4}, new int[] {1, 2, 3}, true);
        pieniTesti(4, new int[] {1, 2, 3, 4}, new int[] {2, 3, 4, 1}, true);
        pieniTesti(4, new int[] {1, 2, 3, 4}, new int[] {3, 4, 2, 1}, true);

        pieniTesti(5, new int[] {1, 2, 3, 4}, new int[] {2, 3, 4, 5}, true);
        pieniTesti(5, new int[] {1, 2, 3, 4}, new int[] {2, 3, 4, 1}, true);
        pieniTesti(5, new int[] {1, 1, 1, 1}, new int[] {2, 3, 4, 5}, true);
        pieniTesti(5, new int[] {1, 2, 3, 4, 5}, new int[] {2, 3, 4, 5, 1}, false);
    }
    
    @Test(timeout=1000)
    public void suuri1() {
        int n = 100000;
        int[] mista = new int[n];
        int[] mihin = new int[n];
        for (int i = 0; i < n; i++) {
            mista[i] = i+1;
            mihin[i] = i+2;
        }
        mihin[n-1] = 1;
        suuriTesti(n, mista, mihin, true);
    }    
    
    @Test(timeout=1000)
    public void suuri2() {
        int n = 99999;
        int[] mista = new int[n];
        int[] mihin = new int[n];
        for (int i = 0; i < n; i++) {
            mista[i] = i+1;
            mihin[i] = i+2;
        }
        mihin[n-1] = 1;
        suuriTesti(n, mista, mihin, false);
    }    
    
    @Test(timeout=1000)
    public void suuri3() {
        int n = 100000;
        int[] mista = new int[n-1];
        int[] mihin = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            mista[i] = 1;
            mihin[i] = i+2;
        }
        suuriTesti(n, mista, mihin, true);
    }    
    
    @Test(timeout=1000)
    public void suuri4() {
        int n = 444;
        int[] mista = new int[n*(n-1)/2];
        int[] minne = new int[n*(n-1)/2];
        int c = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                mista[c] = i;
                minne[c] = j;
                c++;
            }
        }
        suuriTesti(n, mista, minne, false);
    }    
    
    
    
    
}
