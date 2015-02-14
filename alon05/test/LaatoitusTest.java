
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaatoitusTest {
	
	public LaatoitusTest() {
	}
	
	public void setUp(int leveys, int korkeus) {
		Laatoitus.korkeus = korkeus;
		Laatoitus.leveys = leveys;
		Laatoitus.riveja = (int)Math.pow(2, leveys);
		Laatoitus.validitRivit = new HashSet<>();
		Laatoitus.riviVaihtoehdot = new ArrayList[Laatoitus.riveja];
		Laatoitus.vaihtoehdot = 0;
		Laatoitus.luoRivit(0, 0);
		Laatoitus.laskeRivivaihtoehdot();
		Laatoitus.etsiVaihtoehdot(0, 0);
	}

	@Test(timeout = 1000)
	public void testLuoRivit() {
		setUp(4, 3);
		assertEquals(5, Laatoitus.validitRivit.size());
		setUp(5, 4);
		assertEquals(8, Laatoitus.validitRivit.size());
	}

	@Test(timeout = 1000)
	public void testEtsiVaihtoehdot2x5() {
		setUp(2, 5);
		assertEquals(8, Laatoitus.vaihtoehdot);
	}
	
	@Test(timeout = 1000)
	public void testEtsiVaihtoehdot4x3() {
		setUp(4, 3);
		assertEquals(11, Laatoitus.vaihtoehdot);
	}
	
	@Test(timeout = 1000)
	public void testEtsiVaihtoehdot5x4() {
		setUp(5, 4);
		assertEquals(95, Laatoitus.vaihtoehdot);
	}

	@Test(timeout = 1000)
	public void testEtsiVaihtoehdot1x1() {
		setUp(1, 1);
		assertEquals(0, Laatoitus.vaihtoehdot);
	}
		
	@Test(timeout = 1000)
	public void testEtsiVaihtoehdot8x6() {
		setUp(8, 6);
		assertEquals(167089, Laatoitus.vaihtoehdot);
	}
		
	@Test(timeout = 1000)
	public void testEtsiVaihtoehdot7x8() {
		setUp(7, 8);
		assertEquals(1292697, Laatoitus.vaihtoehdot);
	}
		
	@Test(timeout = 1000)
	public void testEtsiVaihtoehdot11x6() {
		setUp(11, 6);
		assertEquals(21001799, Laatoitus.vaihtoehdot);
	}
	
}
