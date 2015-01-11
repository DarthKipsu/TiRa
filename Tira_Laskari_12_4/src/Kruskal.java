
import java.util.PriorityQueue;


public class Kruskal {
	
	private int[][] verkko;
	private boolean[] kaydyt;
	private PriorityQueue<Solmu> pino;
	private long paino;
	private int solmujaYhdistetty;

	public Kruskal(int[][] verkko) {
		this.verkko = verkko;
		paino = 0;
		kaydyt = new boolean[verkko.length];
		pino = new PriorityQueue<>();
		solmujaYhdistetty = 1;
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
		while (!pino.isEmpty() && solmujaYhdistetty < kaydyt.length) {
			Solmu solmu = pino.poll();
			int mista = solmu.getMista();
			int minne = solmu.getMinne();
			if (eiKuuluOmaanMetsaan(mista, minne)) {
				lisaaKaari(solmu, mista, minne);
			}
		}
		return paino;
	}

	private boolean eiKuuluOmaanMetsaan(int mista, int minne) {
		return kayMetsaLapi(mista, mista, minne);
	}
	
	private boolean kayMetsaLapi(int mista, int mista2, int mika) {
		boolean eiKuulu = true;
		for (int i = 1; i < verkko[mista].length; i++) {
			if (i != mista2 && verkko[mista][i] != 0) {
				if (i == mika) return false;
				if (eiKuulu) eiKuulu = kayMetsaLapi(i, mista, mika);
			}
		}
		return eiKuulu;
	}

	private void lisaaKaari(Solmu solmu, int mista, int minne) {
		int paino = solmu.getPaino();
		verkko[mista][minne] = paino;
		verkko[minne][mista] = paino;
		kaydyt[mista] = true;
		kaydyt[minne] = true;
		this.paino += paino;
	}
}
