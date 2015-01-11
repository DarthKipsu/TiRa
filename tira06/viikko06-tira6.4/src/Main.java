import java.util.*;

public class Main {   
    public static int korienMaara(int[] taulukko, int raja) {
		TreeMap<Integer, Integer> omenat = createTreeMap(taulukko);
		
		int korienMaara = 0;
		while (!omenat.isEmpty()) {
			sijoitaOmenat(raja, omenat);
			korienMaara++;
		}
		return korienMaara;
    }

	private static TreeMap<Integer, Integer> createTreeMap(int[] taulukko) {
		TreeMap<Integer, Integer> omenat = new TreeMap<Integer, Integer>();
		for (int omena : taulukko) {
			if (!omenat.containsKey(omena)) {
				omenat.put(omena, 1);
			} else {
				omenat.replace(omena, omenat.get(omena) + 1);
			}
		}
		return omenat;
	}

	private static void sijoitaOmenat(int korissaTilaa, TreeMap<Integer, Integer> omenat) {
		korissaTilaa -= omenat.lastKey();
		vahennaOmena(omenat, omenat.lastKey());
		
		if (korissaTilaa != 0) {
			if (omenat.containsKey(korissaTilaa)) {
				vahennaOmena(omenat, korissaTilaa);
			} else if (omenat.lowerKey(korissaTilaa) != null) {
				vahennaOmena(omenat, omenat.lowerKey(korissaTilaa));
			}
		}
	}

	private static void vahennaOmena(TreeMap<Integer, Integer> omenat, int key) {
		if (omenat.get(key) == 1) {
			omenat.remove(key);
		} else {
			omenat.replace(key, omenat.get(key) - 1);
		}
	}
    
    public static void main(String[] args) {
        System.out.println(korienMaara(new int[] {1, 2, 3, 4, 5}, 5));
        System.out.println(korienMaara(new int[] {2, 2, 3, 4, 5}, 5));
        System.out.println(korienMaara(new int[] {1, 1, 1, 1, 1}, 5));
        System.out.println(korienMaara(new int[] {3, 3, 3, 3, 3}, 5));
        System.out.println(korienMaara(new int[] {5, 5, 5, 5, 5}, 5));
    }        
}