import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.*;
import org.junit.Before;

@Points("12.3")
public class MainTest {
    private String kaarilista(String[] mista, String[] minne, int[] hinta) {
        String tulos = "";
        for (int i = 0; i < mista.length; i++) {
            if (tulos.equals("")) tulos = mista[i] + "-" + minne[i] + "(" + hinta[i] + ")";
            else tulos += ", "  + mista[i] + "-" + minne[i] + "(" + hinta[i] + ")";
        }
        return "[" + tulos + "]";
    }        
    
    public void pieniTesti(String[] mista, String[] minne, int[] hinta, long tulos) {
        String sisalto = kaarilista(mista, minne, hinta);
        long uusi = Main.kaannokset(mista, minne, hinta);
        assertTrue("Kun kieliparit ovat " + sisalto +
                   ", halvin ratkaisu on " + tulos +
                   ", mutta metodisi antaa " + uusi + ".",
                   tulos == uusi);
    }
    
    public void suuriTesti(String[] mista, String[] minne, int[] hinta, long tulos) {
        long uusi = Main.kaannokset(mista, minne, hinta);
        assertTrue("Metodisi toimii väärin suurella syötteellä.",
                   tulos == uusi);
    }
    
    private ArrayList<String> nimet = new ArrayList<String>();
    
    @Before        
    public void setUp() {
        int n = 100000;
        for (int i = 0; i < n; i++) {
            String nimi = "";
            for (int j = 0; j < 10; j++) {
                nimi += (char)('a'+Math.random()*26);
            }
            nimet.add(nimi);
        }
    }    
    
    @Test(timeout=1000)
    public void esimerkit() {
        pieniTesti(new String[] {"suomi", "ruotsi"}, new String[] {"ruotsi", "englanti"}, new int[] {7, 4}, 11);
        pieniTesti(new String[] {"suomi", "ruotsi"}, new String[] {"saksa", "englanti"}, new int[] {5, 5}, 10);
        pieniTesti(new String[] {"suomi", "ruotsi", "suomi"}, new String[] {"ruotsi", "englanti", "englanti"}, new int[] {7, 4, 5}, 9);
        pieniTesti(new String[] {"suomi", "suomi"}, new String[] {"ruotsi", "ruotsi"}, new int[] {2, 3}, 2);
    }
    
    @Test(timeout=1000)
    public void pienet() {
        pieniTesti(new String[] {"suomi"}, new String[] {"ruotsi"}, new int[] {1}, 1);

        pieniTesti(new String[] {"suomi", "ruotsi"}, new String[] {"ruotsi", "englanti"}, new int[] {1, 1}, 2);
        pieniTesti(new String[] {"suomi", "ruotsi"}, new String[] {"ruotsi", "suomi"}, new int[] {1, 2}, 1);

        pieniTesti(new String[] {"suomi", "ruotsi", "saksa"}, new String[] {"ruotsi", "saksa", "suomi"}, new int[] {1, 2, 3}, 3);
        pieniTesti(new String[] {"suomi", "ruotsi", "saksa"}, new String[] {"ruotsi", "saksa", "englanti"}, new int[] {1, 2, 3}, 6);

        pieniTesti(new String[] {"suomi", "ruotsi", "suomi"}, new String[] {"ruotsi", "suomi", "puola"}, new int[] {1, 1, 99}, 100);
        pieniTesti(new String[] {"suomi", "ruotsi", "suomi"}, new String[] {"ruotsi", "suomi", "puola"}, new int[] {1, 99, 1}, 2);    

        pieniTesti(new String[] {"suomi", "saksa", "ranska"}, new String[] {"ruotsi", "englanti", "puola"}, new int[] {10, 10, 10}, 30);    
        pieniTesti(new String[] {"suomi", "saksa", "ranska"}, new String[] {"ruotsi", "englanti", "puola"}, new int[] {10, 10, 11}, 31);    
    }    
    
    @Test(timeout=1000)
    public void suuri1() {
        int n = 100000;
        String[] mista = new String[n-1];
        String[] minne = new String[n-1];
        int[] hinta = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            mista[i] = nimet.get(0);
            minne[i] = nimet.get(i+1);
            hinta[i] = 1;
        }
        suuriTesti(mista, minne, hinta, n-1);
    }
    
    @Test(timeout=1000)
    public void suuri2() {
        int n = 100000;
        String[] mista = new String[n-1];
        String[] minne = new String[n-1];
        int[] hinta = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            mista[i] = nimet.get(0);
            minne[i] = nimet.get(i+1);
            hinta[i] = 999999999;
        }
        suuriTesti(mista, minne, hinta, (long)(n-1)*999999999);
    }
    
    @Test(timeout=1000)
    public void suuri3() {
        int n = 444;
        String[] mista = new String[n*(n-1)/2];
        String[] minne = new String[n*(n-1)/2];
        int[] hinta = new int[n*(n-1)/2];
        int c = 0;
        long x = 12345;
        long a = 798732191;
        long b = 921339221;         
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                x = (x*a)%b;
                mista[c] = nimet.get(i-1);
                minne[c] = nimet.get(j-1);
                hinta[c] = (int)x;
                c++;
            }
        }
        suuriTesti(mista, minne, hinta, 1208824231);
    }
    
    @Test(timeout=1000)
    public void suuri4() {
        int n = 444;
        String[] mista = new String[n*(n-1)/2];
        String[] minne = new String[n*(n-1)/2];
        int[] hinta = new int[n*(n-1)/2];
        int c = 0;
        long x = 54321;
        long a = 798732191;
        long b = 921339221;         
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                x = (x*a)%b;
                mista[c] = nimet.get(i-1);
                minne[c] = nimet.get(j-1);
                hinta[c] = (int)x;
                c++;
            }
        }
        suuriTesti(mista, minne, hinta, 1138923510);
    }
    
    

}
