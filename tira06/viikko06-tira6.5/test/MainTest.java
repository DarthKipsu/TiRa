import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("6.5")
public class MainTest {
    public void pieniTesti(String mjono, int[] vaihdot, int tulos) {
        PisinToisto p = new PisinToisto(mjono);
        for (int i = 0; i < vaihdot.length; i++) {
            p.muutaMerkki(vaihdot[i]);
        }
        String sisalto = Arrays.toString(vaihdot);
        int uusi = p.pisinToisto();
        assertTrue("Kun merkkijonoon " + mjono +
                   " tehdään muutokset " + sisalto +
                   ", pisimmän toiston tulisi olla " + tulos + 
                   ", mutta metodisi antaa " + uusi + ".", tulos == uusi);
    }
    
    @Test(timeout=1000)
    public void esimerkki() {
        pieniTesti("AABBBA", new int[] {}, 3);
        pieniTesti("AABBBA", new int[] {3}, 2);
        pieniTesti("AABBBA", new int[] {3, 0}, 1);
        pieniTesti("AABBBA", new int[] {3, 0, 2}, 3);
        pieniTesti("AABBBA", new int[] {3, 0, 2, 4}, 5);
    }
    
    @Test(timeout=1000)
    public void pieni1() {
        pieniTesti("AAAAAA", new int[] {}, 6);
        pieniTesti("AAAAAA", new int[] {0}, 5);
        pieniTesti("AAAAAA", new int[] {0, 1}, 4);
        pieniTesti("AAAAAA", new int[] {0, 1, 2}, 3);
        pieniTesti("AAAAAA", new int[] {0, 1, 2, 3}, 4);
        pieniTesti("AAAAAA", new int[] {0, 1, 2, 3, 4}, 5);
        pieniTesti("AAAAAA", new int[] {0, 1, 2, 3, 4, 5}, 6);
    }   
    
    @Test(timeout=1000)
    public void pieni2() {
        pieniTesti("AAAAAA", new int[] {}, 6);
        pieniTesti("AAAAAA", new int[] {0}, 5);
        pieniTesti("AAAAAA", new int[] {0, 2}, 3);
        pieniTesti("AAAAAA", new int[] {0, 2, 4}, 1);
        pieniTesti("AAAAAA", new int[] {0, 2, 4, 1}, 3);
        pieniTesti("AAAAAA", new int[] {0, 2, 4, 1, 3}, 5);
        pieniTesti("AAAAAA", new int[] {0, 2, 4, 1, 3, 5}, 6);
    } 
    
    @Test(timeout=1000)
    public void pieni3() {
        pieniTesti("ABABABA", new int[] {}, 1);
        pieniTesti("ABABABA", new int[] {0}, 2);
        pieniTesti("ABABABA", new int[] {0, 6}, 2);
        pieniTesti("ABABABA", new int[] {0, 6, 3}, 3);
        pieniTesti("ABABABA", new int[] {0, 6, 3, 0}, 3);
        pieniTesti("ABABABA", new int[] {0, 6, 3, 0, 6}, 3);
        pieniTesti("ABABABA", new int[] {0, 6, 3, 0, 6, 1}, 5);
        pieniTesti("ABABABA", new int[] {0, 6, 3, 0, 6, 1, 5}, 7);
    }   
    
    @Test(timeout=1000)
    public void suuri() {
        int[][] data = {{1, 15}, {1391, 18}, {11156, 19}, {11807, 20},
                        {15027, 15}, {16419, 14}, {18713, 15}, {20690, 14},
                        {23318, 17}, {38515, 16}, {40814, 15}, {46039, 17},
                        {50469, 18}, {58784, 17}, {70118, 19}, {91987, 20}};

        int n = 100000;
        int q = 100000;
        char[] mjono = new char[n];
        long x = 12345;
        long a = 798732191;
        long b = 921339221;     
        for (int i = 0; i < n; i++) {
            x = (x*a)%b;
            if (x%2 == 0) mjono[i] = 'A';
            else mjono[i] = 'B';
        }
        PisinToisto etsija = new PisinToisto(new String(mjono));

        int k = 0;
        for (int i = 0; i < q; i++) {
            while (k+1 < data.length && data[k+1][0] <= i) k++;
            x = (x*a)%b;
            if (x%2 == 0) {
                x = (x*a)%b;
                etsija.muutaMerkki((int)(x%n));
            } else {
                int e = etsija.pisinToisto();
                assertTrue("Metodisi toimii väärin suurella syötteellä.",
                           e == data[k][1]);
            }
        }
    
    }

}
