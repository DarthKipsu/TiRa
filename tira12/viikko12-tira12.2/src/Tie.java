
public class Tie implements Comparable<Tie> {
	
	public int paino;
	public int a;
	public int b;

	public Tie(int paino, int a, int b) {
		this.paino = paino;
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Tie o) {
		if (paino < o.paino) return -1;
		if (paino > o.paino) return 1;
		else return 0;
	}
	
}
