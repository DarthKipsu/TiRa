
import java.util.Arrays;


public class Kilpailu {
	
	private static IO io;
	private static long[] points;
	private static long[][] scoCnt;
	private static int maxPoints;
	
	public static void main(String[] args) {
		io = new IO();
		createPointArray();
		createOverallScores();
		printScores();
	}
	
	private static void createPointArray() {
		points = new long[io.nextInt()];
		maxPoints = 0;
		for (int i = 0; i < points.length; i++) {
			long taskPoints = io.nextLong();
			points[i] = taskPoints;
			maxPoints += taskPoints;
		}
		Arrays.sort(points);
	}

	protected static long[][] testCreateOverallScores(long[] p, int mP) {
		points = p;
		maxPoints = mP;
		createOverallScores();
		return scoCnt;
	}

	private static void createOverallScores() {
		scoCnt = new long[maxPoints + 1][points.length + 1];
		scoCnt[0][0] = 1;
		for (int i = 0; i <= maxPoints; i++) {
			for (int j = 1; j <= points.length; j++) {
				scoCnt[i][j] += scoCnt[i][j - 1];
				if (i - points[j - 1] < 0) continue;
				scoCnt[i][j] += scoCnt[i - (int)points[j - 1]][j - 1];
			}
		}
	}

	private static void printScores() {
		for (int i = 0; i <= maxPoints; i++) {
			io.println(scoCnt[i][points.length]);
		}
		io.close();
	}

}
