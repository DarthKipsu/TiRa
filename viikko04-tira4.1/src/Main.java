import java.util.*;

public class Main {
    public static boolean sulutus(String mjono) {
		int alut = 0;
		int loput = 0;
		char[] jono = mjono.toCharArray();

		for (Character c : jono) {
			if (c == '(') alut++;
			else if (alut == loput) return false;
			else loput++;
		}

		return alut == loput;
    }
    
    
    public static void main(String[] args) {
        System.out.println(sulutus("((()))"));
        System.out.println(sulutus("(())()"));
        System.out.println(sulutus("(()))("));
        System.out.println(sulutus("())(()"));
    }        
}