
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Search {

	public static void main(String[] args) {
		
		int taulukonKoko = 3000000;
		List<Integer> taulukko = new ArrayList<Integer>();

		for (int i=0; i<taulukonKoko; i++) {
			Random random = new Random();
			int luku = random.nextInt(1001);
			taulukko.add(luku);
		}

		System.out.println(taulukko);
		long start = System.currentTimeMillis();
		
//		List<Integer> jarjestetty = new ArrayList<Integer>();
//		jarjestetty.add(taulukko.get(0));
//		for (int i=1; i<taulukonKoko; i++) {
//			int j = i-1;
//			if (taulukko.get(i) >= jarjestetty.get(j)) {
//				jarjestetty.add(taulukko.get(i));
//				continue;
//			}
//			while (j > 0 && taulukko.get(i) < jarjestetty.get(j-1)) {
//				j--;
//			}
//			
//			jarjestetty.add(j, taulukko.get(i));
//		}
//
//		long end = System.currentTimeMillis();
//		System.out.println(jarjestetty);

		Collections.sort(taulukko);
		long end = System.currentTimeMillis();
		System.out.println(taulukko);

		
		System.out.println(end - start);
	}
	
}
