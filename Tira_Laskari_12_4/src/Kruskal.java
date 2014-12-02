
import java.util.PriorityQueue;


public class Kruskal {
	
	private int[][] verkko;
	private boolean[] kaydyt;
	private PriorityQueue<Solmu> pino;
	private long paino;

	public Kruskal(int[][] verkko) {
		this.verkko = verkko;
		paino = 0;
		kaydyt = new boolean[verkko.length];
		pino = new PriorityQueue<>();
		lisaaKaaretPinoon(verkko);
	}

	private void lisaaKaaretPinoon(int[][] verkko) {
		for (int i = 1; i < verkko.length; i++) {
			for (int j = i; j < verkko.length; j++) {
				if (verkko[i][j] != 0) {
					pino.add(new Solmu(verkko[i][j], i, j));
					verkko[i][j] = 0;
					verkko[j][i] = 0;
				}
			}
		}
	}
	
	public long pieninVirittava() {
		while(!pino.isEmpty()) {
			Solmu solmu = pino.poll();
			int mista = solmu.getMista();
			int minne = solmu.getMinne();
			if (jommassaKummassaEiOleKayty(mista, minne)) {
				lisaaKaari(solmu, mista, minne);
			}
		}
		return paino;
	}

	private boolean jommassaKummassaEiOleKayty(int mista, int minne) {
		return !kaydyt[mista] || !kaydyt[minne];
	}

	private void lisaaKaari(Solmu solmu, int mista, int minne) {
		int paino = solmu.getPaino();
		verkko[mista][minne] = paino;
		verkko[minne][mista] = paino;
		this.paino += paino;
	}
}
