import java.util.*;

public class Main {

	public static boolean yhteys(int n, int[] mista, int[] minne) {
		if (mista.length == 0) return false;
		boolean[] kaydyt = new boolean[n + 1];
		kaydyt[mista[0]] = true;
		for (int i = 0; i < mista.length; i++) {
			if (kaydyt[mista[i]] == true || kaydyt[minne[i]] == true) {
				kaydyt[mista[i]] = true;
				kaydyt[minne[i]] = true;
			}
			if (kaydyt[1] == true && kaydyt[n] == true) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(yhteys(3, new int[]{1, 2}, new int[]{2, 3}));
		System.out.println(yhteys(4, new int[]{1, 2}, new int[]{2, 3}));
		System.out.println(yhteys(4, new int[]{1, 2}, new int[]{3, 4}));
		System.out.println(yhteys(4, new int[]{1, 2}, new int[]{4, 3}));
	}
}
