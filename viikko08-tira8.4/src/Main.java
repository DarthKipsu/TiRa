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
    
    public static void main(String[] args) {
        System.out.println(lyhinAika(new int[] {1}, 5));
        System.out.println(lyhinAika(new int[] {1, 1, 1}, 6));
        System.out.println(lyhinAika(new int[] {5, 1, 1}, 6));
        System.out.println(lyhinAika(new int[] {1, 2, 3, 4}, 10));
        System.out.println(lyhinAika(new int[] {1000000000}, 100000));
    }        
}