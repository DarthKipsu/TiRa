
/**
 * Returns the number of beautiful bit string for a given length.
 * A beautiful bit string is one where there's no more than two same bits in a
 * row.
 * 
 * For example when n = 3: 100, 010, 110, 001, 101, 011.
 */
public class Bittijono {

	public static void main(String[] args) {
		IO io = new IO();
		int pituus = io.nextInt();
		io.println(kauniitJonot(pituus));
		io.close();
	}

	public static long kauniitJonot(int koko) {
		long[] bittijonot = new long[koko + 1];
		for (int i = 0; i < 2; i++) bittijonot[i] = 1;
		for (int i = 2; i <= koko; i++) {
			bittijonot[i] = bittijonot[i - 1] + bittijonot[i - 2];
			bittijonot[i] %= 1000000007;
		}	
		return 2 * bittijonot[koko] % 1000000007;
	}
	
}
