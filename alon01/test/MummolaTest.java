
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MummolaTest {
	
	public MummolaTest() {
	}
	
	@Before
	public void setUp() {
	}

	@Test
	public void returnsCorrectAmountWhenDistanceIs1() {
		assertEquals("0.00000000", Mummola.getGasFor(1));
	}

	@Test
	public void returnsCorrectAmountWhenDistanceIs200() {
		assertEquals("5.28675430", Mummola.getGasFor(200));
	}

	@Test
	public void returnsCorrectAmountWhenDistanceIs400() {
		assertEquals("5.98532953", Mummola.getGasFor(400));
	}

	@Test
	public void returnsCorrectAmountWhenDistanceIs123_45() {
		assertEquals("4.79793354", Mummola.getGasFor(123.45));
	}

	@Test
	public void returnsCorrectAmountWhenDistanceIs382_9940176537() {
		assertEquals("5.94163458", Mummola.getGasFor(382.9940176537));
	}
	
}
