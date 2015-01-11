import java.util.*;

public class Main {
    public static boolean melkeinPalindromi(String mjono) {
		if (mjono.length() == 2) {
			return true;
		}
		return compareCharacters(mjono);
    }

	private static boolean compareCharacters(String mjono) {
		int lastIndex = mjono.length()-1;
		boolean characterAllreadyRemoved = false;

		for (int i=0; i<=lastIndex/2; i++) {
			if (charactersDontMatch(mjono, i, lastIndex)) {
				if (characterAllreadyRemoved) {
					return false;
				}
				characterAllreadyRemoved = true;
				if (extraCharIsAtBeginning(mjono, i, lastIndex)) {
					i++;
					lastIndex++;
				} else if (extraCharIsAtEnd(mjono, i, lastIndex)) {
					lastIndex--;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean charactersDontMatch(String mjono, int i, int lastIndex) {
		return mjono.charAt(i) != mjono.charAt(lastIndex - i);
	}

	private static boolean extraCharIsAtBeginning(String mjono, int i, int lastIndex) {
		return mjono.charAt(i+1) == mjono.charAt(lastIndex - i);
	}

	private static boolean extraCharIsAtEnd(String mjono, int i, int lastIndex) {
		return mjono.charAt(i) == mjono.charAt(lastIndex - i - 1);
	}
    
    public static void main(String[] args) {
//        System.out.println(melkeinPalindromi("ABCBXA"));
//        System.out.println(melkeinPalindromi("ABCBAX"));
//        System.out.println(melkeinPalindromi("ABCXBA"));
//        System.out.println(melkeinPalindromi("ABCDE"));
//        System.out.println(melkeinPalindromi("BAAAAC"));
        System.out.println(melkeinPalindromi("XABABA"));
    }    
}
