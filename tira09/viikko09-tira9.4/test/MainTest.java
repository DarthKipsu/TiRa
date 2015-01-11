import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("9.4")
public class MainTest {
    public void pieniTesti(int[] luvut, int tulos) {
        String sisalto = Arrays.toString(luvut);
        int uusi = Main.laskeVaihdot(luvut);
        assertTrue("Taulukossa " + sisalto + " vaihtojen määrän tulisi olla " +
                   tulos + ", mutta metodisi antaa " + uusi + ".",
                   tulos == uusi);
    }
    
    public void suuriTesti(int[] luvut, int tulos) {
        int uusi = Main.laskeVaihdot(luvut);
        assertTrue("Metodisi toimii väärin suurella syötteellä.",
                   tulos == uusi);
    }
    
    @Test(timeout=1000)
    public void esimerkit() {
        pieniTesti(new int[] {1, 1, 1, 2, 2, 3}, 0);
        pieniTesti(new int[] {3, 3, 3, 1, 1, 1}, 3);
        pieniTesti(new int[] {1, 2, 3, 1, 2, 3}, 2);
        pieniTesti(new int[] {1, 1, 1, 1, 1, 1}, 0);
        pieniTesti(new int[] {2, 2, 3, 3, 1, 1}, 4);
    }
    
    @Test(timeout=1000)
    public void pienet() {
        pieniTesti(new int[] {1}, 0);
        pieniTesti(new int[] {1, 1}, 0);
        pieniTesti(new int[] {1, 1, 1}, 0);
        pieniTesti(new int[] {1, 1, 1, 1}, 0);
        pieniTesti(new int[] {1, 1, 1, 1, 1}, 0);

        pieniTesti(new int[] {1, 2}, 0);
        pieniTesti(new int[] {2, 1}, 1);
        pieniTesti(new int[] {1, 3}, 0);
        pieniTesti(new int[] {3, 1}, 1);
        pieniTesti(new int[] {2, 3}, 0);
        pieniTesti(new int[] {3, 2}, 1);

        pieniTesti(new int[] {1, 2, 3}, 0);
        pieniTesti(new int[] {1, 3, 2}, 1);
        pieniTesti(new int[] {2, 1, 3}, 1);
        pieniTesti(new int[] {2, 3, 1}, 2);
        pieniTesti(new int[] {3, 1, 2}, 2);
        pieniTesti(new int[] {3, 2, 1}, 1);
        
        pieniTesti(new int[] {1, 1, 2}, 0);
        pieniTesti(new int[] {1, 2, 1}, 1);
        pieniTesti(new int[] {2, 1, 1}, 1);

        pieniTesti(new int[] {1, 1, 1, 2}, 0);
        pieniTesti(new int[] {1, 1, 2, 1}, 1);
        pieniTesti(new int[] {1, 2, 1, 1}, 1);
        pieniTesti(new int[] {2, 1, 1, 1}, 1);
        pieniTesti(new int[] {1, 1, 2, 2}, 0);
        pieniTesti(new int[] {1, 2, 1, 2}, 1);
        pieniTesti(new int[] {2, 1, 1, 2}, 1);
        pieniTesti(new int[] {2, 1, 2, 1}, 1);
        pieniTesti(new int[] {2, 2, 1, 1}, 2);
        pieniTesti(new int[] {1, 2, 2, 2}, 0);
        pieniTesti(new int[] {2, 1, 2, 2}, 1);
        pieniTesti(new int[] {2, 2, 1, 2}, 1);
        pieniTesti(new int[] {2, 2, 2, 1}, 1);
        
        pieniTesti(new int[] {2, 2, 2, 2}, 0);
        pieniTesti(new int[] {3, 3, 3, 3}, 0);
        pieniTesti(new int[] {2, 2, 3, 3}, 0);
        pieniTesti(new int[] {3, 3, 2, 2}, 2);

        pieniTesti(new int[] {1, 3, 2, 3, 1, 1}, 3);
        pieniTesti(new int[] {3, 3, 3, 1, 3, 1}, 2);
        pieniTesti(new int[] {2, 1, 2, 1, 3, 2}, 2);
        pieniTesti(new int[] {1, 1, 3, 3, 2, 1}, 2);
        pieniTesti(new int[] {3, 1, 3, 2, 2, 1}, 2);
        pieniTesti(new int[] {3, 2, 1, 3, 2, 1}, 3);        
    }
    
    @Test(timeout=1000)
    public void suuri1() {
        int n = 100000;
        int[] luvut = new int[n];
        for (int i = 0; i < n; i++) luvut[i] = 1;
        suuriTesti(luvut, 0);
    }
    
    @Test(timeout=1000)
    public void suuri2() {
        int n = 100000;
        int[] luvut = new int[n];
        for (int i = 0; i < n/3; i++) luvut[i] = 1;
        for (int i = n/3; i < 2*n/3; i++) luvut[i] = 2;
        for (int i = 2*n/3; i < n; i++) luvut[i] = 3;
        suuriTesti(luvut, 0);
    }
    
    @Test(timeout=1000)
    public void suuri3() {
        int n = 100000;
        int[] luvut = new int[n];
        for (int i = 0; i < n; i++) luvut[i] = 1+(i%3);
        suuriTesti(luvut, 33333);
    }

    @Test(timeout=1000)
    public void suuri4() {
        int n = 100000;
        int[] luvut = new int[n];
        long x = 12345;
        long a = 798732191;
        long b = 921339221;                 
        for (int i = 0; i < n; i++) {
            x = (x*a)%b;
            luvut[i] = 1+((int)x%3);
        }
        suuriTesti(luvut, 33455);
    }
    
    @Test(timeout=1000)
    public void suuri5() {
        int n = 100000;
        int[] luvut = new int[n];
        long x = 54321;
        long a = 798732191;
        long b = 921339221;                 
        for (int i = 0; i < n; i++) {
            x = (x*a)%b;
            luvut[i] = 1+((int)x%3);
        }
        suuriTesti(luvut, 33263);
    }
    
    @Test(timeout=1000)
    public void suuri6() {
        int n = 100000;
        int[] luvut = new int[n];
        for (int i = 0; i < n/3; i++) luvut[i] = 3;
        for (int i = n/3; i < 2*n/3; i++) luvut[i] = 1;
        for (int i = 2*n/3; i < n; i++) luvut[i] = 2;
        suuriTesti(luvut, 66666);
    }
}
