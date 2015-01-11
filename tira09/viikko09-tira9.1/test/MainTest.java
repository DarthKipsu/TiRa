import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("9.1")
public class MainTest {
    public void pieniTesti(int[] luvut, boolean tulos) {
        String sisalto = Arrays.toString(luvut);
        boolean uusi = Main.yksiPoisto(luvut);
        if (tulos) {
            assertTrue("Taulukossa " + sisalto + " yksi poisto riittää" +
                       ", mutta metodisi palauttaa 'false'.", tulos == uusi);
        } else {
            assertTrue("Taulukossa " + sisalto + " yksi poisto ei riitä" +
                       ", mutta metodisi palauttaa 'true'.", tulos == uusi);           
        }
    }
    
    public void suuriTesti(int[] luvut, boolean tulos) {
        boolean uusi = Main.yksiPoisto(luvut);
        assertTrue("Metodisi toimii väärin suurella syötteellä", tulos == uusi);
    }
    
    @Test(timeout=1000)
    public void esimerkit() {
        pieniTesti(new int[] {1, 2, 3, 4, 5}, true);
        pieniTesti(new int[] {5, 4, 3, 2, 1}, false);
        pieniTesti(new int[] {1, 2, 9, 4, 5}, true);
        pieniTesti(new int[] {9, 2, 3, 4, 5}, true);
        pieniTesti(new int[] {1, 2, 3, 4, 1}, true);
        pieniTesti(new int[] {5, 1, 5, 1, 5}, false);
    }
    
    @Test(timeout=1000)
    public void pienet() {
        pieniTesti(new int[] {1, 2}, true);
        pieniTesti(new int[] {2, 1}, true);
        pieniTesti(new int[] {1, 2, 3}, true);
        pieniTesti(new int[] {1, 3, 2}, true);
        pieniTesti(new int[] {2, 1, 3}, true);
        pieniTesti(new int[] {2, 3, 1}, true);
        pieniTesti(new int[] {3, 1, 2}, true);
        pieniTesti(new int[] {3, 2, 1}, false);
        
        pieniTesti(new int[] {5}, true);
        pieniTesti(new int[] {5, 5}, true);
        pieniTesti(new int[] {5, 5, 5}, true);
        pieniTesti(new int[] {5, 5, 5, 5}, true);
        pieniTesti(new int[] {5, 5, 5, 5, 5}, true);
        
        pieniTesti(new int[] {9, 3, 4, 5}, true);
        pieniTesti(new int[] {7, 8, 9, 3}, true);
        
        pieniTesti(new int[] {999999999}, true);
        pieniTesti(new int[] {999999999, 999999999}, true);
        pieniTesti(new int[] {999999998, 999999999}, true);
        pieniTesti(new int[] {999999999, 999999998}, true);
        pieniTesti(new int[] {999999999, 999999999, 1}, true);
        pieniTesti(new int[] {999999999, 1, 1}, true);
        pieniTesti(new int[] {999999999, 2, 1}, false);
        
        pieniTesti(new int[] {3, 3, 3, 5, 7}, true);
        pieniTesti(new int[] {3, 8, 9, 9, 9}, true);

        pieniTesti(new int[] {2, 1, 6, 7, 9}, true);
        pieniTesti(new int[] {2, 6, 1, 7, 9}, true);
        pieniTesti(new int[] {2, 6, 7, 1, 9}, true);
        pieniTesti(new int[] {2, 6, 7, 9, 1}, true);

        pieniTesti(new int[] {2, 1, 6, 7, 1, 9}, false);
        pieniTesti(new int[] {2, 1, 6, 1, 7, 9}, false);
        pieniTesti(new int[] {2, 1, 1, 6, 7, 9}, true);
        pieniTesti(new int[] {1, 2, 1, 6, 7, 9}, true);
        pieniTesti(new int[] {1, 1, 2, 6, 7, 9}, true);        
    }    
    
    @Test(timeout=1000)
    public void suuri1() {    
        int n = 100000;
        int[] luvut = new int[n];
        for (int i = 0; i < n; i++) luvut[i] = 1;
        suuriTesti(luvut, true);
    }
    
    @Test(timeout=1000)
    public void suuri2() {    
        int n = 100000;
        int[] luvut = new int[n];
        for (int i = 0; i < n; i++) luvut[i] = i+1;
        suuriTesti(luvut, true);
    }

    @Test(timeout=1000)
    public void suuri3() {
        int n = 100000;
        int[] luvut = new int[n];
        for (int i = 0; i < n; i++) luvut[i] = i+1;
        luvut[12345] = 1;
        suuriTesti(luvut, true);
    }

    @Test(timeout=1000)
    public void suuri4() {
        int n = 100000;
        int[] luvut = new int[n];
        for (int i = 0; i < n; i++) luvut[i] = i+1;
        luvut[12345] = 1;
        luvut[54321] = 1;
        suuriTesti(luvut, false);
    }
    
    @Test(timeout=1000)
    public void suuri5() {
        int n = 100000;
        int[] luvut = new int[n];
        for (int i = 0; i < n; i++) luvut[i] = 999999999-i;
        suuriTesti(luvut, false);
    }
    
}
