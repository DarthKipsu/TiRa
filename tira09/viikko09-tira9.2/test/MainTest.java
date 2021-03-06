import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("9.2")
public class MainTest {
    public void pieniTesti(int[] luvut, int tulos) {
        String sisalto = Arrays.toString(luvut);
        int uusi = Main.laskeKaannot(luvut);
        assertTrue("Taulukossa " + sisalto + " pienin kääntöjen määrä on " +
                   tulos + ", mutta metodisi antaa " + uusi + ".",
                   tulos == uusi);
    }
    
    public void suuriTesti(int[] luvut, int tulos) {
        int uusi = Main.laskeKaannot(luvut);
        assertTrue("Metodisi toimii väärin suurella syötteellä.",
                   tulos == uusi);
    }
    
    @Test(timeout=1000)
    public void esimerkit() {
        pieniTesti(new int[] {1, 2, 3, 4, 5}, 0);
        pieniTesti(new int[] {5, 1, 2, 3, 4}, 4);
        pieniTesti(new int[] {5, 4, 3, 2, 1}, 10);
        pieniTesti(new int[] {1, 1, 1, 1, 1}, 0);
        pieniTesti(new int[] {1, 5, 2, 4, 3}, 4);
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

        pieniTesti(new int[] {1, 2, 3}, 0);
        pieniTesti(new int[] {1, 3, 2}, 1);
        pieniTesti(new int[] {2, 1, 3}, 1);
        pieniTesti(new int[] {2, 3, 1}, 2);
        pieniTesti(new int[] {3, 1, 2}, 2);
        pieniTesti(new int[] {3, 2, 1}, 3);
        
        pieniTesti(new int[] {1, 2, 1}, 1);
        pieniTesti(new int[] {1, 2, 1, 2}, 1);
        pieniTesti(new int[] {1, 2, 1, 2, 1}, 3);
        pieniTesti(new int[] {1, 2, 1, 2, 1, 2}, 3);
        pieniTesti(new int[] {1, 2, 1, 2, 1, 2, 1}, 6);
        pieniTesti(new int[] {1, 2, 1, 2, 1, 2, 1, 2}, 6);
        
        pieniTesti(new int[] {5, 1, 1, 2, 3, 1}, 7);
        pieniTesti(new int[] {3, 2, 4, 4, 1, 2}, 8);
        pieniTesti(new int[] {7, 1, 2, 7, 2, 1}, 8);
        pieniTesti(new int[] {7, 5, 5, 5, 2, 1}, 12);        
    }    
    
    @Test(timeout=1000)
    public void suuri1() {
        int n = 1000;
        int[] luvut = new int[n];
        for (int i = 0; i < n; i++) luvut[i] = 1;
        suuriTesti(luvut, 0);
    }

    @Test(timeout=1000)
    public void suuri2() {
        int n = 1000;
        int[] luvut = new int[n];
        for (int i = 0; i < n; i++) luvut[i] = i+1;
        suuriTesti(luvut, 0);
    }

    @Test(timeout=1000)
    public void suuri3() {
        int n = 1000;
        int[] luvut = new int[n];
        for (int i = 0; i < n; i++) luvut[i] = 999999999-i;
        suuriTesti(luvut, n*(n-1)/2);
    }

    @Test(timeout=1000)
    public void suuri4() {
        int n = 1000;
        int[] luvut = new int[n];
        long x = 12345;
        long a = 798732191;
        long b = 921339221;         
        for (int i = 0; i < n; i++) {
            x = (x*a)%b;
            luvut[i] = (int)x;
        }
        suuriTesti(luvut, 245723);
    }

    @Test(timeout=1000)
    public void suuri5() {
        int n = 1000;
        int[] luvut = new int[n];
        long x = 54321;
        long a = 798732191;
        long b = 921339221;         
        for (int i = 0; i < n; i++) {
            x = (x*a)%b;
            luvut[i] = (int)x;
        }
        suuriTesti(luvut, 250384);
    }    
}
