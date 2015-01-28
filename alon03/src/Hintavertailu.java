
public class Hintavertailu {
	
	private static long[][] hinnat;
	private static int n;
	
	public static void main(String[] args) {
		IO io = new IO();
		n = io.nextInt();
		hinnat = new long[2 * (n + 1)][2];
		
		for (int i = n; i < 2 * n; i++) {
			long mittaus = io.nextLong();
			hinnat[i][0] = mittaus;
			hinnat[i][1] = 1;
		}
		for (int i = n - 1; i > 0; i--) {
			hinnat[i][0] = Math.min(hinnat[i * 2][0], hinnat[i * 2 + 1][0]);
			hinnat[i][1] = 0;
			if (hinnat[i * 2][0] == hinnat[i][0]) hinnat[i][1] += hinnat[i * 2][1];
			if (hinnat[i * 2 + 1][0] == hinnat[i][0]) hinnat[i][1] += hinnat[i * 2 + 1][1];
		}
		int kyselyt = io.nextInt();
		for (int i = 0; i < kyselyt; i++) {
			int tyyppi = io.nextInt();
			if (tyyppi == 1) {
				int kauppa = io.nextInt();
				long uusiHinta = io.nextLong();
				muutaArvoa(kauppa, uusiHinta);
			} else {
				io.println(pieninHinta(io.nextInt(), io.nextInt()));
			}
		}
		
		io.close();
	}
	
	private static void muutaArvoa(int kohta, long arvo) {
		kohta += n - 1;
		hinnat[kohta][0] = arvo;
		kohta /= 2;
		for (; kohta >= 1; kohta /= 2) {
			hinnat[kohta][0] = Math.min(hinnat[2 * kohta][0], hinnat[2 * kohta + 1][0]);
			hinnat[kohta][1] = 0;
			if (hinnat[kohta * 2][0] == hinnat[kohta][0]) hinnat[kohta][1] += hinnat[kohta * 2][1];
			if (hinnat[kohta * 2 + 1][0] == hinnat[kohta][0]) hinnat[kohta][1] += hinnat[kohta * 2 + 1][1];
		}
	}
	
	public static String pieninHinta(int alku, int loppu) {
		alku += n - 1;
		loppu += n - 1;
		long halvin = hinnat[alku][0];
		long halvinLkm = 0;
		while (alku <= loppu) {
			if (alku % 2 == 1) {
				if (halvin > hinnat[alku][0]) {
					halvin = hinnat[alku][0];
					halvinLkm = hinnat[alku][1];
				} else if (halvin == hinnat[alku][0]) halvinLkm += hinnat[alku][1];
				alku++;
			}
			if (loppu % 2 == 0) {
				if (halvin > hinnat[loppu][0]) {
					halvin = hinnat[loppu][0];
					halvinLkm = hinnat[loppu][1];
				} else if (halvin == hinnat[loppu][0]) halvinLkm += hinnat[loppu][1];
				loppu--;
			}
			alku /= 2;
			loppu /= 2;
		}
		return halvin + " " + halvinLkm;
	}
}
