import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("6.1")
public class MainTest {
    public void pieniTesti(Kokoelma k, int[] lehdet, int tulos) {
        int uusi = k.eriNumerot();
        String sisalto = Arrays.toString(lehdet);
        assertTrue("Lehtien " + sisalto + " lisäyksen jälkeen eri numeroita " +
                   "tulisi olla " + tulos + ", mutta metodisi antaa " + uusi + ".",
                   tulos == uusi);
    }
    
    public void suuriTesti(Kokoelma k, int tulos) {
        int uusi = k.eriNumerot();
        assertTrue("Metodisi toimii väärin suurella syötteellä.",
                   tulos == uusi);
    }    
    
    @Test(timeout=1000)
    public void esimerkki() {
        Kokoelma k = new Kokoelma();
        k.lisaaLehti(3);
        k.lisaaLehti(4);
        k.lisaaLehti(3);
        pieniTesti(k, new int[] {3, 4, 3}, 2);
        k.lisaaLehti(5);
        pieniTesti(k, new int[] {3, 4, 3, 5}, 3);
        k.lisaaLehti(3);
        pieniTesti(k, new int[] {3, 4, 3, 5, 3}, 3);
    }
    
    @Test(timeout=1000)
    public void pieni1() {
        Kokoelma k = new Kokoelma();
        k.lisaaLehti(1);
        pieniTesti(k, new int[] {1}, 1);
        k.lisaaLehti(1);
        pieniTesti(k, new int[] {1, 1}, 1);
        k.lisaaLehti(1);
        pieniTesti(k, new int[] {1, 1, 1}, 1);
        k.lisaaLehti(1);
        pieniTesti(k, new int[] {1, 1, 1, 1}, 1);
        k.lisaaLehti(1);
        pieniTesti(k, new int[] {1, 1, 1, 1, 1}, 1);
    }    
    
    @Test(timeout=1000)
    public void pieni2() {
        Kokoelma k = new Kokoelma();
        k.lisaaLehti(1);
        pieniTesti(k, new int[] {1}, 1);
        k.lisaaLehti(2);
        pieniTesti(k, new int[] {1, 2}, 2);
        k.lisaaLehti(3);
        pieniTesti(k, new int[] {1, 2, 3}, 3);
        k.lisaaLehti(4);
        pieniTesti(k, new int[] {1, 2, 3, 4}, 4);
        k.lisaaLehti(5);
        pieniTesti(k, new int[] {1, 2, 3, 4, 5}, 5);
    }      

    @Test(timeout=1000)
    public void pieni3() {
        Kokoelma k = new Kokoelma();
        k.lisaaLehti(1);
        pieniTesti(k, new int[] {1}, 1);
        k.lisaaLehti(2);
        pieniTesti(k, new int[] {1, 2}, 2);
        k.lisaaLehti(1);
        pieniTesti(k, new int[] {1, 2, 1}, 2);
        k.lisaaLehti(2);
        pieniTesti(k, new int[] {1, 2, 1, 2}, 2);
        k.lisaaLehti(1);
        pieniTesti(k, new int[] {1, 2, 1, 2, 1}, 2);
    }      
    
    @Test(timeout=1000)
    public void pieni4() {
        Kokoelma k = new Kokoelma();
        k.lisaaLehti(999999999);
        pieniTesti(k, new int[] {999999999}, 1);
        k.lisaaLehti(999999998);
        pieniTesti(k, new int[] {999999999, 999999998}, 2);
        k.lisaaLehti(999999999);
        pieniTesti(k, new int[] {999999999, 999999998, 999999999}, 2);
    }
    
    @Test(timeout=1000)
    public void suuri1() {
        Kokoelma k = new Kokoelma();
        for (int i = 1; i <= 50000; i++) {
            k.lisaaLehti(1);
            suuriTesti(k, 1);
        }
    }    
    
    @Test(timeout=1000)
    public void suuri2() {
        Kokoelma k = new Kokoelma();
        for (int i = 1; i <= 50000; i++) {
            k.lisaaLehti(i);
            suuriTesti(k, i);
        }
    }     
    
    @Test(timeout=1000)
    public void suuri3() {
        Kokoelma k = new Kokoelma();
        for (int i = 1; i <= 25000; i++) {
            k.lisaaLehti(i);
            suuriTesti(k, 2*i-1);
            k.lisaaLehti(1000000000-i);
            suuriTesti(k, 2*i);
        }
    }       
    
    @Test(timeout=1000)
    public void suuri4() {
        Kokoelma k = new Kokoelma();
        long x = 12345;
        long a = 798732191;
        long b = 921339221;
        for (int i = 1; i <= 50000; i++) {
            x = (x*a)%b;            
            k.lisaaLehti((int)x);
            suuriTesti(k, i);
        }
    }       
    
}
