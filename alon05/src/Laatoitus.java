
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Laatoitus {
	
	public static class Laskuri {
		int arvo;

		public Laskuri() {
			this.arvo = 1;
		}

		public int getArvo() {
			return arvo;
		}

		public void incArvo() {
			this.arvo++;
		}

	}

	protected static int leveys;
	protected static int korkeus;
	protected static int riveja;
	protected static Set<Integer> validitRivit;
	protected static List<Integer>[] riviVaihtoehdot;
	protected static long vaihtoehdot;

	public static void main(String[] args) {
		IO io = new IO();
		leveys = io.nextInt();
		korkeus = io.nextInt();
		riveja = (int)Math.pow(2, leveys);
		validitRivit = new HashSet<>();
		riviVaihtoehdot = new ArrayList[riveja];
		vaihtoehdot = 0;
		long alku = System.nanoTime();
		luoRivit(0, 0);
		laskeRivivaihtoehdot();
		long keski = System.nanoTime();
		etsiVaihtoehdot(0, 0);
		long loppu = System.nanoTime();
//		io.println("Rivien luonti: " + ((keski - alku) / 1000.0) + " ms");
//		io.println("vaihtoehtojen luonti: " + ((loppu - keski) / 1000.0) + " ms");
		io.print(vaihtoehdot);
		io.close();
	}

	public static void luoRivit(int rivi, int i) {
		if (i == leveys) validitRivit.add(rivi);
		if (i > leveys) return;
		luoRivit((rivi << 2), i + 2);
		luoRivit(((rivi << 1) | 1), i + 1);
	}

	public static void laskeRivivaihtoehdot() {
		for (int i = 0; i < riveja; i++) {
			riviVaihtoehdot[i] = new ArrayList<>();
			for (int j = 0; j < riveja; j++) {
				if ((i & j) == 0 && validitRivit.contains(i | j)) riviVaihtoehdot[i].add(j);
			}
		}
	}

	public static void etsiVaihtoehdot(int rivi, int n) {
		if (n == korkeus - 1) {
			if (validitRivit.contains(rivi)) vaihtoehdot ++;
			return;
		}
		for (int i = 0; i < riviVaihtoehdot[rivi].size(); i++) {
			etsiVaihtoehdot(riviVaihtoehdot[rivi].get(i), n + 1);
		}
	}

}
