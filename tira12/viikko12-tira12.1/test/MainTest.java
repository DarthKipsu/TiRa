import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("12.1")
public class MainTest {
    private String teeKuvaus(int[][] data, int k) {
        String kuvaus = "";
        for (int i = 0; i <= k; i++) {
            if (kuvaus.equals("")) kuvaus = data[i][0] + "-" + data[i][1];
            else kuvaus += ", " + data[i][0] + "-" + data[i][1];
        }
        return "[" + kuvaus + "]";
    }
    
    public void pieniTesti(int n, String kuvaus, Ystavat y, int tulos) {
        int uusi = y.suurinRyhma();
        assertTrue("Kun henkilöitä on " + n + " ja ystävyydet ovat " + kuvaus +
                   ", suurin ryhmä on " + tulos + ", mutta metodisi antaa " +
                   uusi, tulos == uusi);
    }
    
    public void suuriTesti(Ystavat y, int tulos) {
        int uusi = y.suurinRyhma();
        assertTrue("Metodisi toimii väärin suurella syötteellä.", tulos == uusi);
    }
    
    @Test(timeout=1000)
    public void esimerkki() {
        int n = 4;
        int[][] data = {{1,2},{3,4},{1,4}};
        int[] tulos = {2,2,4};
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, 1);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            String kuvaus = teeKuvaus(data, i);
            pieniTesti(n, kuvaus, y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void pieni1() {
        int n = 4;
        int[][] data = {{1,2},{2,3},{3,4}};
        int[] tulos = {2,3,4};
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, 1);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            String kuvaus = teeKuvaus(data, i);
            pieniTesti(n, kuvaus, y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void pieni2() {
        int n = 8;
        int[][] data = {{1,2},{3,4},{5,6},{7,8},{2,3},{6,7},{3,6}};
        int[] tulos = {2,2,2,2,4,4,8};
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, 1);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            String kuvaus = teeKuvaus(data, i);
            pieniTesti(n, kuvaus, y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void pieni3() {
        int n = 8;
        int[][] data = {{1,2},{3,4},{2,3},{5,6},{7,8},{6,7},{1,8}};
        int[] tulos = {2,2,4,4,4,4,8};
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, 1);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            String kuvaus = teeKuvaus(data, i);
            pieniTesti(n, kuvaus, y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void pieni4() {
        int n = 1000;
        int[][] data = {{100,200},{300,400},{500,600},{700,800}};
        int[] tulos = {2,2,2,2};
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, 1);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            String kuvaus = teeKuvaus(data, i);
            pieniTesti(n, kuvaus, y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void pieni5() {
        int n = 100000;
        int[][] data = {{10000,20000},{30000,40000},{50000,60000},{70000,80000}};
        int[] tulos = {2,2,2,2};
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, 1);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            String kuvaus = teeKuvaus(data, i);
            pieniTesti(n, kuvaus, y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void suuri1() {
        int n = 100000;
        int[][] data = new int[n-1][2];
        int[] tulos = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            data[i][0] = i+1;
            data[i][1] = i+2;
            tulos[i] = i+2;
        }
        
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, 1);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            suuriTesti(y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void suuri2() {
        int n = 100000;
        int[][] data = new int[n-1][2];
        int[] tulos = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            data[i][0] = n-i-1;
            data[i][1] = n-i;
            tulos[i] = i+2;
        }
        
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, 1);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            suuriTesti(y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void suuri3() {
        int n = 100000;
        int[][] data = new int[n-1][2];
        int[] tulos = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            data[i][0] = 1;
            data[i][1] = i+2;
            tulos[i] = i+2;
        }
        
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, 1);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            suuriTesti(y, tulos[i]);
        }
    }    
    
    @Test(timeout=1000)
    public void suuri4() {
        int n = 100000;
        int[][] data = new int[n-1][2];
        int[] tulos = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            data[i][0] = n;
            data[i][1] = i+1;
            tulos[i] = i+2;
        }
        
        Ystavat y = new Ystavat(n);
        pieniTesti(n, "[]", y, 1);
        for (int i = 0; i < data.length; i++) {
            y.lisaaYstavyys(data[i][0], data[i][1]);
            suuriTesti(y, tulos[i]);
        }
    }    
    
    
    
    
    
}
