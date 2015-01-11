
public class Main {

	public static void main(String[] args) {
		int[][] verkko = RandomVerkonLuoja.luoVerkko(10000, 10);
		int[][] verkko2 = RandomVerkonLuoja.luoVerkko(10000, 10);
//		tulostaVerkko(verkko);
//		System.out.println("");
//		tulostaVerkko(verkko2);
		long alku = System.nanoTime();
		long pieninVirittava = new Prim(verkko).pieninVirittava();
		long keski = System.nanoTime();
		long pieninVirittava2 = new Kruskal(verkko2).pieninVirittava();
		long loppu = System.nanoTime();
		System.out.println("Prim: " + pieninVirittava + ", " + (keski - alku)/1000000.0 + "ms");
		System.out.println("Kruskal: " + pieninVirittava2 + ", " + (loppu - keski)/1000000.0 + "ms");
//		tulostaVerkko(verkko);
//		System.out.println("");
//		tulostaVerkko(verkko2);
	}

	private static void tulostaVerkko(int[][] verkko) {
		for (int i = 1; i < verkko.length; i++) {
			for (int j = 1; j < verkko.length; j++) {
				System.out.print(verkko[i][j] + " ");
			}
			System.out.println();
		}
	}

}
