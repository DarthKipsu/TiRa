package tira_laskari_10_4;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Tira_Laskari_10_4 {

	public static boolean kaksijakoinen(TreeSet<Integer>[] verkko) {
		int[] solmujenVarit = new int[verkko.length];
		System.out.println(Arrays.toString(solmujenVarit));
		solmujenVarit[0] = 1;
		for (int i = 0; i < verkko.length; i++) {
			int vari = solmujenVarit[i] == 1 ? 2 : 1;
			TreeSet<Integer> naapurit = verkko[i];
			
		System.out.println(Arrays.toString(solmujenVarit));
			for (Integer solmu : naapurit) {
				if (solmujenVarit[solmu] != 0 && solmujenVarit[solmu] != vari) {
					return false;
				} else if (solmujenVarit[solmu] == 0) {
					solmujenVarit[solmu] = vari;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		TreeSet<Integer>[] verkko = luoVerkko();
		lisaaSolmut(verkko[0], 1);
		lisaaSolmut(verkko[1], 0, 2, 3, 4);
		lisaaSolmut(verkko[2], 1, 6);
		lisaaSolmut(verkko[3], 1, 4);
		lisaaSolmut(verkko[4], 1, 3, 5);
		lisaaSolmut(verkko[5], 4, 7);
		lisaaSolmut(verkko[6], 2, 7, 8);
		lisaaSolmut(verkko[7], 5, 6, 8);
		lisaaSolmut(verkko[8], 6, 7);
		
		System.out.println(kaksijakoinen(verkko));
	}

	private static TreeSet<Integer>[] luoVerkko() {
		TreeSet<Integer>[] verkko = new TreeSet[9];
		for (int i = 0; i < 9; i++) {
			verkko[i] = new TreeSet<>();
		}
		return verkko;
	}
	
	private static void lisaaSolmut(TreeSet<Integer> verkko, int... solmut) {
		for (int naapuri : solmut) {
			verkko.add(naapuri);
		}
	}

}
