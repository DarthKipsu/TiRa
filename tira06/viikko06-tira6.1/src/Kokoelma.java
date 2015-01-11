import java.util.*;

public class Kokoelma {
	
	private Set<Integer> kokoelma;

	public Kokoelma() {
		kokoelma = new TreeSet<Integer>();
	}
    
    void lisaaLehti(int luku) {
		kokoelma.add(luku);
    }
    
    int eriNumerot() {
		return kokoelma.size();
    }
}
