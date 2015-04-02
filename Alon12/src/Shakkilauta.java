
/**
 * Calculates all possible ways to move from top left square of a chessboard to
 * the bottom right square using exactly x steps. You can move vertically
 * or horizontally to the next square and you have to stay inside the board.
 * Input is the number of steps taken, for example:
 * 14
 * outputs 3432, because you have that many ways of traveling from the top left
 * square to the bottom right with exactly 14 steps.
 */
public class Shakkilauta {
	private static long[][] matrix;
	private static long[][] matrix2;
	private static long mod = 1000000007;

	public static void main(String[] args) {
		IO io = new IO();
		long steps = io.nextLong();
		createMatrix();
		matrix = powMatrix(steps);
		io.println(matrix[0][63]);
		io.close();
	}

	private static void createMatrix() {
		matrix = new long[64][64];
		matrix2 = new long[64][64];
		for (int i = 0; i < 64; i++) {
			if ((i + 1) % 8 != 0) matrix[i][i + 1] = 1L;
			if (i % 8 != 0) matrix[i][i - 1] = 1L;
			if (i > 7) matrix[i][i - 8] = 1L;
			if (i < 56) matrix[i][i + 8] = 1L;
			matrix2[i][i] = 1L;
		}
	}
	
	private static long[][] powMatrix(long n) {
		if (n == 0) {
			return matrix2;
		}else if (n % 2 == 0) {
			long[][] newM = powMatrix(n / 2);
			return multiply(newM, newM);
		} else {
			return multiply(powMatrix(n - 1), matrix);
		}
	}

	private static long[][] multiply(long[][] a, long[][] b) {
		long[][] newM = new long[64][64];
		for (int i = 0; i < 64; i++) {
			for (int j = 0; j < 64; j++) {
				for (int k = 0; k < 64; k++) {
					newM[i][j] += a[i][k] * b[k][j];
					newM[i][j] %= mod;
				}
			}
		}
		return newM;
	}	
}
