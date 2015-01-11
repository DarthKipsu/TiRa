import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("5.1")
public class MainTest {
    public void pieniTesti(Puu puu, int arvo, int tulos) {
        int uusi = Main.laskeArvot(puu, arvo);
        assertTrue("Puussa " + puu +  " arvo " + arvo + " esiintyy " +
                   tulos + " kertaa, mutta metodisi antaa " + uusi + ".",
                   tulos == uusi);
    }

    public void suuriTesti(Puu puu, int arvo, int tulos) {
        int uusi = Main.laskeArvot(puu, arvo);
        assertTrue("Metodisi toimii väärin suurella syötteellä.",
                   tulos == uusi);
    }
    
    
    @Test(timeout=1000)
    public void esimerkki() {
        Puu puu = new Puu(1,
                          new Puu(3,
                                  new Puu(2, null, null),
                                  null),
                          new Puu(3,
                                  new Puu(3, null, null),
                                  new Puu(2, null, null)));

        pieniTesti(puu, 1, 1);
        pieniTesti(puu, 2, 2);
        pieniTesti(puu, 3, 3);
    }
    
    @Test(timeout=1000)
    public void pieni1() {
        Puu puu = new Puu(1, null, null);

        pieniTesti(puu, 1, 1);
        pieniTesti(puu, 2, 0);
        pieniTesti(puu, 3, 0);
    }    
    
    @Test(timeout=1000)
    public void pieni2() {
        Puu puu = new Puu(1,
                          new Puu(2, null, null),
                          new Puu(3, null, null));

        pieniTesti(puu, 1, 1);
        pieniTesti(puu, 2, 1);
        pieniTesti(puu, 3, 1);
    } 
    
    @Test(timeout=1000)
    public void pieni3() {
        Puu puu = new Puu(3,
                          new Puu(2,
                                  new Puu(1, null, null),
                                  new Puu(1, null, null)),
                          new Puu(2,
                                  new Puu(1, null, null),
                                  new Puu(1, null, null)));

        pieniTesti(puu, 1, 4);
        pieniTesti(puu, 2, 2);
        pieniTesti(puu, 3, 1);
    }
    
    @Test(timeout=1000)
    public void pieni4() {
        Puu puu = new Puu(4,
                          new Puu(3,
                                  new Puu(2,
                                          new Puu(1, null, null),
                                          null),
                                  null),
                          new Puu(3,
                                  null,
                                  new Puu(2,
                                          null,
                                          new Puu(1, null, null))));

        pieniTesti(puu, 1, 2);
        pieniTesti(puu, 2, 2);
        pieniTesti(puu, 3, 2);
        pieniTesti(puu, 4, 1);
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
        suuriTesti(puu, 1, n);
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
        suuriTesti(puu, 1, n);
    }

    @Test(timeout=1000)
    public void suuri3() {
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
        suuriTesti(puu, 1, n);
    }
    
    @Test(timeout=1000)
    public void suuri4() {
        int n = 100000;
        ArrayList<Puu> puut = new ArrayList<Puu>();
        Puu puu = new Puu(1, null, null);
        puut.add(puu);
        for (int i = 0; i < n-1; i++) {
            Puu uusi = new Puu(1, null, null);
            while (true) {
                int k = (int)(Math.random()*puut.size());
                double x = Math.random();
                if (x <= 0.5 && puut.get(k).vasen == null) {
                    puut.get(k).vasen = uusi;
                } else if (x > 0.5 && puut.get(k).oikea == null) {
                    puut.get(k).oikea = uusi;                
                } else {
                    continue;
                }
                break;
            }
            puut.add(uusi);
        }
        suuriTesti(puu, 1, n);
    }    
}
