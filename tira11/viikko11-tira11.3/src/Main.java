import java.util.*;

public class Main {
	
	private static ArrayList<Integer>[] verkko;
	private static int[][] minimiEtaisyydet;
	private static int kaukaisinYhteys;
	
    public static int kaukaisimmat(int n, int[] mista, int[] minne) {
		luoVerkko(n, mista, minne);
		laskeMinimiEtaisyydet();
		haeKaukaisinEtaisyys();
		return kaukaisinYhteys;
    }

	private static void luoVerkko(int n, int[] mista, int[] minne) {
		verkko = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			verkko[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < mista.length; i++) {
			verkko[mista[i]].add(minne[i]);
			verkko[minne[i]].add(mista[i]);
		}
	}
	
	private static void laskeMinimiEtaisyydet() {
		minimiEtaisyydet = new int[verkko.length][verkko.length];
		kaukaisinYhteys = 1;
		lisaaLahtoarvotTaulukkoon();
		kayEtaisyydetLapi();
	}

	private static void lisaaLahtoarvotTaulukkoon() {
		for (int i = 1; i < verkko.length; i++) {
			for (int j = 1; j < verkko.length; j++) {
				if (i == j) {
					minimiEtaisyydet[i][j] = 0;
				} else if  (verkko[i].contains(j)) {
					minimiEtaisyydet[i][j] = 1;
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
//						if (minimiEtaisyydet[j][k] > kaukaisinYhteys) {
//							kaukaisinYhteys = minimiEtaisyydet[j][k];
//						}
					}
				}
			}
		}
	}

	private static boolean kiertotieLyhyempi(int j, int k, int i) {
		return minimiEtaisyydet[j][k] >
				minimiEtaisyydet[j][i] + minimiEtaisyydet[i][k];
	}

	private static void haeKaukaisinEtaisyys() {
		for (int i = 0; i < minimiEtaisyydet.length; i++) {
			for (int j = 0; j < minimiEtaisyydet[i].length; j++) {
				if (minimiEtaisyydet[i][j] > kaukaisinYhteys) {
					kaukaisinYhteys = minimiEtaisyydet[i][j];
				}
			}
		}
	}
    
    public static void main(String[] args) {
        System.out.println(kaukaisimmat(5, new int[] {1, 2, 3, 4, 5}, new int[] {2, 3, 4, 5, 1}));
        System.out.println(kaukaisimmat(3, new int[] {1, 2}, new int[] {2, 3}));
        System.out.println(kaukaisimmat(3, new int[] {1, 1}, new int[] {2, 3}));
        System.out.println(kaukaisimmat(3, new int[] {1, 2, 3}, new int[] {2, 3, 1}));
        System.out.println(kaukaisimmat(4, new int[] {1, 2, 3}, new int[] {2, 3, 4}));
    }        
}