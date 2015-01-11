import java.util.*;

public class Main {
    
    public static boolean taydellinen(Puu puu) {
		return polunPituus(puu, 1) > 0;
    }
	
	public static int polunPituus(Puu puu, int pituus) {
		if (puu.oikea == null && puu.vasen == null) {
			return pituus;
		} else if (puu.oikea != null && puu.vasen != null) {
			int oikea = polunPituus(puu.oikea, pituus +1);
			int vasen = polunPituus(puu.vasen, pituus +1);
			if (oikea == vasen) return oikea;
			else return -1;
		} else {
			return -1;
		}
	}
    
    public static void main(String[] args) {
        Puu puu = new Puu(1,
                          new Puu(3,
                                  new Puu(2, null, null),
                                  new Puu(1, null, null)),
                          new Puu(3,
                                  new Puu(3, null, null),
                                  new Puu(2, null, null)));
        Puu puu2 = new Puu(1,
                          new Puu(3,
                                  new Puu(2, null, null),
                                  new Puu(1, null, null)),
                          new Puu(3, null, null));
        System.out.println(taydellinen(puu));
        System.out.println(taydellinen(puu2));
    }        
}