import java.util.*;

public class Main {
    
	private static class Arvo implements Comparable<Arvo> {
		public long valmistumisAika;
		public long valmistusNopeus;

		public Arvo(long valmistumisAika, long valmistusNopeus) {
			this.valmistumisAika = valmistumisAika;
			this.valmistusNopeus = valmistusNopeus;
		}

		@Override
		public int compareTo(Arvo o) {
			return (int)(valmistumisAika - o.valmistumisAika);
		}
		
	}
	
    public static long lyhinAika(int[] koneet, int maara) {
		
		PriorityQueue<Arvo> valmistusajat = new PriorityQueue<Arvo>();
		int valmiina = 0;
		Arvo viimeisin = null;
		
		for (int i = 0; i < koneet.length; i++) {
			valmistusajat.add(new Arvo(koneet[i], koneet[i]));
		}
		
		while (valmiina < maara) {
			viimeisin = valmistusajat.poll();
			valmiina ++;
			viimeisin.valmistumisAika += viimeisin.valmistusNopeus;
			valmistusajat.add(viimeisin);
		}
		
		return viimeisin.valmistumisAika - viimeisin.valmistusNopeus;
	}
		
//		List<Integer> valmistusajat = new ArrayList<Integer>();
//		int valmistusAika;
//		int valmis = 0;
//		
//		Arrays.sort(koneet);
//		for (int aika = koneet[0]; valmis < maara; aika++) {
//			for (; j < koneet.length && valmis < maara; j++) {
//				if (i % koneet[j] != 0) continue;
//				valmistusAika = koneet[j];
//				valmis++;
//				valmistusajat.add(valmis);
//			}
//		}
//		
//		Collections.sort(valmistusajat);
//		
//		return valmistusajat.get(maara - 1);
//    }
    
//    public static long lyhinAika(int[] koneet, int maara) {
//		
//		List<Integer> valmistusajat = new ArrayList<Integer>();
//		
//		for (int i = 0; i < koneet.length; i++) {
//			int valmistusAika = koneet[i];
//			int valmis = 0;
//			for (int j = 1; valmis < maara; j++) {
//				valmis = valmistusAika * j;
//				valmistusajat.add(valmis);
//			}
//		}
//		
//		Collections.sort(valmistusajat);
//		
//		return valmistusajat.get(maara - 1);
//    }
		
//		PriorityQueue<Integer> valmistusajat = new PriorityQueue<Integer>();
//		
//		for (int i = 0; i < koneet.length; i++) {
//			int valmistusAika = koneet[i];
//			int valmis = 0;
//			for (int j = 1; valmis < maara; j++) {
//				valmis = valmistusAika * j;
//				valmistusajat.add(valmis);
//			}
//		}
//		
//		int valmistusAika = 0;
//		int valmistuneet = 0;
//		while (valmistuneet < maara) {
//			if (valmistusajat.peek() > valmistusAika) {
//				valmistusAika = valmistusajat.poll();
//			} else {
//				valmistusajat.poll();
//			}
//			valmistuneet++;
//		}
//		return valmistusAika;
//    }
    
//    public static long lyhinAika(int[] koneet, int maara) {
//		Arrays.sort(koneet);
//		long aika = 0;
//		long tuotteita = 0;
//		
//		while (tuotteita < maara) {
//			aika++;
//			for (int i = 0; i < koneet.length && koneet[i] <= aika; i++) {
//				if (aika % koneet[i] == 0) tuotteita++;
//			}
//		}
//		return aika;
//    }
    
    public static void main(String[] args) {
        System.out.println(lyhinAika(new int[] {1}, 5));
        System.out.println(lyhinAika(new int[] {1, 1, 1}, 6));
        System.out.println(lyhinAika(new int[] {5, 1, 1}, 6));
        System.out.println(lyhinAika(new int[] {1, 2, 3, 4}, 10));
        System.out.println(lyhinAika(new int[] {1000000000}, 100000));
    }        
}