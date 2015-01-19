
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ElokuvatTest {
	
	public ElokuvatTest() {
	}
	
	@Before
	public void setUp() {
	}

	@Test(timeout = 1000)
	public void testShort() {
		assertEquals(2, Elokuvat.longestDistanceWithoutDoubles(new int[]{1,2,1,1}));
	}

	@Test(timeout = 1000)
	public void testShor2() {
		assertEquals(4, Elokuvat.longestDistanceWithoutDoubles(new int[]{1,2,3,4}));
	}

	@Test(timeout = 1000)
	public void testLonger() {
		assertEquals(7, Elokuvat.longestDistanceWithoutDoubles(new int[]{1,2,3,4,1,2,3,4,5,6,7,1,2,3,4}));
	}

	@Test(timeout = 1000)
	public void exampleCase() {
		assertEquals(4, Elokuvat.longestDistanceWithoutDoubles(new int[]{1,6,1,3,1,4,2,1}));
	}
	
}
