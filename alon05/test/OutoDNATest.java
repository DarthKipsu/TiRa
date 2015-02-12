
import org.junit.Test;
import static org.junit.Assert.*;

public class OutoDNATest {
	
	@Test(timeout = 1000)
	public void testDnaMahdollisuudetParittomat() {
		assertEquals(0, OutoDNA.dnaMahdollisuudet(1));
		assertEquals(0, OutoDNA.dnaMahdollisuudet(3));
		assertEquals(0, OutoDNA.dnaMahdollisuudet(5));
	}
	
	@Test(timeout = 1000)
	public void testDnaMahdollisuudetParilliset() {
		assertEquals(4, OutoDNA.dnaMahdollisuudet(2));
		assertEquals(40, OutoDNA.dnaMahdollisuudet(4));
		assertEquals(544, OutoDNA.dnaMahdollisuudet(6));
		assertEquals(8320, OutoDNA.dnaMahdollisuudet(8));
		assertEquals(131584, OutoDNA.dnaMahdollisuudet(10));
		assertEquals(2099200, OutoDNA.dnaMahdollisuudet(12));
		assertEquals(33562624, OutoDNA.dnaMahdollisuudet(14));
		assertEquals(536903680, OutoDNA.dnaMahdollisuudet(16));
		assertEquals(590065608, OutoDNA.dnaMahdollisuudet(18));
//		assertEquals(8590065664L, OutoDNA.dnaMahdollisuudet(18));
//		assertEquals(137439477760L, OutoDNA.dnaMahdollisuudet(20));
//		assertEquals(2199025352704L, OutoDNA.dnaMahdollisuudet(22));
//		assertEquals(35184380477440L, OutoDNA.dnaMahdollisuudet(24));
//		assertEquals(562949986975744L, OutoDNA.dnaMahdollisuudet(26));
		assertEquals(598261625, OutoDNA.dnaMahdollisuudet(1040));
		assertEquals(626434256, OutoDNA.dnaMahdollisuudet(9992));
	}
	
}
