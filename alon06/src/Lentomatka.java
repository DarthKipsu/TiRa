
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Lentomatka {
	
	private static class Pari implements Comparable<Pari> {
		int tunnus;
		long paino;
		boolean alennettu;

		public Pari(int tunnus, long paino, boolean alennettu) {
			this.tunnus = tunnus;
			this.paino = paino;
			this.alennettu = alennettu;
		}

		@Override
		public int compareTo(Pari o) {
			if (paino < o.paino) return -1;
			else if (paino > o.paino) return 1;
			return 0;
		}
	}

	private static IO io;
	private static List<Pari>[] verkko;
	private static Queue<Pari> keko;
	private static boolean[][] lopullinen;
	private static long[][] etaisyydet;
	private static long INF;

	public static void main(String[] args) {
		io = new IO();
		INF = Long.MAX_VALUE;
		int kauounkiLkm = io.nextInt();
		int lentoLkm = io.nextInt();
		luoVerkko(kauounkiLkm, lentoLkm);
		laskeEtaisyydet();
		io.print(Math.min(etaisyydet[kauounkiLkm][0], etaisyydet[kauounkiLkm][1]));
		io.close();
	}
	
	public static void luoVerkko(int solmut, int yhteyksia) {
		verkko = new ArrayList[solmut + 1];
		lopullinen = new boolean[solmut + 1][2];
		lopullinen[1][1] = true;
		etaisyydet = new long[solmut + 1][2];
		keko = new PriorityQueue<>();
		keko.add(new Pari(1, 0, false));

		for (int i = 1; i <= solmut; i++) verkko[i] = new ArrayList();
		for (int i = 2; i <= solmut; i++) {
			for (int j = 0; j < 2; j++) {
				etaisyydet[i][j] = INF;
			}
		}
		for (int i = 0; i < yhteyksia; i++) {
			int mista = io.nextInt();
			int minne = io.nextInt();
			int paino = io.nextInt();
			verkko[mista].add(new Pari(minne, paino, false));
		}

	}

	public static void laskeEtaisyydet() {
		while (!keko.isEmpty()) {
			boolean alennettu = keko.peek().alennettu;
			long etaisyys = keko.peek().paino;
			int tunnus = keko.poll().tunnus;
			if (alennettu && lopullinen[tunnus][1] || lopullinen[tunnus][0]) continue;
			if (alennettu) lopullinen[tunnus][1] = true;
			else lopullinen[tunnus][0] = true;
			if (tunnus == lopullinen.length - 1 &&
					(lopullinen[tunnus][0] == lopullinen[tunnus][1])) return;
			for (Pari kaari : verkko[tunnus]) {
				if (alennettu) {
					if (etaisyys + kaari.paino < etaisyydet[kaari.tunnus][1]) {
						etaisyydet[kaari.tunnus][1] = etaisyys + kaari.paino;
						keko.add(new Pari(kaari.tunnus, etaisyys + kaari.paino, true));
					}
				} else {
					if (etaisyys + kaari.paino < etaisyydet[kaari.tunnus][0]) {
						etaisyydet[kaari.tunnus][0] = etaisyys + kaari.paino;
						keko.add(new Pari(kaari.tunnus, etaisyys + kaari.paino, false));
					}
					if (kaari.paino / 2 + etaisyys < etaisyydet[kaari.tunnus][1]) {
						etaisyydet[kaari.tunnus][1] = etaisyys + kaari.paino / 2;
						keko.add(new Pari(kaari.tunnus, etaisyys + kaari.paino / 2, true));
					}
				}
			}
		}
	}

}
