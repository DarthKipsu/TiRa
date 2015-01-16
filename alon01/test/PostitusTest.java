
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PostitusTest {
	
	@Before
	public void setUp() {
	}

	@Test(timeout = 1000)
	public void testReadFromFile6() throws Exception {
		InputStream input = getClass().getResourceAsStream("/postitus3.txt");
		Scanner sc = new Scanner(input);
		sc.nextLine();
		String[] residents = sc.nextLine().split(" ");
		String[] wrongLetters = sc.nextLine().split(" ");
		assertEquals(0, Postitus.rounds(residents, wrongLetters));
	}

	@Test(timeout = 1000)
	public void testReadFromFile7() throws Exception {
		InputStream input = getClass().getResourceAsStream("/postitus7.txt");
		Scanner sc = new Scanner(input);
		sc.nextLine();
		String[] residents = sc.nextLine().split(" ");
		String[] wrongLetters = sc.nextLine().split(" ");
		assertEquals(1, Postitus.rounds(residents, wrongLetters));
	}

	@Test(timeout = 1000)
	public void testReadFromFile8() throws Exception {
		InputStream input = getClass().getResourceAsStream("/postitus8.txt");
		Scanner sc = new Scanner(input);
		sc.nextLine();
		String[] residents = sc.nextLine().split(" ");
		String[] wrongLetters = sc.nextLine().split(" ");
		assertEquals(2, Postitus.rounds(residents, wrongLetters));
	}
	
}
