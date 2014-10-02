import java.util.*;

public class Main {
    public static int laskeArvot(Puu puu, int arvo) {
		return solmunArvo(puu, arvo, 0);
    }
	
	public static int solmunArvo(Puu puu, int arvo, int yhteensa) {
		if (puu.arvo == arvo) yhteensa++;
		if (puu.vasen != null) yhteensa = solmunArvo(puu.vasen, arvo, yhteensa);
		if (puu.oikea != null) yhteensa = solmunArvo(puu.oikea, arvo, yhteensa);
		return yhteensa;
	}
    
    
    public static void main(String[] args) {        
        Puu puu = new Puu(1,
                          new Puu(3,
                                  new Puu(2, null, null),
                                  null),
                          new Puu(3,
                                  new Puu(3, null, null),
                                  new Puu(2, null, null)));

        System.out.println(laskeArvot(puu, 1));
        System.out.println(laskeArvot(puu, 2));
        System.out.println(laskeArvot(puu, 3));
    }        
}