
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Alijono {
	private static class Luku {
		int arvo;

		public Luku(int arvo) {
			this.arvo = arvo;
		}

		public Luku() {
			arvo = 0;
		}

		public void kasvata() {
			arvo++;
		}

		public int vahenna() {
			return --arvo;
		}
	}

	public static void main(String[] args) {
		IO io = new IO();
		String merkit = io.next();
		int pienin = 1;
		Set<Character> esiintyneet = new HashSet();
		for (int i = merkit.length() - 1; i >= 0; i--) {
			char merkki = merkit.charAt(i);
			esiintyneet.add(merkki);
			if (esiintyneet.size() == 26) {
				pienin++;
				esiintyneet = new HashSet<>();
			}
		}
		io.println(pienin);
		io.close();
	}
	
}
