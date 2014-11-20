import java.util.*;

public class Lentoreitit {
	
	private ArrayList<Integer>[] yhteydet;
	private boolean keepGoing;
    
    public Lentoreitit(int n, int[] mista, int[] minne) {
		luoVerkko(n);
		lisaaSolmut(mista, minne);
    }
    
    public boolean mahdollinen(int alku, int loppu, int lennot) {
		if (alku == loppu) {
			if (lennot % 2 == 0) return true;
			else return false;
		}
		
		ArrayDeque<int[]> mihinMennaan = new ArrayDeque<int[]>();
		HashSet<Integer> kaydyt = new HashSet<Integer>();
		kaydyt.add(alku);
		keepGoing = true;
		
		if (tarkastaSeuraavatKohteet(new int[]{alku, 1}, loppu, lennot, kaydyt, mihinMennaan)) {
			return true;
		}
		while (!mihinMennaan.isEmpty() && keepGoing) {
			int[] seuraava = mihinMennaan.poll();
			if (tarkastaSeuraavatKohteet(seuraava, loppu, lennot, kaydyt, mihinMennaan)) {
				return true;
			}
		}
		return false;
    }

	private boolean tarkastaSeuraavatKohteet(int[] seuraava, int loppu, 
			int lennot, HashSet<Integer> kaydyt, ArrayDeque<int[]> mihinMennaan) {
		for (int kohde : yhteydet[seuraava[0]]) {
			if (kohde == loppu) {
				if ((lennot - seuraava[1]) % 2 == 0) return true; 
				else {
					keepGoing = false;
					return false;
				}
			} else if (seuraava[1] < lennot && !kaydyt.contains(kohde)) {
				mihinMennaan.add(new int[]{kohde, seuraava[1] + 1});
				kaydyt.add(kohde);
			}
		}
		return false;
	}
	
	private void luoVerkko(int n) {
		yhteydet = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			yhteydet[i] = new ArrayList<Integer>();
		}
	}

	private void lisaaSolmut(int[] mista, int[] minne) {
		for (int i = 0; i < mista.length; i++) {
			yhteydet[mista[i]].add(minne[i]);
			yhteydet[minne[i]].add(mista[i]);
		}
	}
}
