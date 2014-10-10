import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("6.4")
public class MainTest {
    public void pieniTesti(int[] omenat, int raja, int tulos) {
        String sisalto = Arrays.toString(omenat);
        int uusi = Main.korienMaara(omenat, raja);
        assertTrue("Kun omenat ovat " + sisalto + " ja painoraja on " + raja +
                   ", pienin korien määrä on " + tulos + ", mutta metodisi" +
                   " antaa " + uusi + ".", tulos == uusi);
    }
    
    public void suuriTesti(int[] omenat, int raja, int tulos) {
        int uusi = Main.korienMaara(omenat, raja);
        assertTrue("Metodisi toimii väärin suurella syötteellä.", tulos == uusi);
    }

    @Test(timeout=1000)
    public void esimerkit() {
        pieniTesti(new int[] {1, 2, 3, 4, 5}, 5, 3);
        pieniTesti(new int[] {2, 2, 3, 4, 5}, 5, 4);
        pieniTesti(new int[] {1, 1, 1, 1, 1}, 5, 3);
        pieniTesti(new int[] {3, 3, 3, 3, 3}, 5, 5);
        pieniTesti(new int[] {5, 5, 5, 5, 5}, 5, 5);
    }
    
    @Test(timeout=1000)
    public void pienet() {
        pieniTesti(new int[] {1}, 1, 1);
        pieniTesti(new int[] {1}, 2, 1);

        pieniTesti(new int[] {1, 1}, 1, 2);
        pieniTesti(new int[] {1, 1}, 2, 1);
        pieniTesti(new int[] {1, 1}, 3, 1);
        
        pieniTesti(new int[] {1, 2, 1, 2, 1, 2}, 2, 5);
        pieniTesti(new int[] {1, 2, 1, 2, 1, 2}, 3, 3);
        pieniTesti(new int[] {1, 2, 1, 2, 1, 2}, 4, 3);
        
        pieniTesti(new int[] {1, 2, 3, 1, 2, 3}, 3, 4);
        pieniTesti(new int[] {1, 2, 3, 1, 2, 3}, 4, 3);
        pieniTesti(new int[] {1, 2, 3, 1, 2, 3}, 5, 3);
        
        pieniTesti(new int[] {1, 999999998}, 999999998, 2);
        pieniTesti(new int[] {1, 999999998}, 999999999, 1);
        
        pieniTesti(new int[] {3, 1, 6, 2, 2, 7, 8, 3}, 8, 5);
        pieniTesti(new int[] {3, 1, 6, 2, 2, 7, 8, 3}, 9, 4);
        pieniTesti(new int[] {3, 1, 6, 2, 2, 7, 8, 3}, 10, 4);
        
        pieniTesti(new int[] {4, 1, 7, 6, 8, 2, 5, 3}, 8, 5);
        pieniTesti(new int[] {4, 1, 7, 6, 8, 2, 5, 3}, 9, 4);
        pieniTesti(new int[] {4, 1, 7, 6, 8, 2, 5, 3}, 10, 4);       
    }
    
    @Test(timeout=1000)
    public void suuri1() {
        int n = 100000;
        int[] omenat = new int[n];
        for (int i = 0; i < n; i++) omenat[i] = 1;
        suuriTesti(omenat, 1, n);
    }    
    
    @Test(timeout=1000)
    public void suuri2() {
        int n = 100000;
        int[] omenat = new int[n];
        for (int i = 0; i < n; i++) omenat[i] = 1;
        suuriTesti(omenat, 2, n/2);
    }    
    
    @Test(timeout=1000)
    public void suuri3() {
        int n = 100000;
        int[] omenat = new int[n];
        for (int i = 0; i < n; i++) omenat[i] = i+1;
        suuriTesti(omenat, 100000, n/2+1);
    }    
    
    @Test(timeout=1000)
    public void suuri4() {
        int n = 100000;
        int[] omenat = new int[n];
        for (int i = 0; i < n; i++) omenat[i] = i+1;
        suuriTesti(omenat, 100001, n/2);
    }      
    
    @Test(timeout=1000)
    public void suuri5() {
        int n = 100000;
        int[] omenat = new int[n];
        long x = 12345;
        long a = 798732191;
        long b = 921339221;        
        for (int i = 0; i < n; i++) {
            x = (x*a)%b;
            omenat[i] = (int)x;
        }
        suuriTesti(omenat, 921339221, 50230);
    }         
    
}
