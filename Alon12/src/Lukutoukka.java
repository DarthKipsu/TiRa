
public class Lukutoukka {
	private static long mod = 1000000007;

	public static void main(String[] args) {
		IO io = new IO();
		int n = io.nextInt() - 1;
		int k = io.nextInt();
		io.println(nCr(n + k, n));
		io.close();
	}

	private static long nCr(int n, int k) {
		long[][] d = new long[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			d[i][0] = 1;
			for (int j = 1; j <= i; j++) {
				d[i][j] = d[i - 1][j - 1] + d[i - 1][j];
				d[i][j] %= mod;
			}
		}
		return d[n][n - k];
	}
	
}
