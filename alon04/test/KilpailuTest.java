
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KilpailuTest {
	
	public KilpailuTest() {
	}
	
	@Before
	public void setUp() {
	}

	@Test
	public void exampleCase() {
		long[] points = new long[]{2, 3, 3};
		long[][] scores = new long[9][4];
		scores[0] = new long[]{1, 1, 1, 1};
		scores[1] = new long[] {0, 0, 0, 0};
		scores[2] = new long[] {0, 1, 1, 1};
		scores[3] = new long[] {0, 0, 1, 2};
		scores[4] = new long[] {0, 0, 0, 0};
		scores[5] = new long[] {0, 0, 1, 2};
		scores[6] = new long[] {0, 0, 0, 1};
		scores[7] = new long[] {0, 0, 0, 0};
		scores[8] = new long[] {0, 0, 0, 1};

		long[][] result = Kilpailu.testCreateOverallScores(points, 8);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 4; j++) {
				assertEquals(scores[i][j], result[i][j]);
			}
		}
	}
	
}
