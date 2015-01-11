import java.util.*;

public class Main {
	
	private static HashSet<String> pituus1;
	private static HashSet<String> pituus2;
	private static HashSet<String> pituus3;
	private static HashSet<String> pituus4;
	private static HashSet<String> pituus5;
	private static HashSet<String> pituus6;
	private static HashSet<String> pituus7;
	private static HashSet<String> pituus8;
	private static HashSet<String> pituus9;
	
    public static int lyhinPuuttuva(String mjono) {
		pituus1 = new HashSet<String>();
		pituus2 = new HashSet<String>();
		pituus3 = new HashSet<String>();
		pituus4 = new HashSet<String>();
		pituus5 = new HashSet<String>();
		pituus6 = new HashSet<String>();
		pituus7 = new HashSet<String>();
		pituus8 = new HashSet<String>();
		pituus9 = new HashSet<String>();
		int pituus = mjono.length();
		
		for (int i=0; i<mjono.length(); i++) {
			if (i >= 0 && pituus1.size() < 4) {
				pituus1.add(mjono.substring(i, i+1));
			}
			if (i > 0 && pituus2.size() < 16) {
				pituus2.add(mjono.substring(i-1, i+1));
			}
			if (i > 1 && pituus3.size() < 64) {
				pituus3.add(mjono.substring(i-2, i+1));
			}
			if (i > 2 && pituus4.size() < 256) {
				pituus4.add(mjono.substring(i-3, i+1));
			}
			if (i > 3 && pituus5.size() < 1024) {
				pituus5.add(mjono.substring(i-4, i+1));
			}
			if (i > 4 && pituus6.size() < 4096) {
				pituus6.add(mjono.substring(i-5, i+1));
			}
			if (i > 5 && pituus7.size() < 16384) {
				pituus7.add(mjono.substring(i-6, i+1));
			}
			if (i > 6 && pituus8.size() < 65536) {
				pituus8.add(mjono.substring(i-7, i+1));
			}
			if (i > 7 && pituus9.size() < 262144) {
				pituus9.add(mjono.substring(i-8, i+1));
			}
		}
		
		if (pituus1.size() < 4) return 1;
		else if (pituus2.size() < 16) return 2;
		else if (pituus3.size() < 64) return 3;
		else if (pituus4.size() < 256) return 4;
		else if (pituus5.size() < 1024) return 5;
		else if (pituus6.size() < 4096) return 6;
		else if (pituus7.size() < 16384) return 7;
		else if (pituus8.size() < 65536) return 8;
		else if (pituus8.size() < 262144) return 9;
		return -1;
    }
    
    public static void main(String[] args) {        
        System.out.println(lyhinPuuttuva("CCCCCCCC"));
        System.out.println(lyhinPuuttuva("ACGTACGT"));
        System.out.println(lyhinPuuttuva("ACAAGCAG"));
        System.out.println(lyhinPuuttuva("ACACACGT"));
    }        
}