
package tira_laskari_11_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	private static ArrayList<Integer>[] verkko;
	private static ArrayList<Integer>[] painot;
	private static int[][] minimiEtaisyydet;

	public static void main(String[] args) {
		ArrayList[][] uusiVerkko = RandomVerkonLuoja.luoVerkko(800, 4);
		verkko = uusiVerkko[0];
		painot = uusiVerkko[1];
		Long start = System.nanoTime();
		laskeMinimiEtaisyydet();
		Long end =System.nanoTime();
		System.out.println("Kesto: " + (end - start)/1000000.0 + " ms");
//		tulostaVerkko();
//		tulostaMinimit();
	}
	
	private static void laskeMinimiEtaisyydet() {
		minimiEtaisyydet = new int[verkko.length][verkko.length];
		lisaaLahtoarvotTaulukkoon();
		kayEtaisyydetLapi();
	}

	private static void lisaaLahtoarvotTaulukkoon() {
		for (int i = 1; i < verkko.length; i++) {
			for (int j = 1; j < verkko.length; j++) {
				if (i == j) {
					minimiEtaisyydet[i][j] = 0;
				} else if  (verkko[i].contains(j)) {
					minimiEtaisyydet[i][j] = painot[i].get(verkko[i].indexOf(j));
				} else {
					minimiEtaisyydet[i][j] = 999999;
				}
			}
		}
	}

	private static void kayEtaisyydetLapi() {
		for (int i = 1; i < verkko.length; i++) {
			for (int j = 1; j < verkko.length; j++) {
				for (int k = 1; k < verkko.length; k++) {
					if (kiertotieLyhyempi(j, k, i)) {
						minimiEtaisyydet[j][k] =
								minimiEtaisyydet[j][i] + minimiEtaisyydet[i][k];
					}
				}
			}
		}
	}

	private static boolean kiertotieLyhyempi(int j, int k, int i) {
		return minimiEtaisyydet[j][k] >
				minimiEtaisyydet[j][i] + minimiEtaisyydet[i][k];
	}

	private static void tulostaVerkko() {
		for (int i = 1; i < verkko.length; i++) {
			System.out.print(i + ": " + verkko[i].toString());
			System.out.print("  p: " + painot[i].toString());
			System.out.println();
		}
	}
	
	private static void tulostaMinimit() {
		for (int i = 0;i <verkko.length; i++) {
			System.out.println(Arrays.toString(minimiEtaisyydet[i]));
		}
	}
	
}
