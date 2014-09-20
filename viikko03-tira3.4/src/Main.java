import java.util.*;

public class Main {

	public static List<Integer> summat;

	public static int jaaOmenat(int[] omenat) {
		summat = new ArrayList<Integer>();
		int paino = laskeYhteisPaino(omenat);

		for (int i=0; i<omenat.length; i++) {
			summat.add(omenat[i]);
			laskeSummat(omenat, omenat[i], paino / 2, i + 1);
		}

		int pieninErotus = etsiPieninErotus(paino);
		return pieninErotus;
	}

	private static int laskeYhteisPaino(int[] omenat) {
		int paino = 0;
		for (Integer omena : omenat) {
			paino += omena;
		}
		return paino;
	}

	private static void laskeSummat(int[] omenat, int paino, int raja, int i) {
		if (i == omenat.length) return;
		for (; i<omenat.length; i++) {
			summat.add(paino + omenat[i]);
			if (paino + omenat[i] >= raja) return;
			laskeSummat(omenat, paino + omenat[i], raja, i + 1);
		}
	}

	private static int etsiPieninErotus(int paino) {
		int pieninErotus = Math.abs(paino - 2 * summat.get(0));
		for (Integer omena : summat) {
			int erotus = Math.abs(paino - 2 * omena);
			if (erotus < pieninErotus) {
				pieninErotus = erotus;
			}
		}
		return pieninErotus;
	}

    public static void main(String[] args) {
        System.out.println(jaaOmenat(new int[] {5, 3, 6, 2, 9}));
        System.out.println(jaaOmenat(new int[] {2, 2}));
        System.out.println(jaaOmenat(new int[] {999}));
        System.out.println(jaaOmenat(new int[] {999, 1, 1, 1}));
        System.out.println(jaaOmenat(new int[] {696, 397, 401, 58, 30, 159, 323, 58, 305, 399,
                         368, 689, 947, 405, 887}));
    }    
}