
public class Raide implements Comparable<Raide> {
	
	public int paino;
	public int a;
	public int b;

	public Raide(int paino, int a, int b) {
		this.paino = paino;
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Raide o) {
		if (paino < o.paino) return -1;
		if (paino > o.paino) return 1;
		else return 0;
	}
	
}
