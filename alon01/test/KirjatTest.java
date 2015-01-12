
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KirjatTest {
	
	@Before
	public void setUp() {
	}

	@Test(timeout = 1000)
	public void returnsReadTimeDoubledForSingleBook() {
		assertEquals(4, Kirjat.readingTime(new String[]{"2"}));
	}

	@Test(timeout = 1000)
	public void returnsReadTimeForTwoSameLengthBooks() {
		assertEquals(4, Kirjat.readingTime(new String[]{"2", "2"}));
	}

	@Test(timeout = 1000)
	public void returnsReadTimeForEvenAmountOfSameLengthBooks() {
		assertEquals(12, Kirjat.readingTime(new String[]{"2", "2", "4", "4"}));
	}

	@Test(timeout = 1000)
	public void returnsReadTimeForExampleBooks() {
		assertEquals(17, Kirjat.readingTime(new String[]{"2", "4", "3", "5", "3"}));
	}

	@Test(timeout = 1000)
	public void returnsReadTimeForTest5Books() {
		assertEquals(24, Kirjat.readingTime(new String[]{"6", "1", "2", "12", "1"}));
	}
	
	@Test(timeout = 1000)
	public void returnsReadTimeForTest4Books() {
		assertEquals(5000000000L, Kirjat.readingTime(new String[]{"1000000000", "1000000000",
			"1000000000", "1000000000", "1000000000"}));
	}
	
}
