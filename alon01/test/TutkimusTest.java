
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TutkimusTest {
	
	
	@Before
	public void setUp() {
	}

	@Test(timeout = 1000)
	public void returnIndex0WithJustOneOption() {
		String[][] crypt = new String[][]{{"879479", "618085", "843425", "972716"}};
		assertEquals(0, Tutkimus.indexForHighest(crypt));
	}

	@Test(timeout = 1000)
	public void returnIndex1WithTwoOptions() {
		String[][] crypt = new String[][]{
			{"879479", "618085", "843425", "972716"},
			{"232376", "383233", "639282", "763757"}
		};
		assertEquals(1, Tutkimus.indexForHighest(crypt));
	}

	@Test(timeout = 1000)
	public void returnIndex2WithExampleOptions() {
		String[][] crypt = new String[][]{
			{"879479", "618085", "843425", "972716"},
			{"232376", "383233", "639282", "763757"},
			{"252843", "370229", "101963", "278328"},
			{"8702", "979114", "391694", "473238"}
		};
		assertEquals(2, Tutkimus.indexForHighest(crypt));
	}

	@Test(timeout = 1000)
	public void returnCorrectFromFile() {
		InputStream input = getClass().getResourceAsStream("/crypt3.txt");
		Scanner sc = new Scanner(input);
		int size = Integer.parseInt(sc.nextLine());
		String[][] crypt = new String[size][4];
		for (int i = 0; i < size; i++) {
			crypt[i] = sc.nextLine().split(" ");
		}
		assertEquals(1, Tutkimus.indexForHighest(crypt));
	}

	@Test(timeout = 1000)
	public void returnCorrectFromFile2() {
		InputStream input = getClass().getResourceAsStream("/crypt8.txt");
		Scanner sc = new Scanner(input);
		int size = Integer.parseInt(sc.nextLine());
		String[][] crypt = new String[size][4];
		for (int i = 0; i < size; i++) {
			crypt[i] = sc.nextLine().split(" ");
		}
		assertEquals(37207, Tutkimus.indexForHighest(crypt));
	}

	@Test(timeout = 1000)
	public void returnCorrectFromFile3() {
		InputStream input = getClass().getResourceAsStream("/crypt16.txt");
		Scanner sc = new Scanner(input);
		int size = Integer.parseInt(sc.nextLine());
		String[][] crypt = new String[size][4];
		for (int i = 0; i < size; i++) {
			crypt[i] = sc.nextLine().split(" ");
		}
		assertEquals(4442, Tutkimus.indexForHighest(crypt));
	}
	
}
