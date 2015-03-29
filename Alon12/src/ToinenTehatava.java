
import java.util.Arrays;

/**
 * Prints the sum of n first Fibonacci numbers using matrices. Can calculate
 * huge numbers, like the sum of 54776347515270231 first fibo's.
 * 
 * Takes the amount of Fibonacci numbers to count, for example:
 * 5
 * Will produce 12, which is the sum of first 5 fibo numbers,
 */
public class ToinenTehatava {

	private static IO io;
	private static long mod = 1000000007;
	private static long[][] matrix;

	public static void main(String[] args) {
		io = new IO();
		matrix = new long[2][2];
		matrix[0][0] = 0L;
		matrix[1][0] = 1L;
		matrix[0][1] = 1L;
		matrix[1][1] = 1L;
		powMatrix(io.nextLong()+ 2);
		io.println(matrix[0][1] - 1);
		io.close();
	}

	private static void powMatrix(long n) {
		if (n < 2) return;
		if (n % 2 == 0) {
			powMatrix(n / 2);
			squareMatrix();
		} else {
			long c = matrix[0][0];
			long d = matrix[1][0];
			long v = matrix[0][1];
			long w = matrix[1][1];
			powMatrix(n-1);
			multiplyMatrix(c, d, v, w);
		}
	}

	private static void squareMatrix() {
		long a = matrix[0][0];
		long b = matrix[1][0];
		long x = matrix[0][1];
		long y = matrix[1][1];
		matrix[0][0] = (a*a + x*b) % mod;
		matrix[1][0] = (b*a + y*b) % mod;
		matrix[0][1] = (a*x + x*y) % mod;
		matrix[1][1] = (b*x + y*y) % mod;
	}

	private static void multiplyMatrix(long c, long d, long v, long w) {
		long a = matrix[0][0];
		long b = matrix[1][0];
		long x = matrix[0][1];
		long y = matrix[1][1];
		matrix[0][0] = (a*c + x*d) % mod;
		matrix[1][0] = (b*c + y*d) % mod;
		matrix[0][1] = (a*v + x*w) % mod;
		matrix[1][1] = (b*v + y*w) % mod;
	}
	
	private static void printMatrix() {
		io.println(Arrays.toString(matrix[0]));
		io.println(Arrays.toString(matrix[1]));
	}

}
