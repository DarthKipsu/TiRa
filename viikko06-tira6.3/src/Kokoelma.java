import java.util.*;

public class Kokoelma {
	
	private TreeSet<Integer> kokoelma;
	private int pieninPuuttuva;

	public Kokoelma() {
		kokoelma = new TreeSet<Integer>();
		pieninPuuttuva = 1;
	}
    
    void lisaaLehti(int luku) {
		kokoelma.add(luku);
		if (luku == pieninPuuttuva) {
			paivitaPienintaMuuttujaa();
		}
    }

	private void paivitaPienintaMuuttujaa() {
		int seuraava = pieninPuuttuva + 1;
		while (kokoelma.contains(seuraava)) {
			seuraava++;
		}
		pieninPuuttuva = seuraava;
	}
    
    int pieninPuuttuva() {
		return pieninPuuttuva;
    }
}
