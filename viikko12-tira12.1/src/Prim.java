
import java.util.PriorityQueue;


public class Prim {
	
	private int[][] verkko;
	private boolean[] kaydyt;
	private static PriorityQueue<Solmu> keko;
	private long paino;

	public Prim(int[][] verkko) {
		this.verkko = verkko;
		kaydyt = new boolean[verkko.length];
		kaydyt[1] = true;
		paino = 0l;
		alustaKeko(verkko);
	}

	private void alustaKeko(int[][] verkko) {
		keko = new PriorityQueue<Solmu>();
		for (int i = 1; i < verkko[1].length; i++) {
			if (verkko[1][i] != 0) {
				keko.add(new Solmu(verkko[1][i], 1, i));
			}
		}
	}
	
	public long pieninVirittava() {
		while(!keko.isEmpty()) {
			Solmu solmu = keko.poll();
			int mista = solmu.getMista();
			int minne = solmu.getMinne();
			if (taallaOnJoKayty(minne)) {
				PoistaKaari(mista, minne);
			} else {
				sailytaKaariJaLisaaKohdesolmunKaaret(minne, solmu);
			}
		}
		return paino;
	}

	private boolean taallaOnJoKayty(int minne) {
		return kaydyt[minne];
	}

	private void PoistaKaari(int mista, int minne) {
		verkko[mista][minne] = 0;
		verkko[minne][mista] = 0;
	}

	private void sailytaKaariJaLisaaKohdesolmunKaaret(int minne, Solmu solmu) {
		merkkaaKaari(minne, solmu);
		lisaaKohteenKaaret(minne);
	}

	private void merkkaaKaari(int minne, Solmu solmu) {
		kaydyt[minne] = true;
		paino += solmu.getPaino();
	}

	private void lisaaKohteenKaaret(int minne) {
		for (int i = 1; i < verkko[minne].length; i++) {
			if (verkko[minne][i] != 0 && !kaydyt[i]) {
				keko.add(new Solmu(verkko[minne][i], minne, i));
			}
		}
	}
	
}
