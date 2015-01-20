
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaantiekiitajaTest {
	
	public MaantiekiitajaTest() {
	}
	
	@Before
	public void setUp() {
	}

	@Test(timeout = 1000)
	public void exampleCase() {
		TreeMap<Long, long[]> kivet = new TreeMap<>();
		kivet.put(100L, new long[]{1, 300, -500});
		kivet.put(400L, new long[]{2, -200, -300});
		kivet.put(500L, new long[]{3, 100, 200});
		long[] tormatyt = Maantiekiitaja.tulostaKivet(kivet, 5);
		Assert.assertEquals(1, tormatyt[0]);
		Assert.assertEquals(3, tormatyt[1]);
		Assert.assertEquals(3, tormatyt[2]);
		Assert.assertEquals(3, tormatyt[3]);
	}

	@Test(timeout = 1000)
	public void testCase1() {
		TreeMap<Long, long[]> kivet = new TreeMap<>();
		kivet.put(791161483L, new long[]{1, -734358277, -547456818});
		kivet.put(832261963L, new long[]{2, 381464288, -123693306});
		kivet.put(689590712L, new long[]{3, -372493215, 779407272});
		kivet.put(245851533L, new long[]{4, -823697498, -435840986});
		long[] tormatyt = Maantiekiitaja.tulostaKivet(kivet, 8);
		Assert.assertEquals(4, tormatyt[0]);
		Assert.assertEquals(3, tormatyt[1]);
		Assert.assertEquals(3, tormatyt[2]);
		Assert.assertEquals(3, tormatyt[3]);
		Assert.assertEquals(3, tormatyt[4]);
		Assert.assertEquals(1, tormatyt[5]);
		Assert.assertEquals(1, tormatyt[6]);
		Assert.assertEquals(1, tormatyt[7]);
	}
	
}
