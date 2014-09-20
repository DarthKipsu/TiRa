
import java.util.*;

public class Main {

	private static Map<Integer, Long> permutaatiot = new HashMap<Integer, Long>();	

    public static long nopanheitot(int x) {
		
		permutaatiot.put(0, (long)1);
		permutaatiot.put(1, (long)1);

		laskePermutaatiot(2, x);

		return permutaatiot.get(x);
    }
	
	private static void laskePermutaatiot(int silmaluku, int haettu) {
		if (permutaatiot.containsKey(silmaluku)) {
			// jätä tämä askel välistä
		} else if (silmaluku <= 6) {
			long permutaatio = 2 * permutaatiot.get(silmaluku - 1);
			permutaatiot.put(silmaluku, permutaatio);
		} else {
			long permutaatio = 2 * permutaatiot.get(silmaluku - 1) - 
				permutaatiot.get(silmaluku - 6 - 1);
			permutaatiot.put(silmaluku, permutaatio);
		}

		if (silmaluku < haettu) {
			laskePermutaatiot(silmaluku + 1, haettu);
		}
	}

    public static long nopanheitot2(int x) {
        long[] tulos = new long[x+1];
        tulos[0] = 1;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i-j >= 0) tulos[i] += tulos[i-j];
            }
        }
        return tulos[x];
    }

	public static void main(String[] args) {
//		System.out.println(nopanheitot(4));
//		System.out.println(nopanheitot(6));
//		System.out.println(nopanheitot(7));
//		System.out.println(nopanheitot(8));
//		System.out.println(nopanheitot(9));
//		System.out.println(nopanheitot(14));
//		System.out.println(nopanheitot(30));
//		System.out.println(nopanheitot(44));
//		System.out.println(nopanheitot(39));
		long start = System.nanoTime();
		long oma = nopanheitot(60);
		long middle = System.nanoTime();
		long antin = nopanheitot2(60);
		long end = System.nanoTime();
		System.out.println("Vastaukset, oma: " + oma + ", antin: " + antin);
		System.out.println("Aikaa kului omalla: " + ((middle - start)/1000000.0) + "ms, "
				+ "antin: " + ((end - middle)/1000000.0) + "ms.");
	}
}
