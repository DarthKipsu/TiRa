import java.util.*;

public class Main {

	private static ArrayList<Integer>[] verkko;
	private static ArrayList<Long>[] painot;
	private static long[] etaisyydet;
	private static PriorityQueue<Solmu> keko;

	public static int lentomaara(int n, int[] juna1, int[] juna2, int[] lento1, int[] lento2) {
		alustaMuuttujat(n);
		luoVerkko(juna1, juna2, lento1, lento2);
		laskeEtaisyydet();
		int lentoja = 0;
		long etaisyysN = etaisyydet[n];
		if (etaisyysN == -1) return -1;
		while (etaisyysN >= 1000000) {
			lentoja++;
			etaisyysN -= 1000000;
		}
		return lentoja;
	}

	public static void main(String[] args) {
		System.out.println(lentomaara(3, new int[]{1}, new int[]{2}, new int[]{1, 2}, new int[]{2, 3}));
		System.out.println(lentomaara(3, new int[]{1}, new int[]{3}, new int[]{1, 2}, new int[]{2, 3}));
		System.out.println(lentomaara(3, new int[]{}, new int[]{}, new int[]{1, 2}, new int[]{2, 3}));
		System.out.println(lentomaara(3, new int[]{1, 2}, new int[]{2, 3}, new int[]{1, 2}, new int[]{2, 3}));
        int n = 100000;
        int[] juna1 = new int[n-1];
        int[] juna2 = new int[n-1];
        int[] lento1 = new int[n-1];
        int[] lento2 = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            juna1[i] = i+1;
            juna2[i] = i+2;
            lento1[i] = i+1;
            lento2[i] = i+2;
        }
        System.out.println(lentomaara(n, juna1, juna2, lento1, lento2));
	}

	private static void alustaMuuttujat(int n) {
		verkko = new ArrayList[n + 1];
		painot = new ArrayList[n + 1];
		etaisyydet = new long[n + 1];
		keko = new PriorityQueue<Solmu>();
		keko.add(new Solmu(0L, 1));
		alustaArrayListat();
		alustaEtaisyydet();
	}

	private static void alustaArrayListat() {
		for (int i = 1; i < verkko.length; i++) {
			verkko[i] = new ArrayList<Integer>();
			painot[i] = new ArrayList<Long>();
		}
	}

	private static void alustaEtaisyydet() {
		for (int i = 2; i < etaisyydet.length; i++) {
			etaisyydet[i] = -1;
		}
	}

	private static void luoVerkko(int[] juna1, int[] juna2, int[] lento1, int[] lento2) {
		for (int i = 0; i < juna1.length; i++) {
			verkko[juna1[i]].add(juna2[i]);
			verkko[juna2[i]].add(juna1[i]);
			painot[juna1[i]].add(1l);
			painot[juna2[i]].add(1l);
		}
		for (int i = 0; i < lento1.length; i++) {
			verkko[lento1[i]].add(lento2[i]);
			verkko[lento1[i]].add(lento2[i]);
			painot[lento1[i]].add(1000000l);
			painot[lento2[i]].add(1000000l);
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
			if (etaisyydet[etaisyydet.length - 1] > 0 &&
				etaisyydet[etaisyydet.length - 1] < 1000000) {
				break;
			}
		}
	}

	private static void tarkistaArvioSolmulle(int i, int tunnus, long etaisyys) {
		int solmu2 = verkko[tunnus].get(i);
		long vanhaEtaisyys = etaisyydet[solmu2];
		try {
			long uusiEtaisyys = etaisyys + painot[tunnus].get(i);
			if (vanhaEtaisyys < 0 || uusiEtaisyys < vanhaEtaisyys) {
				etaisyydet[solmu2] = uusiEtaisyys;
				keko.add(new Solmu(uusiEtaisyys, solmu2));
			}
		} catch (Exception e) {}
	}
}
