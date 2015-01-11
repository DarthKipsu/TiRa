import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("8.5")
public class MainTest {
    public void pieniTesti(Mediaani m, int[] luvut, int tulos) {
        String sisalto = Arrays.toString(luvut);
        int uusi = m.mediaani();
        assertTrue("Lukujen " + sisalto + " mediaanin tulisi olla " + tulos +
                   ", mutta metodisi antaa " + uusi + ".", tulos == uusi);
    }
    
    public void suuriTesti(Mediaani m, int[] luvut, int tulos) {
        int uusi = m.mediaani();
        assertTrue("Metodisi toimii väärin suurella syötteellä.", tulos == uusi);
    }
    
    @Test(timeout=1000)
    public void esimerkki() {
        Mediaani m = new Mediaani();
        m.lisaaLuku(1);
        pieniTesti(m, new int[] {1}, 1);
        m.lisaaLuku(5);
        m.lisaaLuku(4);
        pieniTesti(m, new int[] {1, 5, 4}, 4);
    }
    
    @Test(timeout=1000)
    public void pieni1() {
        Mediaani m = new Mediaani();
        m.lisaaLuku(1);
        pieniTesti(m, new int[] {1}, 1);
        m.lisaaLuku(2);
        pieniTesti(m, new int[] {1, 2}, 1);
        m.lisaaLuku(3);
        pieniTesti(m, new int[] {1, 2, 3}, 2);
        m.lisaaLuku(4);
        pieniTesti(m, new int[] {1, 2, 3, 4}, 2);
        m.lisaaLuku(5);
        pieniTesti(m, new int[] {1, 2, 3, 4, 5}, 3);
        m.lisaaLuku(6);
        pieniTesti(m, new int[] {1, 2, 3, 4, 5, 6}, 3);
        m.lisaaLuku(7);
        pieniTesti(m, new int[] {1, 2, 3, 4, 5, 6, 7}, 4);
    }

    @Test(timeout=1000)
    public void pieni2() {
        Mediaani m = new Mediaani();
        m.lisaaLuku(1);
        pieniTesti(m, new int[] {1}, 1);
        m.lisaaLuku(7);
        pieniTesti(m, new int[] {1, 7}, 1);
        m.lisaaLuku(2);
        pieniTesti(m, new int[] {1, 7, 2}, 2);
        m.lisaaLuku(6);
        pieniTesti(m, new int[] {1, 7, 2, 6}, 2);
        m.lisaaLuku(3);
        pieniTesti(m, new int[] {1, 7, 2, 6, 3}, 3);
        m.lisaaLuku(5);
        pieniTesti(m, new int[] {1, 7, 2, 6, 3, 5}, 3);
        m.lisaaLuku(4);
        pieniTesti(m, new int[] {1, 7, 2, 6, 3, 5, 4}, 4);
    }
    
    @Test(timeout=1000)
    public void pieni3() {
        Mediaani m = new Mediaani();
        m.lisaaLuku(7);
        pieniTesti(m, new int[] {7}, 7);
        m.lisaaLuku(6);
        pieniTesti(m, new int[] {7, 6}, 6);
        m.lisaaLuku(5);
        pieniTesti(m, new int[] {7, 6, 5}, 6);
        m.lisaaLuku(4);
        pieniTesti(m, new int[] {7, 6, 5, 4}, 5);
        m.lisaaLuku(3);
        pieniTesti(m, new int[] {7, 6, 5, 4, 3}, 5);
        m.lisaaLuku(2);
        pieniTesti(m, new int[] {7, 6, 5, 4, 3, 2}, 4);
        m.lisaaLuku(1);
        pieniTesti(m, new int[] {7, 6, 5, 4, 3, 2, 1}, 4);
    }
    
    @Test(timeout=1000)
    public void pieni4() {
        Mediaani m = new Mediaani();
        m.lisaaLuku(1);
        m.lisaaLuku(1);
        m.lisaaLuku(1);
        pieniTesti(m, new int[] {1, 1, 1}, 1);
        m.lisaaLuku(2);
        m.lisaaLuku(2);
        m.lisaaLuku(2);
        pieniTesti(m, new int[] {1, 1, 1, 2, 2, 2}, 1);
        m.lisaaLuku(2);
        pieniTesti(m, new int[] {1, 1, 1, 2, 2, 2, 2}, 2);
    }

    @Test(timeout=1000)
    public void pieni5() {
        Mediaani m = new Mediaani();
        m.lisaaLuku(2);
        m.lisaaLuku(2);
        m.lisaaLuku(2);
        pieniTesti(m, new int[] {2, 2, 2}, 2);
        m.lisaaLuku(1);
        m.lisaaLuku(1);
        m.lisaaLuku(1);
        pieniTesti(m, new int[] {2, 2, 2, 1, 1, 1}, 1);
        m.lisaaLuku(2);
        pieniTesti(m, new int[] {2, 2, 2, 1, 1, 1, 2}, 2);
    }
    
    @Test(timeout=1000)
    public void pieni6() {
        Mediaani m = new Mediaani();
        m.lisaaLuku(999999999);
        pieniTesti(m, new int[] {999999999}, 999999999);
        m.lisaaLuku(1);
        pieniTesti(m, new int[] {999999999, 1}, 1);
        m.lisaaLuku(999999999);
        pieniTesti(m, new int[] {999999999, 1, 999999999}, 999999999);
        m.lisaaLuku(1);
        pieniTesti(m, new int[] {999999999, 1, 999999999, 1}, 1);
    }
    
    @Test(timeout=1000)
    public void suuri1() {
        int n = 50000;
        Mediaani m = new Mediaani();
        for (int i = 0; i < n; i++) {
            m.lisaaLuku(1);
            suuriTesti(m, null, 1);
        }
    }
    
    @Test(timeout=1000)
    public void suuri2() {
        int n = 50000;
        Mediaani m = new Mediaani();
        for (int i = 0; i < n; i++) {
            m.lisaaLuku(i+1);
            suuriTesti(m, null, i/2+1);
        }
    }
    
    @Test(timeout=1000)
    public void suuri3() {
        int n = 50000;
        Mediaani m = new Mediaani();
        for (int i = 0; i < n; i++) {
            m.lisaaLuku(999999999-i);
            suuriTesti(m, null, 999999999-(i+1)/2);
        }
    }
    
    @Test(timeout=1000)
    public void suuri4() {
        int n = 99999;
        long x = 12345;
        long a = 798732191;
        long b = 921339221;        
        int[] luvut = new int[n];
        Mediaani m = new Mediaani();
        for (int i = 0; i < n; i++) {
            x = (x*a)%b;
            m.lisaaLuku((int)x);
            luvut[i] = (int)x;
        }
        Arrays.sort(luvut);
        suuriTesti(m, null, luvut[n/2]);
    }
    
    @Test(timeout=1000)
    public void suuri5() {
        int n = 99999;
        long x = 54321;
        long a = 798732191;
        long b = 921339221;        
        int[] luvut = new int[n];
        Mediaani m = new Mediaani();
        for (int i = 0; i < n; i++) {
            x = (x*a)%b;
            m.lisaaLuku((int)x);
            luvut[i] = (int)x;
        }
        Arrays.sort(luvut);
        suuriTesti(m, null, luvut[n/2]);
    }
    
}
