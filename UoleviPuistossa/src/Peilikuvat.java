
import java.util.*;

public class Peilikuvat {
	
	private HashMap<String, Long> alut;
	private HashMap<String, Long> loput;
	private int[] varattu;
	private int alkuMato;
	private int loppuMato;
	private int reuna;
	private ArrayDeque<int[]> pino;
	
	public Peilikuvat(int sivu) {
		alut = new HashMap<String, Long>();
		loput = new HashMap<String, Long>();
		varattu = new int[sivu * sivu];
		varattu[0 + 0 * (reuna + 1)] = 1;
		alkuMato = (int) Math.ceil((double) sivu * sivu/ 2);
		loppuMato = sivu * sivu - alkuMato + 1;
		reuna = sivu - 1;
		pino = new ArrayDeque<int[]>();
	}
	
	public long reittienMaara() {
		pino.add(new int[]{0,0,1});		// x, y, madon pituus
		laskeAlutJaLoput();
//		System.out.println("alkumato: " + alkuMato);
//		System.out.println("loppumato: " + loppuMato);
		return summaaReitit();
	}
	
	private void laskeAlutJaLoput() {
		
		while (!pino.isEmpty()) {
			int[] sijainti = pino.poll();
			int x = sijainti[0];
			int y = sijainti[1];
			int mato = sijainti[2];
			
			System.out.println(alut);
			System.out.println(Arrays.toString(varattu));
			
			if (mato == alkuMato) {
				String alku = x + " " + y;
				paivitaMappia(alku, alut);
				if (mato == loppuMato) {
					paivitaMappia(alku, loput);
				} else {
					if (alas(reuna - x, y)) paivitaMappia((reuna - x + 1) + " " + y, loput);
					if (ylos(reuna - x, y)) paivitaMappia((reuna - x - 1) + " " + y, loput);
					if (oikealle(reuna - x, y)) paivitaMappia((reuna - x) + " " + (y + 1), loput);
					if (vasemmalle(reuna - x, y)) paivitaMappia((reuna - x) + " " + (y - 1), loput);
				}
			} else {
				if (alas(x, y)) pino.add(new int[]{x + 1, y, mato + 1});
				if (ylos(x,y)) pino.add(new int[]{x - 1, y, mato + 1});
				if (oikealle(x, y)) pino.add(new int[]{x, y + 1, mato + 1});
				if (vasemmalle(x, y)) pino.add(new int[]{x, y - 1, mato + 1});
			}
		}
	}

	private void paivitaMappia(String alku, HashMap<String, Long> map) {
		if (!map.containsKey(alku)) {
			map.put(alku, 1L);
		} else {
			map.replace(alku, map.get(alku) + 1);
		}
	}
		
		
//		if (varattu[x][y]) return;
//		varattu[x][y] = true;
		
//		System.out.println("alut:");
//		tulosta(alut);
//		System.out.println("loput:");
//		tulosta(loput);
		
//		if (mato == alkuMato) {
//			alut[x][y] = alut[x][y] + 1;
//			if (alas(reuna - x, y)) loput[reuna - x + 1][y] = loput[reuna - x + 1][y] + 1;
//			if (ylos(reuna - x, y)) loput[reuna - x - 1][y] = loput[reuna - x - 1][y] + 1;
//			if (oikealle(reuna - x, y)) loput[reuna - x][y + 1] = loput[reuna - x][y + 1] + 1;
//			if (vasemmalle(reuna - x, y)) loput[reuna - x][y - 1] = loput[reuna - x][y - 1] + 1;
//		} else {
//			if (alas(x, y)) laskeAlutJaLoput(x + 1, y, mato + 1);
//			if (ylos(x,y)) laskeAlutJaLoput(x - 1, y, mato + 1);
//			if (oikealle(x, y)) laskeAlutJaLoput(x, y + 1, mato + 1);
//			if (vasemmalle(x, y)) laskeAlutJaLoput(x, y - 1, mato + 1);
//		}
//		varattu[x][y] = false;

	
	private boolean alas(int x, int y) {
		if (x + 1 == reuna && y == 0 || x == reuna - 1) return false;
		return x < reuna;
	}
	
	private boolean ylos(int x, int y) {
		return x > 0;
	}
	
	private boolean oikealle(int x, int y) {
		return y < reuna;
	}
	
	private boolean vasemmalle(int x, int y) {
		if (x == reuna && y - 1 == 0) return false;
		return y > 0;
	}
	
	private long summaaReitit() {
		long reittienMaara = 0;
//		for (int i=0; i<=reuna; i++) {
//			for (int j=0; j<=reuna; j++) {
//				if (alut[i][j] > 0 && loput[i][j] > 0) {
//					reittienMaara += alut[i][j] * loput[i][j];
//				}
//			}
//		}
		return reittienMaara;
	}
	
	private void tulosta(long[][] taulukko) {
		for (int i=0; i<=reuna; i++) {
			for (int j=0; j<=reuna; j++) {
				System.out.print(taulukko[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
