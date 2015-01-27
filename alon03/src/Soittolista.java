
public class Soittolista {
	
	private static long[] kappaleet;
	private static int n;
	private static IO io;
	private static int suuttumiset;
	private static long kokoListanKesto;
	
	public static void main(String[] args) {
		io = new IO();
		luoSegmenttipuu();
		int kyselyt = io.nextInt();
		suuttumiset = 0;
		for (int i = 0; i < kyselyt; i++) {
			if (io.nextInt() == 2) vaihdaKappale();
			else tarkistaSuuttuminen();
		}
		io.println(suuttumiset);
		io.close();
	}

	private static void luoSegmenttipuu() {
		n = io.nextInt();
		kappaleet = new long[2 * n + 2];
		for (int i = n + 1; i < n * 2 + 1; i++) {
			long kesto = io.nextLong();
			kokoListanKesto += kesto;
			kappaleet[i] = kesto;
		}
		for (int i = n; i > 0; i--) {
			kappaleet[i] = kappaleet[i * 2] + kappaleet[i * 2 + 1];
		}
	}
	
	private static void vaihdaKappale() {
		int kohta = io.nextInt() + n;
		long kesto = io.nextLong();
		kokoListanKesto += kesto - kappaleet[kohta];
		muutaKohta(kohta, kesto);
	}
	
	private static void muutaKohta(int kohta, long uusiKesto) {
		kappaleet[kohta] = uusiKesto;
		kohta /= 2;
		for (; kohta >= 1; kohta /= 2) {
			kappaleet[kohta] = kappaleet[2 * kohta] + kappaleet[2 * kohta + 1];
		}
	}
	
	private static void tarkistaSuuttuminen() {
		int lahtoI = io.nextInt() + n;
		long kesto = summaIndeksille(lahtoI - 1) + io.nextLong();
		if (kesto > kokoListanKesto) {
			suuttumiset++;
			return;
		} else if (kesto == kokoListanKesto) return;
		int alku = lahtoI;
		int loppu = n * 2;
		while (alku <= loppu) {
			int keski = (alku + loppu) / 2;
			long matkaKeskelle = summaIndeksille(keski);
			if (matkaKeskelle == kesto) return;
			else if (matkaKeskelle > kesto) loppu = keski - 1;
			else alku = keski + 1;
		}
		suuttumiset++;
	}
	
	private static long summaIndeksille(int i) {
		int alku = n + 1;
		long summa = 0;
		while (alku <= i) {
			if (alku % 2 == 1) summa += kappaleet[alku++];
			if (i % 2 == 0) summa += kappaleet[i--];
			alku /= 2;
			i /= 2;
		}
		return summa;
	}
	
}
