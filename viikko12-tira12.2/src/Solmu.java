
public class Solmu implements Comparable<Solmu> {
	private int paino;
	private int mista;
	private int minne;

	public Solmu(int paino, int mista, int minne) {
		this.paino = paino;
		this.mista = mista;
		this.minne = minne;
	}

	public int getPaino() {
		return paino;
	}

	public int getMista() {
		return mista;
	}

	public int getMinne() {
		return minne;
	}

	public int compareTo(Solmu verrattava) {
		if (paino < verrattava.paino) return -1;
		if (paino > verrattava.paino) return 1;
		return 0;
	}
	
}
