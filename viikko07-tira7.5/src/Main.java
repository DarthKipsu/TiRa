import java.util.*;

public class Main {   
    public static int pisinTasainen(String mjono) {
		HashMap<Character, Lukumaara> merkkienMaarat = new HashMap<Character, Lukumaara>();
		merkkienMaarat.put('A', new Lukumaara());
		merkkienMaarat.put('C', new Lukumaara());
		merkkienMaarat.put('G', new Lukumaara());
		merkkienMaarat.put('T', new Lukumaara());
		
		for (int i = 0; i < mjono.length(); i++) {
			merkkienMaarat.get(mjono.charAt(i)).kasvata();
		}
		
		int pisinMahdJono = merkkienMaarat.get('A').arvo();
		int alku = 0;
		for (Lukumaara lukum : merkkienMaarat.values()) {
			if (lukum.arvo() < pisinMahdJono) {
				pisinMahdJono = lukum.arvo();
			}
		}
//		System.out.println("suurin mahd: " + pisinMahdJono * 4);
		
		if (mjono.length() == pisinMahdJono * 4 ||
			pisinMahdJono == 0) return pisinMahdJono * 4;
		
		for (Lukumaara lukum : merkkienMaarat.values()) {
			if (lukum.arvo() != pisinMahdJono) {
				lukum.asetaArvo(pisinMahdJono);
			}
		}
		
		while (pisinMahdJono > 0) {
			for (int i = 0; i < mjono.length(); i++) {
				char merkki = mjono.charAt(i);
				merkkienMaarat.get(merkki).vahenna();
				if (merkkienMaarat.get(merkki).arvo() < 0) {
					while (true) {
						if (alku == mjono.length()) return 0;
						char merkkiAlussa = mjono.charAt(alku);
						alku++;
						merkkienMaarat.get(merkkiAlussa).kasvata();;
						if (merkkiAlussa == merkki) break;
					}
				}

	//			System.out.println("A: " + merkkienMaarat.get('A').arvo());
	//			System.out.println("C: " + merkkienMaarat.get('C').arvo());
	//			System.out.println("G: " + merkkienMaarat.get('G').arvo());
	//			System.out.println("T: " + merkkienMaarat.get('T').arvo());

				int jonoNyt = merkkienMaarat.get('A').arvo();
				if (merkkienMaarat.get('A').arvo() == 0 &&
					merkkienMaarat.get('C').arvo() == 0 &&
					merkkienMaarat.get('G').arvo() == 0 &&
					merkkienMaarat.get('T').arvo() == 0) {
					return pisinMahdJono * 4;
				}
			}
			pisinMahdJono--;
			alku = 0;
		}
		return pisinMahdJono * 4;
    }
    
    public static void main(String[] args) {        
        System.out.println(pisinTasainen("ACGTACGT"));
        System.out.println(pisinTasainen("CAATGTCG"));
        System.out.println(pisinTasainen("TTATCGTT"));
        System.out.println(pisinTasainen("AAAAAAAA"));
        System.out.println(pisinTasainen("ACGCGTTAC"));
    }        
}