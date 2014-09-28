import java.util.*;

public class Main {

	public static boolean tyhjennys(String mjono) {
		Deque<Character> parittomat = new ArrayDeque<Character>();

		for (int i=0; i<mjono.length(); i++) {
			char merkki = mjono.charAt(i);
			if (parittomat.isEmpty() || parittomat.getFirst() != merkki) {
				parittomat.addFirst(merkki);
			} else {
				parittomat.removeFirst();
			}
		}
		
		return parittomat.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(tyhjennys("ABBABB"));
		System.out.println(tyhjennys("ABBBBB"));
		System.out.println(tyhjennys("AAAAAA"));
		System.out.println(tyhjennys("ABABAB"));
	}
}
