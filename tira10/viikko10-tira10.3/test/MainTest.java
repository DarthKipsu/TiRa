import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("10.3")
public class MainTest {
    public void testi(int[][] kartta, int tulos) {
        int uusi = Main.lyhinReitti(kartta);
        assertTrue("Metodisi antaa lyhimmäksi reitiksi " + uusi +
                   ", vaikka oikea tulos on " + tulos + ".", uusi == tulos);
    }
    
    @Test(timeout=1000)
    public void esimerkki() {
        int[][] kartta = {{1,1,1,1,1,1,1,1},
                          {1,0,3,1,0,0,0,1},
                          {1,0,1,1,0,1,0,1},
                          {1,0,0,0,0,2,0,1},
                          {1,1,1,1,1,1,1,1}};
        testi(kartta, 7);
    }
    
    @Test(timeout=1000)
    public void pieni1() {
        int[][] kartta = {{1,1,1,1},
                          {1,2,0,1},
                          {1,3,0,1},
                          {1,1,1,1}};
        testi(kartta, 1);
    }
    
    @Test(timeout=1000)
    public void pieni2() {
        int[][] kartta = {{1,1,1,1},
                          {1,2,0,1},
                          {1,0,3,1},
                          {1,1,1,1}};
        testi(kartta, 2);
    }

    @Test(timeout=1000)
    public void pieni3() {
        int[][] kartta = {{1,1,1,1,1,1},
                          {1,2,1,1,3,1},
                          {1,0,0,0,0,1},
                          {1,1,1,1,1,1}};
        testi(kartta, 5);
    }
    
    @Test(timeout=1000)
    public void pieni4() {
        int[][] kartta = {{1,1,1,1,1,1},
                          {1,0,0,0,0,1},
                          {1,0,1,1,2,1},
                          {1,3,0,0,0,1},
                          {1,1,1,1,1,1}};
        testi(kartta, 4);
    }
    
    @Test(timeout=1000)
    public void pieni5() {
        int[][] kartta = {{1,1,1,1,1,1,1},
                          {1,0,0,0,1,3,1},
                          {1,0,1,0,1,0,1},
                          {1,2,1,0,0,0,1},
                          {1,1,1,1,1,1,1}};
        testi(kartta, 10);
    }
    
    @Test(timeout=1000)
    public void pieni6() {
        int[][] kartta = {{1,1,1,1},
                          {1,2,1,1},
                          {1,1,3,1},
                          {1,1,1,1}};
        testi(kartta, -1);
    }
    
    
    @Test(timeout=1000)
    public void suuri1() {
        int n = 100;
        int[][] kartta = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) kartta[i][j] = 1;
                if (i == n-1 || j == n-1) kartta[i][j] = 1;
            }
        }
        kartta[1][1] = 2;
        kartta[n-2][n-2] = 3;
        testi(kartta, 2*(n-3));
    }
    
    @Test(timeout=1000)
    public void suuri2() {
        int n = 100;
        int[][] kartta = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                kartta[i][j] = 1;
            }
        }
        kartta[1][1] = 2;
        kartta[n-2][n-2] = 3;
        testi(kartta, -1);
    }

    @Test(timeout=1000)
    public void suuri3() {
        int n = 99;
        int[][] kartta = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) kartta[i][j] = 1;
                if (i == n-1 || j == n-1) kartta[i][j] = 1;
                if (i%4 == 2 && j != n-2) kartta[i][j] = 1;
                if (i%4 == 0 && j != 1) kartta[i][j] = 1;
            }
        }
        kartta[1][1] = 2;
        kartta[n-2][n-2] = 3;
        testi(kartta, (n/2)*(n-2)+(n-2)/2-1);
    }
    
    
    
    
    
}
