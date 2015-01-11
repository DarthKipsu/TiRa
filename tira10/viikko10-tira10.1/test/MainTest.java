import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("10.1")
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
        boolean uusi = Main.yhteys(n, mista, minne);
        if (tulos) {
            assertTrue("Kun kaupunkeja on " + n + " ja tiet ovat " + sisalto +
                       ", kaupungista 1 pääsee kaupunkiin " + n +
                       ", mutta metodisi palauttaa 'false'.", tulos == uusi);
        } else {
            assertTrue("Kun kaupunkeja on " + n + " ja tiet ovat " + sisalto +
                       ", kaupungista 1 ei pääse kaupunkiin " + n +
                       ", mutta metodisi palauttaa 'true'.", tulos == uusi);
        }
    }
    
    public void suuriTesti(int n, int[] mista, int[] minne, boolean tulos) {
        boolean uusi = Main.yhteys(n, mista, minne);
        assertTrue("Metodisi toimii väärin suurella syötteellä.", tulos == uusi);
    }
    
    @Test(timeout=1000)
    public void esimerkit() {
        pieniTesti(3, new int[] {1, 2}, new int[] {2, 3}, true);
        pieniTesti(4, new int[] {1, 2}, new int[] {2, 3}, false);
        pieniTesti(4, new int[] {1, 2}, new int[] {3, 4}, false);
        pieniTesti(4, new int[] {1, 2}, new int[] {4, 3}, true);
    }
    
    @Test(timeout=1000)
    public void pienet() {
        pieniTesti(2, new int[] {}, new int[] {}, false);
        pieniTesti(2, new int[] {1}, new int[] {2}, true);
        
        pieniTesti(3, new int[] {}, new int[] {}, false);
        pieniTesti(3, new int[] {1}, new int[] {2}, false);
        pieniTesti(3, new int[] {2}, new int[] {1}, false);
        pieniTesti(3, new int[] {1}, new int[] {3}, true);
        pieniTesti(3, new int[] {3}, new int[] {1}, true);
        pieniTesti(3, new int[] {1, 2}, new int[] {2, 3}, true);
        pieniTesti(3, new int[] {1, 2}, new int[] {3, 3}, true);
        
        pieniTesti(4, new int[] {}, new int[] {}, false);
        pieniTesti(4, new int[] {1}, new int[] {4}, true);
        pieniTesti(4, new int[] {2}, new int[] {4}, false);
        pieniTesti(4, new int[] {3}, new int[] {4}, false);
        pieniTesti(4, new int[] {1, 1}, new int[] {2, 3}, false);
        pieniTesti(4, new int[] {2, 2}, new int[] {3, 4}, false);
        pieniTesti(4, new int[] {1, 2}, new int[] {2, 4}, true);
        pieniTesti(4, new int[] {1, 2}, new int[] {4, 4}, true);
        pieniTesti(4, new int[] {1, 2, 3}, new int[] {2, 3, 4}, true);
        pieniTesti(4, new int[] {1, 2, 3}, new int[] {4, 1, 1}, true);
        pieniTesti(4, new int[] {1, 2, 4}, new int[] {3, 1, 3}, true);
        pieniTesti(4, new int[] {1, 2, 3}, new int[] {2, 3, 1}, false);

        pieniTesti(100000, new int[] {}, new int[] {}, false);
        pieniTesti(100000, new int[] {1}, new int[] {100000}, true);
        pieniTesti(100000, new int[] {1, 50000}, new int[] {50000, 100000}, true);
    }
    
    @Test(timeout=1000)
    public void suuri1() {    
        int n = 100000;
        int[] mista = new int[n-1];
        int[] minne = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            mista[i] = i+1;
            minne[i] = i+2;
        }
        suuriTesti(n, mista, minne, true);
    }
    
    @Test(timeout=1000)
    public void suuri2() {
        int n = 100000;
        int[] mista = new int[n-1];
        int[] minne = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            mista[i] = i+1;
            minne[i] = i+2;
            if (i == 12345) minne[i] = 1;
        }
        suuriTesti(n, mista, minne, false);
    }
    
    @Test(timeout=1000)
    public void suuri3() {
        int n = 100000;
        int[] mista = new int[n-1];
        int[] minne = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            mista[i] = 12345;
            minne[i] = i+1;
            if (i == 12345) minne[i] = n;
        }
        suuriTesti(n, mista, minne, true);
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
        suuriTesti(n, mista, minne, true);
    }
    
    
    
}
