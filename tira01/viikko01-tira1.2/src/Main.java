import java.util.*;

public class Main {
    public static int pisinOsuus(String mjono) {
		if (mjono.length() == 1) {
			return 1;
		}
		int pisin = 1;
		int nykyinen = 1;
		for (int i=1; i<mjono.length(); i++) {
			if (mjono.charAt(i-1) == mjono.charAt(i)) {
				nykyinen++;
			} else {
				nykyinen = 1;
			}
			if (nykyinen > pisin) {
				pisin = nykyinen;
			}
		}
		return pisin;
    }
    
    public static void main(String[] args) {
        System.out.println(pisinOsuus("AABBBCC"));
        System.out.println(pisinOsuus("AABBCC"));
        System.out.println(pisinOsuus("XXXXXXX"));
        System.out.println(pisinOsuus("AAABBBB"));
        System.out.println(pisinOsuus("AAAABBB"));
        System.out.println(pisinOsuus("ABBABBBA"));
    }
}
