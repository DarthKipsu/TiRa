import java.util.*;

public class Main {
	
	private static Queue<Tie> tiet;
	private static int[] viittaukset;
	private static int[] koot;
	private static long kokonaisHinta;
    
    public static long kunnostus(int n, int[] mista, int[] minne, int[] hinta) {
		alustaMuuttujat(n);
		for (int i = 0; i < mista.length; i++) {
			tiet.add(new Tie(hinta[i], mista[i],  minne[i]));
		}
		for (int i = 0; !tiet.isEmpty(); i++) {
			Tie tie = tiet.poll();
			if (samat(tie.a, tie.b)) continue;
			liita(tie.a, tie.b);
			kokonaisHinta += tie.paino;
		}
		return kokonaisHinta;
    }

	private static void alustaMuuttujat(int n) {
		tiet = new PriorityQueue<Tie>();
		kokonaisHinta = 0l;
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
        System.out.println(kunnostus(3, new int[] {1, 2}, new int[] {2, 3}, new int[] {7, 4}));
        System.out.println(kunnostus(3, new int[] {1, 2, 1}, new int[] {2, 3, 3}, new int[] {7, 4, 5}));
        System.out.println(kunnostus(3, new int[] {1, 2, 1}, new int[] {2, 3, 3}, new int[] {2, 2, 2}));
    }        
}