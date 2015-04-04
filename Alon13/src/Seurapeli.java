
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Finds common dividers for a set of numbers and prints the biggest number of
 * shared dividers between them. Gets input of the size of the set as integer,
 * following the numbers in the set. For example:
 * 3
 * 4 6 8
 * Will print out 3 as 2 is the most common divider which will divide all 3 of the
 * numbers in the set.
 */
public class Seurapeli {
	
	private static class Luku {
		int luku;
		public Luku() {
			luku = 1;
		}
		public void kasvata() {
			luku++;
		}
	}
	
	private static IO io;
	private static Map<Integer, Luku> tekijat;

	public static void main(String[] args) {
		io = new IO();
		etsiTekijat(io.nextInt());
		tulostaSuurinLkm();
		io.close();
	}

	private static void etsiTekijat(int kpl) {
		tekijat = new HashMap<>();
		for (int i = 0; i < kpl; i++) {
			jakoTekijoihin(io.nextInt());
		}
	}

	private static void jakoTekijoihin(int luku) {
		Set<Integer> kaytetyt = new HashSet<>();
		for (int i = 2; i*i <= luku; i++) {
			while (luku % i == 0) {
				if (!kaytetyt.contains(i)) {
					if (tekijat.containsKey(i)) tekijat.get(i).kasvata();
					else tekijat.put(i, new Luku());
					kaytetyt.add(i);
				}
				luku /= i;
			}
		}
		if (luku > 1) {
			if (tekijat.containsKey(luku)) tekijat.get(luku).kasvata();
			else tekijat.put(luku, new Luku());
		}
	}

	private static void tulostaSuurinLkm() {
		int suurin = 0;
		for (Luku luku : tekijat.values()) {
			if (luku.luku > suurin) suurin = luku.luku;
		}
		io.println(suurin);
	}
}
