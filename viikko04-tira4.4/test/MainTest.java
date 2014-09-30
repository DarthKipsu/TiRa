import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("4.4")
public class MainTest {
    public void pieniTesti(int[] vaunut, boolean tulos) {
        String sisalto = Arrays.toString(vaunut);
        boolean uusi = Main.vaunusiirto(vaunut);
        if (tulos) {
            assertTrue("Vaunut " + sisalto + " on mahdollista siirtää, " +
                       "mutta metodisi palauttaa 'false'.", uusi == tulos);
        } else {
            assertTrue("Vaunuja " + sisalto + " ei ole mahdollista siirtää, " +
                       "mutta metodisi palauttaa 'true'.", uusi == tulos);            
        }
    }

    public void suuriTesti(int[] vaunut, boolean tulos) {
        boolean uusi = Main.vaunusiirto(vaunut);
        assertTrue("Metodi toimii väärin suurella syötteellä.", uusi == tulos);
    }
    
    
    @Test(timeout=1000)
    public void esimerkit() {
        pieniTesti(new int[] {1, 2, 3, 4}, true);
        pieniTesti(new int[] {1, 3, 2, 4}, true);
        pieniTesti(new int[] {4, 1, 2, 3}, true);
        pieniTesti(new int[] {4, 3, 2, 1}, false);
        pieniTesti(new int[] {4, 1, 3, 2}, false);
    }    
    
    @Test(timeout=1000)
    public void pienet() {
        pieniTesti(new int[] {1}, true);

        pieniTesti(new int[] {1, 2}, true);
        pieniTesti(new int[] {2, 1}, true);

        pieniTesti(new int[] {1, 2, 3}, true);
        pieniTesti(new int[] {1, 3, 2}, true);
        pieniTesti(new int[] {2, 1, 3}, true);
        pieniTesti(new int[] {2, 3, 1}, true);
        pieniTesti(new int[] {3, 1, 2}, true);
        pieniTesti(new int[] {3, 2, 1}, false);

        pieniTesti(new int[] {1, 2, 3, 4}, true);
        pieniTesti(new int[] {1, 2, 4, 3}, true);
        pieniTesti(new int[] {1, 3, 2, 4}, true);
        pieniTesti(new int[] {1, 3, 4, 2}, true);
        pieniTesti(new int[] {1, 4, 2, 3}, true);
        pieniTesti(new int[] {1, 4, 3, 2}, false);
        
        pieniTesti(new int[] {2, 1, 3, 4}, true);
        pieniTesti(new int[] {2, 1, 4, 3}, true);
        pieniTesti(new int[] {2, 3, 1, 4}, true);
        pieniTesti(new int[] {2, 3, 4, 1}, true);
        pieniTesti(new int[] {2, 4, 1, 3}, true);
        pieniTesti(new int[] {2, 4, 3, 1}, false);

        pieniTesti(new int[] {3, 1, 2, 4}, true);
        pieniTesti(new int[] {3, 1, 4, 2}, true);
        pieniTesti(new int[] {3, 2, 1, 4}, false);
        pieniTesti(new int[] {3, 2, 4, 1}, false);
        pieniTesti(new int[] {3, 4, 1, 2}, true);
        pieniTesti(new int[] {3, 4, 2, 1}, false);

        pieniTesti(new int[] {4, 1, 2, 3}, true);
        pieniTesti(new int[] {4, 1, 3, 2}, false);
        pieniTesti(new int[] {4, 2, 1, 3}, false);
        pieniTesti(new int[] {4, 2, 3, 1}, false);
        pieniTesti(new int[] {4, 3, 1, 2}, false);
        pieniTesti(new int[] {4, 3, 2, 1}, false);
        
        pieniTesti(new int[] {2, 4, 6, 1, 3, 5}, true);
        pieniTesti(new int[] {6, 1, 2, 3, 4, 5}, true);
        pieniTesti(new int[] {2, 1, 4, 3, 6, 5}, true);
        pieniTesti(new int[] {2, 4, 6, 3, 1, 5}, false);
        pieniTesti(new int[] {6, 2, 1, 3, 4, 5}, false);
        pieniTesti(new int[] {4, 2, 1, 3, 6, 5}, false);
    }        
    
    @Test(timeout=1000)
    public void suuri1() {    
        int n = 100000;
        int[] vaunut = new int[n];
        for (int i = 0; i < n; i++) vaunut[i] = i+1;
        suuriTesti(vaunut, true);
    }

    @Test(timeout=1000)
    public void suuri2() {    
        int n = 100000;
        int[] vaunut = new int[n];
        for (int i = 0; i < n; i++) vaunut[n-i-1] = i+1;
        suuriTesti(vaunut, false);
    }
    
    @Test(timeout=1000)
    public void suuri3() {    
        int n = 100000;
        int[] vaunut = new int[n];
        for (int i = 0; i < n/2; i++) vaunut[i] = 2*i+2;
        for (int i = 0; i < n/2; i++) vaunut[n/2+i] = 2*i+1;
        suuriTesti(vaunut, true);
    }    
    
    @Test(timeout=1000)
    public void suuri4() {    
        int n = 100000;
        int[] vaunut = new int[n];
        for (int i = 0; i < n; i += 2) {
            vaunut[i] = i+2;
            vaunut[i+1] = i+1;
        }
        suuriTesti(vaunut, true);
    }      
    
    @Test(timeout=1000)
    public void suuri5() {    
        int n = 100000;
        int[] vaunut = new int[n];
        for (int i = 0; i < n; i += 2) {
            vaunut[i] = i+2;
            vaunut[i+1] = i+1;
        }
        int t = vaunut[0];
        vaunut[0] = vaunut[n-1];
        vaunut[n-1] = t;
        suuriTesti(vaunut, false);
    }      
    
    @Test(timeout=1000)
    public void bonus() {
        pieniTesti(new int[] {2, 6, 4, 1, 3, 7, 5}, false);
        pieniTesti(new int[] {2, 3, 7, 6, 4, 5, 1}, false);
        pieniTesti(new int[] {1, 7, 6, 4, 2, 3, 5}, false);
        pieniTesti(new int[] {2, 4, 1, 3, 5, 6, 7}, true);
        pieniTesti(new int[] {1, 2, 3, 4, 5, 6, 7}, true);
        pieniTesti(new int[] {7, 2, 5, 4, 1, 3, 6}, false);
        pieniTesti(new int[] {3, 1, 4, 2, 7, 6, 5}, false);
        pieniTesti(new int[] {7, 4, 2, 6, 1, 5, 3}, false);
        pieniTesti(new int[] {4, 5, 7, 1, 6, 3, 2}, false);
        pieniTesti(new int[] {3, 5, 2, 1, 7, 6, 4}, false);
        pieniTesti(new int[] {1, 7, 5, 6, 3, 2, 4}, false);
        pieniTesti(new int[] {2, 3, 1, 4, 5, 6, 7}, true);
        pieniTesti(new int[] {2, 4, 6, 3, 7, 1, 5}, false);
        pieniTesti(new int[] {3, 6, 2, 5, 4, 7, 1}, false);
        pieniTesti(new int[] {1, 2, 7, 3, 5, 6, 4}, false);
        pieniTesti(new int[] {2, 1, 6, 7, 5, 3, 4}, false);
        pieniTesti(new int[] {6, 7, 5, 2, 1, 3, 4}, false);
        pieniTesti(new int[] {2, 6, 7, 5, 4, 1, 3}, false);
        pieniTesti(new int[] {4, 6, 7, 1, 2, 5, 3}, false);
        pieniTesti(new int[] {1, 6, 5, 3, 4, 2, 7}, false);
        pieniTesti(new int[] {6, 7, 3, 2, 4, 1, 5}, false);
        pieniTesti(new int[] {1, 4, 6, 3, 5, 2, 7}, false);
        pieniTesti(new int[] {2, 7, 3, 4, 1, 5, 6}, false);
        pieniTesti(new int[] {2, 6, 4, 5, 1, 7, 3}, false);
        pieniTesti(new int[] {1, 7, 6, 3, 2, 5, 4}, false);
        pieniTesti(new int[] {4, 3, 5, 2, 6, 7, 1}, false);
        pieniTesti(new int[] {6, 7, 2, 1, 5, 3, 4}, false);
        pieniTesti(new int[] {1, 7, 4, 6, 5, 2, 3}, false);
        pieniTesti(new int[] {2, 5, 4, 7, 1, 6, 3}, false);
        pieniTesti(new int[] {4, 7, 6, 5, 3, 2, 1}, false);
        pieniTesti(new int[] {3, 4, 6, 5, 2, 7, 1}, false);
        pieniTesti(new int[] {2, 3, 7, 4, 6, 1, 5}, false);
        pieniTesti(new int[] {3, 4, 1, 2, 7, 5, 6}, true);
        pieniTesti(new int[] {4, 2, 7, 3, 6, 1, 5}, false);
        pieniTesti(new int[] {3, 7, 1, 4, 6, 2, 5}, false);
        pieniTesti(new int[] {6, 4, 7, 5, 1, 3, 2}, false);
        pieniTesti(new int[] {3, 6, 7, 2, 4, 1, 5}, false);
        pieniTesti(new int[] {6, 5, 7, 4, 1, 3, 2}, false);
        pieniTesti(new int[] {5, 7, 2, 3, 4, 1, 6}, false);
        pieniTesti(new int[] {5, 2, 7, 1, 3, 4, 6}, false);
        pieniTesti(new int[] {1, 5, 7, 4, 6, 3, 2}, false);
        pieniTesti(new int[] {5, 7, 3, 4, 2, 6, 1}, false);
        pieniTesti(new int[] {5, 7, 4, 1, 2, 6, 3}, false);
        pieniTesti(new int[] {6, 4, 5, 1, 7, 2, 3}, false);
        pieniTesti(new int[] {2, 1, 6, 4, 3, 7, 5}, false);
        pieniTesti(new int[] {3, 1, 2, 5, 4, 6, 7}, true);
        pieniTesti(new int[] {5, 4, 7, 3, 2, 6, 1}, false);
        pieniTesti(new int[] {6, 3, 2, 7, 5, 4, 1}, false);
        pieniTesti(new int[] {7, 2, 6, 4, 5, 1, 3}, false);
        pieniTesti(new int[] {3, 5, 7, 4, 1, 2, 6}, false);
        pieniTesti(new int[] {6, 5, 1, 4, 3, 7, 2}, false);
        pieniTesti(new int[] {7, 1, 6, 3, 2, 5, 4}, false);
        pieniTesti(new int[] {5, 6, 2, 1, 4, 3, 7}, false);
        pieniTesti(new int[] {5, 4, 3, 2, 6, 7, 1}, false);
        pieniTesti(new int[] {6, 5, 1, 4, 3, 7, 2}, false);
        pieniTesti(new int[] {7, 4, 2, 5, 6, 1, 3}, false);
        pieniTesti(new int[] {6, 5, 3, 1, 2, 4, 7}, false);
        pieniTesti(new int[] {5, 4, 2, 3, 1, 6, 7}, false);
        pieniTesti(new int[] {6, 3, 4, 7, 5, 2, 1}, false);
        pieniTesti(new int[] {5, 7, 4, 1, 2, 6, 3}, false);
        pieniTesti(new int[] {3, 5, 6, 4, 7, 2, 1}, false);
        pieniTesti(new int[] {6, 4, 5, 1, 7, 2, 3}, false);
        pieniTesti(new int[] {5, 6, 1, 7, 2, 4, 3}, false);
        pieniTesti(new int[] {4, 6, 5, 2, 7, 3, 1}, false);
        pieniTesti(new int[] {6, 1, 5, 3, 7, 4, 2}, false);
        pieniTesti(new int[] {2, 6, 4, 5, 1, 3, 7}, false);
        pieniTesti(new int[] {2, 5, 4, 1, 6, 7, 3}, false);
        pieniTesti(new int[] {1, 3, 2, 7, 6, 5, 4}, false);
        pieniTesti(new int[] {5, 4, 6, 1, 7, 2, 3}, false);
        pieniTesti(new int[] {4, 6, 2, 1, 3, 5, 7}, false);
        pieniTesti(new int[] {4, 5, 1, 7, 6, 2, 3}, false);
        pieniTesti(new int[] {4, 3, 5, 1, 2, 7, 6}, false);
        pieniTesti(new int[] {2, 5, 6, 1, 3, 4, 7}, true);
        pieniTesti(new int[] {5, 4, 6, 7, 1, 2, 3}, false);
        pieniTesti(new int[] {4, 2, 3, 6, 5, 7, 1}, false);
        pieniTesti(new int[] {1, 7, 2, 6, 4, 3, 5}, false);
        pieniTesti(new int[] {2, 5, 3, 1, 4, 7, 6}, false);
        pieniTesti(new int[] {5, 7, 6, 4, 2, 3, 1}, false);
        pieniTesti(new int[] {4, 3, 6, 1, 7, 2, 5}, false);
        pieniTesti(new int[] {1, 6, 3, 5, 2, 4, 7}, false);
        pieniTesti(new int[] {2, 1, 7, 4, 6, 5, 3}, false);
        pieniTesti(new int[] {5, 6, 3, 4, 2, 1, 7}, false);
        pieniTesti(new int[] {7, 2, 6, 4, 5, 1, 3}, false);
        pieniTesti(new int[] {2, 3, 4, 1, 5, 6, 7}, true);
        pieniTesti(new int[] {4, 3, 6, 7, 1, 5, 2}, false);
        pieniTesti(new int[] {2, 1, 6, 4, 3, 7, 5}, false);
        pieniTesti(new int[] {1, 3, 7, 5, 4, 6, 2}, false);
        pieniTesti(new int[] {7, 5, 4, 3, 1, 2, 6}, false);
        pieniTesti(new int[] {5, 6, 2, 1, 7, 3, 4}, false);
        pieniTesti(new int[] {3, 5, 1, 2, 4, 7, 6}, true);
        pieniTesti(new int[] {3, 1, 7, 2, 6, 4, 5}, false);
        pieniTesti(new int[] {3, 5, 4, 7, 6, 2, 1}, false);
        pieniTesti(new int[] {6, 2, 3, 7, 1, 4, 5}, false);
        pieniTesti(new int[] {1, 2, 6, 4, 3, 5, 7}, false);
        pieniTesti(new int[] {1, 4, 3, 7, 5, 6, 2}, false);
        pieniTesti(new int[] {4, 5, 7, 2, 3, 1, 6}, false);
        pieniTesti(new int[] {2, 7, 5, 1, 4, 3, 6}, false);
        pieniTesti(new int[] {2, 6, 1, 5, 4, 7, 3}, false);
        pieniTesti(new int[] {1, 7, 2, 5, 3, 6, 4}, false);
        pieniTesti(new int[] {4, 7, 2, 6, 1, 3, 5}, false);        
    }

}
