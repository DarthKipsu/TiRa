
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KertotauluTest {
	
	public KertotauluTest() {
	}
	
	@Before
	public void setUp() {
	}

	@Test(timeout = 1000)
	public void middleValueOf1x1Grid() {
		assertEquals(1, Kertotaulu.middleValue(1, 1));
	}

	@Test(timeout = 1000)
	public void middleValueOf3x3Grid() {
		assertEquals(3, Kertotaulu.middleValue(3,3));
	}

	@Test(timeout = 1000)
	public void middleValueOf3x5Grid() {
		assertEquals(5, Kertotaulu.middleValue(3,5));
	}

	@Test(timeout = 1000)
	public void middleValueOf5x3Grid() {
		assertEquals(5, Kertotaulu.middleValue(5,3));
	}

	@Test(timeout = 1000)
	public void middleValueOf5x5Grid() {
		assertEquals(8, Kertotaulu.middleValue(5,5));
	}

	@Test(timeout = 1000)
	public void middleValueOf5x7Grid() {
		assertEquals(10, Kertotaulu.middleValue(5,7));
	}

	@Test(timeout = 1000)
	public void middleValueOf79x53Grid() {
		assertEquals(814, Kertotaulu.middleValue(79,53));
	}

	@Test(timeout = 1000)
	public void middleValueOf63x99Grid() {
		assertEquals(1200, Kertotaulu.middleValue(63,99));
	}

	@Test(timeout = 1000)
	public void middleValueOf9651x8167Grid() {
		assertEquals(14718567, Kertotaulu.middleValue(9651,8167));
	}

	@Test(timeout = 1000)
	public void middleValueOf87305x95655Grid() {
		assertEquals(1559058148, Kertotaulu.middleValue(87305,95655));
	}
	
}
