
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;


public class Main {
	
	public static HashSet lisaaHashSettiinJarjestyksessa(int lukuja) {
		HashSet set = new HashSet();
		for (int i=0; i<lukuja; i++) {
			set.add(i);
		}
		return set;
	}
	
	public static HashSet lisaaHashSettiinRandomilla(int lukuja) {
		HashSet set = new HashSet();
		for (int i=0; i<lukuja; i++) {
			set.add(new Random().nextInt(lukuja));
		}
		return set;
	}

	public static TreeSet lisaaTreeSettiinJarjestyksessa(int lukuja) {
		TreeSet set = new TreeSet();
		for (int i=0; i<lukuja; i++) {
			set.add(i);
		}
		return set;
	}
	
	public static TreeSet lisaaTreeSettiinRandomilla(int lukuja) {
		TreeSet set = new TreeSet();
		for (int i=0; i<lukuja; i++) {
			set.add(new Random().nextInt(lukuja));
		}
		return set;
	}

	public static void main(String[] args) {
		long alkuHash = System.nanoTime();
		HashSet hash1 = lisaaHashSettiinJarjestyksessa(1000000);
		long keskiHash = System.nanoTime();
		HashSet hash2 = lisaaHashSettiinRandomilla(1000000);
		long loppuHash = System.nanoTime();
		
		TreeSet tree1 = lisaaTreeSettiinJarjestyksessa(1000000);
		long keskiTree = System.nanoTime();
		TreeSet tree2 = lisaaTreeSettiinRandomilla(1000000);
		long loppuTree = System.nanoTime();
		
		System.out.println("HashSet Järjestyksessä: " + (keskiHash - alkuHash)/1000000.0 + "ms");
		System.out.println("HashSet Randomilla: " + (loppuHash - keskiHash)/1000000.0 + "ms");
		
		System.out.println("TreeSet Järjestyksessä: " + (keskiTree - loppuHash)/1000000.0 + "ms");
		System.out.println("TreeSet Randomilla: " + (loppuTree - keskiTree)/1000000.0 + "ms");
	}
	
}
