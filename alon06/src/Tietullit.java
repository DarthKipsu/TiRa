
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Tietullit {

	private static class Pari implements Comparable<Pari> {
		int tunnus;
		int paino;

		public Pari(int tunnus, int paino) {
			this.tunnus = tunnus;
			this.paino = paino;
		}

		@Override
		public int compareTo(Pari o) {
			return paino - o.paino;
		}
	}

	private static IO io;
	private static List<Pari>[] verkko;
	private static Queue<Pari> keko;
	private static boolean[] lopullinen;
	private static int[] etaisyydet;
	private static int INF;

	public static void main(String[] args) {
		io = new IO();
		INF = 99999999;
		int kauounkiLkm = io.nextInt();
		int tieLkm = io.nextInt();
		luoVerkko(kauounkiLkm, tieLkm);
		laskeEtaisyydet();
		io.print(etaisyydet[kauounkiLkm]);
		io.close();
	}
	
	public static void luoVerkko(int solmut, int yhteyksia) {
		verkko = new ArrayList[solmut + 1];
		lopullinen = new boolean[solmut + 1];
		etaisyydet = new int[solmut + 1];
		keko = new PriorityQueue<>();
		keko.add(new Pari(1, 0));

		for (int i = 1; i <= solmut; i++) verkko[i] = new ArrayList();
		for (int i = 2; i <= solmut; i++) etaisyydet[i] = INF;
		for (int i = 0; i < yhteyksia; i++) {
			int mista = io.nextInt();
			int minne = io.nextInt();
			int paino = io.nextInt();
			verkko[mista].add(new Pari(minne, paino));
			verkko[minne].add(new Pari(mista, paino));
		}

	}

	public static void laskeEtaisyydet() {
		while (!keko.isEmpty()) {
			int etaisyys = keko.peek().paino;
			int tunnus = keko.poll().tunnus;
			if (lopullinen[tunnus]) continue;
			lopullinen[tunnus] = true;
			for (Pari kaari : verkko[tunnus]) {
				if (etaisyys + kaari.paino < etaisyydet[kaari.tunnus]) {
					etaisyydet[kaari.tunnus] = etaisyys + kaari.paino;
					keko.add(new Pari(kaari.tunnus, etaisyys + kaari.paino));
				}
			}
		}
	}

}
