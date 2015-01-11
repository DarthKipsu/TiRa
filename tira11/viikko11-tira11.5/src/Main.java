import java.util.*;

public class Main {
	
	private static ArrayList<Integer>[] verkko;
	private static ArrayList<Integer>[] painot;
	private static long[] etaisyydet;
	private static long[] reittienMaarat;
	private static PriorityQueue<Solmu> keko;
    
    public static long reittimaara(int n, int[] mista, int[] minne, int[] matka) {
		laskeEtaisyydet();
		return reittienMaarat[n];
    }
    
    public static void main(String[] args) {
        System.out.println(reittimaara(3, new int[] {1, 2}, new int[] {2, 3}, new int[] {5, 3}));
        System.out.println(reittimaara(3, new int[] {1, 2, 1}, new int[] {2, 3, 3}, new int[] {2, 3, 5}));
        System.out.println(reittimaara(5, new int[] {1, 1, 1, 2, 3, 4}, new int[] {2, 3, 4, 5, 5, 5}, new int[] {1, 1, 1, 1, 1, 1}));
        System.out.println(reittimaara(5, new int[] {1, 1, 1, 2, 3, 4}, new int[] {2, 3, 4, 5, 5, 5}, new int[] {1, 2, 2, 1, 1, 1}));
    }

	private static void alustaMuuttujat(int n) {
		verkko = new ArrayList[n + 1];
		painot = new ArrayList[n + 1];
		etaisyydet = new long[n + 1];
		reittienMaarat = new long[n + 1];
		reittienMaarat[1] = 1;
		keko = new PriorityQueue<Solmu>();
		keko.add(new Solmu(0L, 1));	
		alustaArrayListat();
		alustaEtaisyydet();
	}

	private static void alustaArrayListat() {
		for (int i = 1; i < verkko.length; i++) {
			verkko[i] = new ArrayList<Integer>();
			painot[i] = new ArrayList<Integer>();
		}
	}
	
	private static void alustaEtaisyydet() {
		for (int i = 2; i < etaisyydet.length; i++) {
			etaisyydet[i] = -1;
		}
	}
	
	private static void luoVerkko(int[] mista, int[] minne, int[] matka) {
		for (int i = 0; i < mista.length; i++) {
			verkko[mista[i]].add(minne[i]);
			verkko[minne[i]].add(mista[i]);
			painot[mista[i]].add(matka[i]);
			painot[minne[i]].add(matka[i]);
		}
	}
	
	private static void laskeEtaisyydet() {
		while (keko.size() > 0) {
			Solmu solmu = keko.poll();
			long etaisyys = solmu.getEtaisyys();
			int tunnus = solmu.getTunnus();
			for (int i = 0; i < verkko[tunnus].size(); i++) {
				tarkistaArvioSolmulle(i, tunnus, etaisyys);
			}
		}
	}

	private static void tarkistaArvioSolmulle(int i, int tunnus, long etaisyys) {
		int solmu2 = verkko[tunnus].get(i);
		long vanhaEtaisyys = etaisyydet[solmu2];
		long uusiEtaisyys = etaisyys + painot[tunnus].get(i);
		if (vanhaEtaisyys < 0 || uusiEtaisyys < vanhaEtaisyys) {
			etaisyydet[solmu2] = uusiEtaisyys;
			keko.add(new Solmu(uusiEtaisyys, solmu2));
			reittienMaarat[solmu2] = reittienMaarat[tunnus];
		} else if (vanhaEtaisyys == uusiEtaisyys) {
			reittienMaarat[solmu2] += reittienMaarat[tunnus];
		}
	}
}