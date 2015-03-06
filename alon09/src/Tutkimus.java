
public class Tutkimus {

	private static IO io;
	private static long x;
	private static long mod;
	private static char[] dna;
	private static long[] dnaNum;
	private static long[] prefixes;
	private static long[] powers;

	public static void main(String[] args) {
		io = new IO();
		x = 111;
		mod = 1000000007;
		dna = io.next().toCharArray();
		dnaNum = new long[dna.length + 1];
		prefixes = new long[dna.length + 1];
		powers = new long[dna.length + 1];
		prefixes[0] = 0;
		powers[0] = 1;
		for (int i = 1; i <= dna.length; i++) {
			char letter = dna[i - 1];
			if (letter == 'A') dnaNum[i] = 1;
			else if (letter == 'C') dnaNum[i] = 2;
			else if (letter == 'G') dnaNum[i] = 3;
			else if (letter == 'T') dnaNum[i] = 4;
			prefixes[i] = (x * prefixes[i - 1] + dnaNum[i]) % mod;
			powers[i] = (powers[i - 1] * x) % mod;
		}
		int queries = io.nextInt();
		int similarities = 0;
		for (int i = 0; i < queries; i++) {
			int a = io.nextInt();
			int b = io.nextInt();
			int length = io.nextInt();
			long first = (prefixes[a + length - 1] - prefixes[a - 1] * powers[length]) % mod;
			long second = (prefixes[b + length - 1] - prefixes[b - 1] * powers[length]) % mod;
			if (first < 0) first += mod;
			if (second < 0) second += mod;
			if (first == second) {
				similarities++;
			}
		}
		io.print(similarities);
		io.close();
	}
	
}
