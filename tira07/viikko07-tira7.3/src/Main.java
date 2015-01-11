import java.util.*;

public class Main {   
    public static int suurinRyhma(String[] sanat) {
		HashMap<String, Lukumaara> anagrammit = new HashMap<String, Lukumaara>();
		int suurinAnagrammi = 1;
		
		for (String sana : sanat) {
			char[] sananMerkit = sana.toCharArray();
			Arrays.sort(sananMerkit);
			String sanaJarjestyksessa = new String(sananMerkit);
			
			if (anagrammit.containsKey(sanaJarjestyksessa)) {
				Lukumaara paivitettava = anagrammit.get(sanaJarjestyksessa);
				paivitettava.kasvata();
				if (paivitettava.get() > suurinAnagrammi) {
					suurinAnagrammi++;
				}
			} else {
				anagrammit.put(sanaJarjestyksessa, new Lukumaara());
			}
		}
		return suurinAnagrammi;
    }
    
    public static void main(String[] args) {        
        System.out.println(suurinRyhma(new String[] {"apina", "banaani", "cembalo"}));
        System.out.println(suurinRyhma(new String[] {"talo", "katu", "lato"}));
        System.out.println(suurinRyhma(new String[] {"ab", "ab", "ba", "ba"}));
        System.out.println(suurinRyhma(new String[] {"iines", "otto", "sieni", "toto"}));
    }        
}