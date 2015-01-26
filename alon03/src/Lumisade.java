
public class Lumisade {
	
	private static long[] lumet;
	private static int n;
	private static IO io;
	
	public static void main(String[] args) {
		io = new IO();
		luoSegmenttipuut();
		n = io.nextInt();
		for (int i = 0; i < n; i++) {
			int tapahtuma = io.nextInt();
			if (tapahtuma == 1) lisaaLunta();
			else lumenMaaraPihalla();
		}
		io.close();
	}

	private static void luoSegmenttipuut() {
		int n = io.nextInt();
		lumet = new long[2 * n + 2];
	}
	
	private static void lisaaLunta() {
		int mista = io.nextInt() + n;
		int minne = io.nextInt() + n;
		long maara = io.nextLong();
		muutaKohta(mista, lumet[mista] + maara);
		if (minne != n + n) muutaKohta(minne + 1, lumet[minne + 1] - maara);
	}
	
	private static void muutaKohta(int kohta, long uusiArvo) {
		lumet[kohta] = uusiArvo;
		kohta /= 2;
		for (; kohta >= 1; kohta /= 2) {
			lumet[kohta] = lumet[2 * kohta] + lumet[2 * kohta + 1];
		}
	}
	
	private static void lumenMaaraPihalla() {
		int alku = n + 1;
		int piha = io.nextInt() + n;
		long lunta = 0;
		while (alku <= piha) {
			if (alku % 2 == 1) lunta += lumet[alku++];
			if (piha % 2 == 0) lunta += lumet[piha--];
			alku /= 2;
			piha /= 2;
		}
		io.println(lunta);
	}
	
}