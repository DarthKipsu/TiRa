import java.util.*;

public class Main {
    public static boolean melkeinPalindromi(String mjono) {
		Map<Character, Integer> kirjaimet = new HashMap<Character, Integer>();
		laskeKirjaimet(mjono, kirjaimet);

		return parittomiaMaxYksi(kirjaimet);
		
    }

	private static void laskeKirjaimet(String mjono, Map<Character, Integer> kirjaimet) {
		for (int i=0; i<mjono.length(); i++) {
			char c = mjono.charAt(i);
			if (!kirjaimet.containsKey(c)) {
				kirjaimet.put(c, 0);
			}
			int kirjaintenMaara = kirjaimet.get(c) + 1;
			kirjaimet.replace(c, kirjaintenMaara);
		}
	}

	private static boolean parittomiaMaxYksi(Map<Character, Integer> kirjaimet) {
		int parittomia = 0;
		for (int maara : kirjaimet.values()) {
			if (maara%2 != 0) {
				parittomia++;
			}
		}
		return parittomia < 2;
	}
    
    public static void main(String[] args) {
        System.out.println(melkeinPalindromi("AABB"));
        System.out.println(melkeinPalindromi("ABBBB"));
        System.out.println(melkeinPalindromi("ABCBA"));
        System.out.println(melkeinPalindromi("ABBB"));
        System.out.println(melkeinPalindromi("AABCD"));
    }    
}
