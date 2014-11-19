import java.util.*;

public class Main {
    
    public static boolean lahjajako(int n, int[] mista, int[] minne) {
		if (mista.length == 0) return true;
		int[] jaetut = new int[n + 1];
		jaetut[mista[0]] = 1;
		for (int i = 0; i < mista.length; i++) {
			if (jaetut[mista[i]] == 0) jaetut[mista[i]] = 1;
			int kaverienLahjat = jaetut[mista[i]] == 1 ? 2 : 1;
			if (jaetut[minne[i]] == jaetut[mista[i]]) return false;
			jaetut[minne[i]] = kaverienLahjat;
		}
		return true;
    }
    
    public static void main(String[] args) {
        System.out.println(lahjajako(4, new int[] {1, 2, 3}, new int[] {2, 3, 4}));
        System.out.println(lahjajako(4, new int[] {1, 1, 1}, new int[] {2, 3, 4}));
        System.out.println(lahjajako(3, new int[] {1, 2, 3}, new int[] {2, 3, 1}));
        System.out.println(lahjajako(4, new int[] {1, 2, 3}, new int[] {2, 3, 1}));
    }        
}