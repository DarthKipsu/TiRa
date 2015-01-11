
import java.util.*;

public class Main {

	public static String jarjestaMerkit(String mjono) {
		TreeMap<Character, Integer> map = createTreeMap(mjono);
		char[] sorted = sortTreeMap(map, mjono.length());

		return new String(sorted);
	}

	private static TreeMap<Character, Integer> createTreeMap(String mjono) {
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < mjono.length(); i++) {
			char c = mjono.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}

			map.replace(c, map.get(c) + 1);
		}
		return map;
	}

	private static char[] sortTreeMap(TreeMap<Character, Integer> map, int strtingLength) {
		char[] sorted = new char[strtingLength];
		for (int i = 0; i < sorted.length; i++) {
			int halfPoint = strtingLength / 2;
			boolean addedForcedChar = findGreaterThanHalfpoint(map, halfPoint, sorted, i);
			if (addedForcedChar) {
				strtingLength--;
				continue;
			}
			if (i == 0) {
				sorted[i] = addKey(map.firstKey(), map);
				strtingLength--;
				continue;
			}
			char previous = sorted[i - 1];
			if (map.firstKey() != previous) {
				sorted[i] = addKey(map.firstKey(), map);
				strtingLength--;
			} else {
				char nextKey = map.higherKey(map.firstKey());
				sorted[i] = addKey(nextKey, map);
				strtingLength--;
			}

		}
		return sorted ;
	}

	private static boolean findGreaterThanHalfpoint(TreeMap<Character, Integer> map, int halfPoint, char[] sorted, int i) {
		for (char c : map.keySet()) {
			if (map.get(c) > halfPoint) {
				sorted[i] = addKey(c, map);
				return true;
			}
		}
		return false;
	}

	private static char addKey(char key, TreeMap<Character, Integer> map) {
		int keyNumber = map.get(key) - 1;
		if (keyNumber == 0) {
			map.remove(key);
		} else {
			map.replace(key, keyNumber);
		}
		return key;
	}
 
    public static void main(String[] args) {
        System.out.println(jarjestaMerkit("AAABBB"));
        System.out.println(jarjestaMerkit("CBAED"));
        System.out.println(jarjestaMerkit("AXAXA"));
        System.out.println(jarjestaMerkit("CBAXXXX"));
    }    
}
