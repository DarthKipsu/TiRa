import java.util.*;

public class Main {
	
	private static Queue<Raide> raiteet;
	private static int[] viittaukset;
	private static int[] koot;
	private static long maxPaino;
    
    public static long suurinJuna(int n, int[] mista, int[] minne, int[] raja) {
		alustaMuuttujat(n);
		for (int i = 0; i < mista.length; i++) {
			raiteet.add(new Raide(raja[i], mista[i],  minne[i]));
		}
		for (int i = 0; !raiteet.isEmpty(); i++) {
			Raide raide = raiteet.poll();
			if (samat(raide.a, raide.b)) continue;
			liita(raide.a, raide.b);
			if (raide.paino < maxPaino) maxPaino = raide.paino;
		}
		return maxPaino;
    }

	private static void alustaMuuttujat(int n) {
		raiteet = new PriorityQueue<Raide>(Collections.reverseOrder());
		maxPaino = Long.MAX_VALUE;
		viittaukset = new int[n + 1];
		koot = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			viittaukset[i] = i;
			koot[i] = 1;
		}
	}
	
	private static boolean samat(int a, int b) {
		while (viittaukset[a] != a) a = viittaukset[a];
		while (viittaukset[b] != b) b = viittaukset[b];
		return a == b;
	}
	
	private static void liita(int a, int b) {
		while (viittaukset[a] != a) a = viittaukset[a];
		while (viittaukset[b] != b) b = viittaukset[b];
		if (koot[a] > koot[b]) {
			viittaukset[b] = a;
			koot[a] += koot[b];
		} else {
			viittaukset[a] = b;
			koot[b] += koot[a];
		}
	}
    
    public static void main(String[] args) {
        System.out.println(suurinJuna(3, new int[] {1, 2}, new int[] {2, 3}, new int[] {7, 4}));
        System.out.println(suurinJuna(3, new int[] {1, 2}, new int[] {2, 3}, new int[] {2, 2}));
        System.out.println(suurinJuna(3, new int[] {1, 2, 1}, new int[] {2, 3, 3}, new int[] {7, 4, 5}));
    }        
}