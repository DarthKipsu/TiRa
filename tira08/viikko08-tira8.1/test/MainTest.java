import org.junit.Test;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;

@Points("8.1")
public class MainTest {
    public String teeOsa(String osa) {
        if (osa == null) return "asunto vapautuu";
        else return "lisätään " + osa;
    }
    
    public String teeKuvaus(String[] lista, int loppu) {
        if (loppu == 0) return teeOsa(lista[0]);
        String kuvaus = teeOsa(lista[0]);
        for (int i = 1; i <= loppu-1; i++) {
            kuvaus += ", " + teeOsa(lista[i]);
        }
        kuvaus += " ja " + teeOsa(lista[loppu]);
        return kuvaus;
    }
    
    public void pieniTesti(String[] lista, String[] tulos) {
        Toimisto t = new Toimisto();
        int k = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                String uusi = t.annaAsunto();
                String kuvaus = teeKuvaus(lista, i);
                assertTrue("Luokkasi toimii väärin, kun " + kuvaus + ".",
                           tulos[k].equals(uusi));
                k++;
            } else {
                t.lisaaJonoon(lista[i]);
            }
        }
    }
    
    public void suuriTesti(String[] lista, String[] tulos) {
        Toimisto t = new Toimisto();
        int k = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                String uusi = t.annaAsunto();
                assertTrue("Luokkasi toimii väärin suurella syötteellä.",
                           tulos[k].equals(uusi));
                k++;
            } else {
                t.lisaaJonoon(lista[i]);
            }
        }
    }
    
    @Test(timeout=1000)
    public void esimerkki() {
        String[] lista = {"Uolevi", "Maija", null, "Liisa", null, null};
        String[] tulos = {"Maija", "Liisa", "Uolevi"};
        pieniTesti(lista, tulos);
    }
    
    @Test(timeout=1000)
    public void pieni1() {
        String[] lista = {"Uolevi", null, "Maija", null, "Liisa", null};
        String[] tulos = {"Uolevi", "Maija", "Liisa"};
        pieniTesti(lista, tulos);
    }

    @Test(timeout=1000)
    public void pieni2() {
        String[] lista = {"Maija", "Liisa", "Uolevi", null, null, null};
        String[] tulos = {"Liisa", "Maija", "Uolevi"};
        pieniTesti(lista, tulos);
    }

    @Test(timeout=1000)
    public void pieni3() {
        String[] lista = {"Uolevi", "Maija", "Liisa", null, null, null};
        String[] tulos = {"Liisa", "Maija", "Uolevi"};
        pieniTesti(lista, tulos);
    }

    @Test(timeout=1000)
    public void pieni4() {
        String[] lista = {"Uolevi", "Liisa", null, "Maija", "Aapeli", null, null};
        String[] tulos = {"Liisa", "Aapeli", "Maija"};
        pieniTesti(lista, tulos);
    }
    
    @Test(timeout=1000)
    public void pieni5() {
        String[] lista = {"Uolevi", "Uolevi", null, null};
        String[] tulos = {"Uolevi", "Uolevi"};
        pieniTesti(lista, tulos);
    }
        
    @Test(timeout=1000)
    public void suuri1() {
        int n = 100000;
        String[] lista = new String[n];
        for (int i = 0; i < n/2; i++) lista[i] = "Uolevi";
        for (int i = n/2; i < n; i++) lista[i] = null;
        String[] tulos = new String[n/2];
        for (int i = 0; i < n/2; i++) tulos[i] = "Uolevi";
        suuriTesti(lista, tulos);
    }
    
    @Test(timeout=1000)
    public void suuri2() {
        int n = 100000;
        String[] lista = new String[n];
        for (int i = 0; i < n; i++) {
            if (i%2 == 0) lista[i] = "Uolevi";
            else lista[i] = null;
        }
        String[] tulos = new String[n/2];
        for (int i = 0; i < n/2; i++) tulos[i] = "Uolevi";
        suuriTesti(lista, tulos);
    }
    
    @Test(timeout=1000)
    public void suuri3() {
        int n = 100000;
        String[] lista = new String[n];
        String[] nimet = {"Uolevi", "Liisa", "Maija"};
        for (int i = 0; i < n/2; i++) lista[i] = nimet[i%3];
        for (int i = n/2; i < n; i++) lista[i] = null;
        String[] tulos = new String[n/2];
        for (int i = 0; i < n/2; i++) tulos[i] = nimet[i%3];
        Arrays.sort(tulos);
        suuriTesti(lista, tulos);
    }
    
    
}
