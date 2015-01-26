
public class Lampotila {
	
	public static void main(String[] args) {
		IO io = new IO();
		
		int n = io.nextInt();
		long[] minimit = new long[2 * n];
		long[] maksimit = new long[2 * n];
		for (int i = n; i < n * 2; i++) {
			long mittaus = io.nextLong();
			minimit[i] = mittaus;
			maksimit[i] = mittaus;
		}
		for (int i = n - 1; i > 0; i--) {
			minimit[i] = Math.min(minimit[i * 2], minimit[i * 2 + 1]);
			maksimit[i] = Math.max(maksimit[i * 2], maksimit[i * 2 + 1]);
		}
		
		int kyselyt = io.nextInt();
		for (int i = 0; i < kyselyt; i++) {
			int alku = io.nextInt();
			int loppu = io.nextInt();
			io.print(minimi(minimit, alku, loppu));
			io.print(" ");
			io.println(maksimi(maksimit, alku, loppu));
		}
		
		io.close();
	}
	
	public static long minimi(long[] minimit, int alku, int loppu) {
		alku += minimit.length / 2 - 1;
		loppu += minimit.length / 2 - 1;
		long minimi = minimit[alku];
		while (alku <= loppu) {
			if (alku % 2 == 1) minimi = Math.min(minimi, minimit[alku++]);
			if (loppu % 2 == 0) minimi = Math.min(minimi, minimit[loppu--]);
			alku /= 2;
			loppu /= 2;
		}
		return minimi;
	}
	
	public static long maksimi(long[] maksimit, int alku, int loppu) {
		alku += maksimit.length / 2 - 1;
		loppu += maksimit.length / 2 - 1;
		long maksimi = maksimit[alku];
		while (alku <= loppu) {
			if (alku % 2 == 1) maksimi = Math.max(maksimi, maksimit[alku++]);
			if (loppu % 2 == 0) maksimi = Math.max(maksimi, maksimit[loppu--]);
			alku /= 2;
			loppu /= 2;
		}
		return maksimi;
	}
	
}
