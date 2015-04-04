
/**
 * Returns the sum of numbers 1 + 2 + ... + 13^n with modulo 10^9 + 7.
 * The only needed input is n, for example:
 * 2
 * will give output of 14365, which is the sum of 1 + 2 + ... + 169.
 */
public class UusiTehtava {
	private static long mod = 1000000007L;

	public static void main(String[] args) {
		IO io = new IO();
		long end = pot(13L, io.nextLong());
		io.println(((end * (end + 1)) / 2L) % mod);
		io.close();
	}

	private static long pot(long x, long n) {
		if (n == 0) return 1L;
		if (n % 2 == 1) return (pot(x, n - 1) * x) % mod;
		long t = pot(x, n/2);
		return (t*t) % mod;
	}
	
}
