
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LukujonoTest {
	
	public LukujonoTest() {
	}
	
	@Before
	public void setUp() {
	}

	@Test
	public void testMain() {
	}

	//@Test
	public void testNthUolevinacci10() {
		assertEquals(13, Lukujono.nthUolevinacci(10));
	}
	
	//@Test
	public void testNthUolevinacci15() {
		assertEquals(25, Lukujono.nthUolevinacci(15));
	}
	
	@Test
	public void testNthUolevinacci20() {
		assertEquals(42, Lukujono.nthUolevinacci(20));
	}
}
