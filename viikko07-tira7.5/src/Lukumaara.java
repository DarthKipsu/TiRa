
public class Lukumaara {
	private int arvo = 0;
	
	public void kasvata() {
		arvo++;
	}
	
	public void vahenna() {
		arvo--;
	}
	
	public void asetaArvo(int arvo) {
		this.arvo = arvo;
	}
	
	public int arvo() {
		return arvo;
	}
}