import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("12.5")
public class MainTest {
    private String teeKuvaus(int[][] data, int k) {
        String kuvaus = "";
        for (int i = 0; i <= k; i++) {
            if (kuvaus.equals("")) kuvaus = data[i][0] + "-" + data[i][1];
            else kuvaus += ", " + data[i][0] + "-" + data[i][1];
        }
        return "[" + kuvaus + "]";
    }
    
    public void pieniTesti(int n, String kuvaus, Ystavat y, boolean tulos) {
        boolean uusi = y.lahjajako();
        if (tulos) {
            assertTrue("Kun henkilöitä on " + n + " ja ystävyydet ovat " + kuvaus +
                   ", lahjojen jakaminen on mahdollista" +
                   ", mutta metodisi palauttaa 'false'.", tulos == uusi);
        } else {
            assertTrue("Kun henkilöitä on " + n + " ja ystävyydet ovat " + kuvaus +
                   ", lahjojen jakaminen ei ole mahdollista" +
                   ", mutta metodisi palauttaa 'true'.", tulos == uusi);            
        }
    }
    
    public void suuriTesti(Ystavat y, boolean tulos) {
        boolean uusi = y.lahjajako();
        assertTrue("Metodisi toimii väärin suurella syötteellä.", tulos == uusi);
    }
    
    @Test(timeout=1000)
    public void esimerkki() {
        int n = 3;
        int[][] data = {{1,2},{2,3},{1,3}};
        boolean[] tulos = {true,true,false};
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, true);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            String kuvaus = teeKuvaus(data, i);
            pieniTesti(n, kuvaus, y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void pieni1() {
        int n = 4;
        int[][] data = {{1,2},{2,3},{1,3}};
        boolean[] tulos = {true,true,false};
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, true);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            String kuvaus = teeKuvaus(data, i);
            pieniTesti(n, kuvaus, y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void pieni2() {
        int n = 4;
        int[][] data = {{1,2},{2,3},{3,4},{4,1}};
        boolean[] tulos = {true,true,true,true};
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, true);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            String kuvaus = teeKuvaus(data, i);
            pieniTesti(n, kuvaus, y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void pieni3() {
        int n = 5;
        int[][] data = {{1,2},{2,3},{3,4},{4,5},{5,1}};
        boolean[] tulos = {true,true,true,true,false};
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, true);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            String kuvaus = teeKuvaus(data, i);
            pieniTesti(n, kuvaus, y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void pieni4() {
        int n = 8;
        int[][] data = {{1,2},{3,4},{5,6},{7,8},{2,3},{6,7},{4,5}};
        boolean[] tulos = {true,true,true,true,true,true,true};
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, true);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            String kuvaus = teeKuvaus(data, i);
            pieniTesti(n, kuvaus, y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void pieni5() {
        int n = 8;
        int[][] data = {{1,2},{3,4},{5,6},{7,8},{2,3},{6,7},{4,5},{2,4}};
        boolean[] tulos = {true,true,true,true,true,true,true,false};
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, true);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            String kuvaus = teeKuvaus(data, i);
            pieniTesti(n, kuvaus, y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void suuri1() {
        int n = 100000;
        int[][] data = new int[n][2];
        boolean[] tulos = new boolean[n];
        for (int i = 0; i < n; i++) {
            data[i][0] = i+1;
            data[i][1] = i+2;
            tulos[i] = true;
        }
        data[n-1][1] = 1;
        
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, true);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            suuriTesti(y, tulos[i]);
        }
    }        
    
    @Test(timeout=1000)
    public void suuri2() {
        int n = 99999;
        int[][] data = new int[n][2];
        boolean[] tulos = new boolean[n];
        for (int i = 0; i < n; i++) {
            data[i][0] = i+1;
            data[i][1] = i+2;
            tulos[i] = true;
        }
        data[n-1][1] = 1;
        tulos[n-1] = false;
        
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, true);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            suuriTesti(y, tulos[i]);
        }
    }        
    
    @Test(timeout=1000)
    public void suuri3() {
        int n = 444;
        int[][] data = new int[n*(n-1)/2][2];
        int c = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                data[c][0] = i;
                data[c][1] = j;
                c++;
            }
        }
        long x = 12345;
        long a = 798732191;
        long b = 921339221;         
        int q = 100000;
        for (int i = 0; i < q; i++) {
            x = (x*a)%b;
            int i1 = (int)(x%data.length);
            x = (x*a)%b;
            int i2 = (int)(x%data.length);
            int t1 = data[i1][0];
            int t2 = data[i1][1];
            data[i1][0] = data[i2][0];
            data[i1][1] = data[i2][1];
            data[i2][0] = t1;
            data[i2][1] = t2;
        }

        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, true);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            suuriTesti(y, i <= 204);
        }
    }        
    
    @Test(timeout=1000)
    public void suuri4() {
        int n = 444;
        int[][] data = new int[n*(n-1)/2][2];
        int c = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                data[c][0] = i;
                data[c][1] = j;
                c++;
            }
        }
        long x = 54321;
        long a = 798732191;
        long b = 921339221;         
        int q = 100000;
        for (int i = 0; i < q; i++) {
            x = (x*a)%b;
            int i1 = (int)(x%data.length);
            x = (x*a)%b;
            int i2 = (int)(x%data.length);
            int t1 = data[i1][0];
            int t2 = data[i1][1];
            data[i1][0] = data[i2][0];
            data[i1][1] = data[i2][1];
            data[i2][0] = t1;
            data[i2][1] = t2;
        }

        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, true);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            suuriTesti(y, i <= 183);
        }
    }        
}
