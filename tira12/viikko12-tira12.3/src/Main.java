import java.util.*;

public class Main {
	
	private static HashMap<String, Integer> kielet;
	private static Queue<Kaantaja> kaantajat;
	private static int[] viittaukset;
	private static int[] koot;
	private static int kieletI;
	private static long kokonaisHinta;
    
    public static long kaannokset(String[] mista, String[] minne, int[] hinta) {
		alustaMuuttujat(mista.length);
		for (int i = 0; i < mista.length; i++) {
			int a = lisaaKielilistaan(mista[i]);
			int b = lisaaKielilistaan(minne[i]);
			kaantajat.add(new Kaantaja(hinta[i], a, b));
		}
		for (int i = 0; !kaantajat.isEmpty(); i++) {
			Kaantaja kaantaja = kaantajat.poll();
			if (samat(kaantaja.a, kaantaja.b)) continue;
			liita(kaantaja.a, kaantaja.b);
			kokonaisHinta += kaantaja.paino;
		}
		return kokonaisHinta;
    }

	private static int lisaaKielilistaan(String kieli) {
		int numero;
		if (kielet.containsKey(kieli)) numero = kielet.get(kieli);
		else {
			numero = kieletI;
			kielet.put(kieli, numero);
			kieletI++;
		}
		return numero;
	}

	private static void alustaMuuttujat(int n) {
		kaantajat = new PriorityQueue<Kaantaja>();
		kielet = new HashMap<String, Integer>();
		kokonaisHinta = 0l;
		kieletI = 1;
		viittaukset = new int[(n+1)*2];
		koot = new int[(n+1)*2];
		for (int i = 1; i < viittaukset.length; i++) {
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
        System.out.println(kaannokset(new String[] {"suomi", "ruotsi"}, new String[] {"ruotsi", "englanti"}, new int[] {7, 4}));
        System.out.println(kaannokset(new String[] {"suomi", "ruotsi"}, new String[] {"saksa", "englanti"}, new int[] {5, 5}));
        System.out.println(kaannokset(new String[] {"suomi", "ruotsi", "suomi"}, new String[] {"ruotsi", "englanti", "englanti"}, new int[] {7, 4, 5}));
        System.out.println(kaannokset(new String[] {"suomi", "suomi"}, new String[] {"ruotsi", "ruotsi"}, new int[] {2, 3}));
    }        
}