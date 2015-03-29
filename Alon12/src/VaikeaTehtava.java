
/**
 * Calculate powers efficiently with dynamic programming. Input is several
 * calculations, for example: 
 * 3
 * 2 4
 * 1 5
 * 5 2 
 * Will produce solutions to all the calculations:
 * 16 
 * 1 
 * 25
 */
public class VaikeaTehtava {

	private static IO io;
	private static long mod = 1000000007L;

	public static void main(String[] args) {
		io = new IO();
		int queries = io.nextInt();
		for (int i = 0; i < queries; i++) {
			long a = io.nextLong();
			long b = io.nextLong();
			io.println(pow(a, b));
		}
		io.close();
	}

	private static long pow(long a, long b) {
		if (b == 0) return 1;
		if (b == 1) return a;
		if (b == 2) return (a * a) % mod;
		if (b % 2 == 0) return pow(pow(a, b / 2) % mod, 2) % mod;
		return (a * pow(a, b - 1)) % mod;
	}
	
}
