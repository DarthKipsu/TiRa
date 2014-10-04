import java.util.*;
import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("5.2")
public class MainTest {
    public void pieniTesti(Puu puu, boolean tulos) {
        boolean uusi = Main.taydellinen(puu);
        if (tulos) {
            assertTrue("Puu " + puu + " on täydellinen, " +
                       "mutta metodisi palauttaa 'false'", uusi == tulos);
        } else {
            assertTrue("Puu " + puu + " ei ole täydellinen, " +
                       "mutta metodisi palauttaa 'true'", uusi == tulos);            
        }
    }

    public void suuriTesti(Puu puu, boolean tulos) {
        boolean uusi = Main.taydellinen(puu);
        assertTrue("Metodisi toimii väärin suurella syötteellä.", uusi == tulos);
    }
    
    
    @Test(timeout=1000)
    public void esimerkki() {
        Puu puu = new Puu(1,
                          new Puu(3,
                                  new Puu(2, null, null),
                                  new Puu(1, null, null)),
                          new Puu(3,
                                  new Puu(3, null, null),
                                  new Puu(2, null, null)));
        pieniTesti(puu, true);
    }
    
    @Test(timeout=1000)
    public void pieni1() {
        Puu puu = new Puu(1, null, null);

        pieniTesti(puu, true);
    }    
    
    @Test(timeout=1000)
    public void pieni2() {
        Puu puu = new Puu(1,
                          new Puu(2, null, null),
                          new Puu(3, null, null));

        pieniTesti(puu, true);
    } 
    
    @Test(timeout=1000)
    public void pieni3() {
        Puu puu = new Puu(1,
                          new Puu(2, null, null),
                          null);

        pieniTesti(puu, false);
    }        

    @Test(timeout=1000)
    public void pieni4() {
        Puu puu = new Puu(1,
                          new Puu(2,
                                  new Puu(3, null, null),
                                  null),
                          new Puu(2,
                                  null,
                                  new Puu(3, null, null)));

        pieniTesti(puu, false);
    }
    
    @Test(timeout=1000)
    public void pieni5() {
        Puu puu = new Puu(1,
                          new Puu(3,
                                  new Puu(2, null, null),
                                  new Puu(1, null, null)),
                          new Puu(3, null, null));
        pieniTesti(puu, false);
    }
    
    @Test(timeout=1000)
    public void suuri1() {
        int n = 100000;
        Puu puu = new Puu(1, null, null);
        Puu solmu = puu;
        for (int i = 0; i < n-1; i++) {
            Puu uusi = new Puu(1, null, null);
            solmu.vasen = uusi;
            solmu = uusi;
        }
        suuriTesti(puu, false);
    }

    @Test(timeout=1000)
    public void suuri2() {
        int n = 100000;
        Puu puu = new Puu(1, null, null);
        Puu solmu = puu;
        for (int i = 0; i < n-1; i++) {
            Puu uusi = new Puu(1, null, null);
            solmu.oikea = uusi;
            solmu = uusi;
        }
        suuriTesti(puu, false);
    }

    @Test(timeout=1000)
    public void suuri3() {
        int n = (1<<16)-1;
        ArrayList<Puu> puut = new ArrayList<Puu>();
        Puu puu = new Puu(1, null, null);
        puut.add(puu);
        int k = 0;
        for (int i = 0; i < n-1; i++) {
            Puu uusi = new Puu(1, null, null);
            if (puut.get(k).vasen == null) {
                puut.get(k).vasen = uusi;
            } else if (puut.get(k).oikea == null) {
                puut.get(k).oikea = uusi;                
                k++;
            }
            puut.add(uusi);
        }
        suuriTesti(puu, true);
    }
    
    @Test(timeout=1000)
    public void suuri4() {
        int n = 100000;
        ArrayList<Puu> puut = new ArrayList<Puu>();
        Puu puu = new Puu(1, null, null);
        puut.add(puu);
        int k = 0;
        for (int i = 0; i < n-1; i++) {
            Puu uusi = new Puu(1, null, null);
            if (puut.get(k).vasen == null) {
                puut.get(k).vasen = uusi;
            } else if (puut.get(k).oikea == null) {
                puut.get(k).oikea = uusi;                
                k++;
            }
            puut.add(uusi);
        }
        suuriTesti(puu, false);
    }    
}
