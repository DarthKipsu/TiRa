


public class Laskuri {

	public static int montakoLukua(int[] taulukko, int x) {
		if (taulukko.length == 0) return 0;
		long start = System.currentTimeMillis();
		int esiintymiset = 0;
		
		for (int i=0; i<taulukko.length; i++) {
			if (taulukko[i] == x) {
				esiintymiset++;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("normi haulla kesto: " + (end - start));
		return esiintymiset;
	}

	public static int montakoLukuaBinaarilla(int[] taulukko, int x) {
		if (taulukko.length == 0) return 0;
		long start = System.currentTimeMillis();
		int aloitusIndex = etsiLahto(taulukko, x, 0, taulukko.length-1);
		if (aloitusIndex == -1) return 0;

		int esiintymiset = 0;

		for (int i=aloitusIndex; i<taulukko.length && taulukko[i]==x; i++) {
			esiintymiset++;
		}
		for (int i=aloitusIndex-1; i>=0 && taulukko[i]==x; i--) {
			esiintymiset++;
		}
		long end = System.currentTimeMillis();
		System.out.println("binaarihaulla kesto: " + (end - start));
		return esiintymiset;
	}

	private static int etsiLahto(int[] taulukko, int x, int alku, int loppu) {
		int puolivali = alku + (loppu-alku) / 2;

		if (taulukko[puolivali] == x) {
			return puolivali;
		} else if (taulukko[puolivali] > x) {
			return etsiLahto(taulukko, x, alku, puolivali-1);
		} else if (taulukko[puolivali] < x) {
			return etsiLahto(taulukko, x, puolivali+1, loppu);
		} else {
			return -1;
		}
	}

}
