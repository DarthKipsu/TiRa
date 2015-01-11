import java.util.*;

public class Kokoelma {
	
	private TreeSet<Integer> kokoelma;

	public Kokoelma() {
		kokoelma = new TreeSet<Integer>();
	}
    
    void lisaaLehti(int luku) {
		kokoelma.add(luku);
    }
    
    int valitseLehti(int luku) {
		if (kokoelma.contains(luku)) return luku;
		
		Integer pienempi = kokoelma.lower(luku);
		Integer suurempi = kokoelma.higher(luku);
		
		if (suurempi == null || pienempi != null && luku-pienempi <= suurempi-luku) {
			return pienempi;
		} else {
			return suurempi;
		}
    }
}
