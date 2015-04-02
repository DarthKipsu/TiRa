
/**
 * Calculates the possibility of ending up to each city starting from city 1 and
 * traveling x amount of loops through the cities. All cities have a certain
 * percent probability to go to the next city or stay where you where. The input
 * first takes the number of cities involved, then how many trips is traveled,
 * and finally the probability to travel from each city to the other cities as
 * doubles. For example:
 * 3 5
 * 2 2 0.5 3 0.3
 * 0
 * 1 1 0.1
 * Which will produce the possibility to end up in each of the tree cities after
 * traveling 5 times as:
 * 0,0382700000
 * 0,6791000000
 * 0,2826300000 
 */
public class Lentomatka {
	private static IO io;
	private static int n;
	private static long mod = 1000000007;
	private static double[][] matrix;
	private static double[][] matrix2;

	public static void main(String[] args) {
		io = new IO();
		n = io.nextInt();
		int flights = io.nextInt();
		createMatrix();
		matrix = powMatrix(flights);
		printResults();
		io.close();
	}

	private static void createMatrix() {
		matrix = new double[n + 1][n + 1];
		matrix2 = new double[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			int queries = io.nextInt();
			double stay = 1.0;
			for (int j = 0; j < queries; j++) {
				int to = io.nextInt();
				double prob = io.nextDouble();
				stay -= prob;
				matrix[i][to] = prob;
			}
			matrix[i][i] = stay;
			matrix2[i][i] = 1.0;
		}
	}

	private static double[][] powMatrix(long z) {
		if (z == 0) {
			return matrix2;
		}else if (z % 2 == 0) {
			double[][] newM = powMatrix(z / 2);
			return multiply(newM, newM);
		} else {
			return multiply(powMatrix(z - 1), matrix);
		}
	}

	private static double[][] multiply(double[][] a, double[][] b) {
		double[][] newM = new double[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					newM[i][j] += a[i][k] * b[k][j];
					newM[i][j] %= mod;
				}
			}
		}
		return newM;
	}

	private static void printResults() {
		for (int i = 1; i <= n; i++) {
			io.println(String.format("%.10f", matrix[1][i]));
		}
	}

}
