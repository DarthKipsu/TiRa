
public class Solmu implements Comparable<Solmu> {
	private long etaisyys;
	private int tunnus;

	public Solmu(Long etaisyys, int tunnus) {
		this.etaisyys = etaisyys;
		this.tunnus = tunnus;
	}

	public long getEtaisyys() {
		return etaisyys;
	}

	public int getTunnus() {
		return tunnus;
	}

	public int compareTo(Solmu verrattava) {
		if (etaisyys < verrattava.etaisyys) return -1;
		if (etaisyys > verrattava.etaisyys) return 1;
		return 0;
	}
	
}
