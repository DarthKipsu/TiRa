import java.util.*;

public class Ystavat {
	
	private static int[] viittaukset;
	private static int[] koot;
	private static int[] vari;
    
    public Ystavat(int n) {
		viittaukset = new int[n + 1];
		koot = new int[n + 1];
		vari = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			viittaukset[i] = i;
			koot[i] = 1;
		}
    }    
    
    public void lisaaYstavyys(int a, int b) {
		if (!samat(a, b)) liita(a, b);
    }
    
    public boolean lahjajako() {
    }
	
	private boolean samat(int a, int b) {
		while (viittaukset[a] != a) a = viittaukset[a];
		while (viittaukset[b] != b) b = viittaukset[b];
		return a == b;
	}
	
	private void liita(int a, int b) {
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
}
