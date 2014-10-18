
import java.util.Arrays;




public class Siirto {
	
	private boolean[] kentta;
	private int x;
	private int y;
	private int mato;

	public Siirto(boolean[] kentta, int x, int y, int mato) {
		
		this.kentta = Arrays.copyOf(kentta, kentta.length);
		this.x = x;
		this.y = y;
		this.mato = mato;
	}
	
	public boolean[] kentta() {
		return kentta;
	}
	
	public int[] koordinaatit() {
		return new int[]{x, y};
	}

	public int mato() {
		return mato;
	}
	
}
