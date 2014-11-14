
public class Luku {
	private int luku;

	public Luku() {
		luku = 1;
	}
	
	public void kasvata() {
		luku++;
	}
	
	public int arvo() {
		return luku;
	}
	
	public void vahenna(int maara) {
		luku -= maara;
	}
}
