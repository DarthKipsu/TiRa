import java.util.*;

public class Main {
    public static boolean kaksiSamaa(String mjono) {
		if (mjono.length() < 2) return false;

		for (int i=0; i<mjono.length()-1; i++) {
			if (mjono.charAt(i) == mjono.charAt(i+1)) {
				return true;
			}
		}
		return false;
    }
    
    public static void main(String[] args) {
        System.out.println(kaksiSamaa("ABAABA"));
        System.out.println(kaksiSamaa("XXXXX"));
        System.out.println(kaksiSamaa("ABCABC"));
        System.out.println(kaksiSamaa("ABABA"));
    }

}
