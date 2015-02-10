
import org.junit.Test;
import static org.junit.Assert.*;

public class BittijonoTest {
	
	@Test(timeout = 1000)
	public void testKauniitJonotSyote4() {
		assertEquals(10, Bittijono.kauniitJonot(4));
	}
	
	@Test(timeout = 1000)
	public void testKauniitJonotSyote7() {
		assertEquals(42, Bittijono.kauniitJonot(7));
	}
	
	@Test(timeout = 1000)
	public void testKauniitJonotSyote22() {
		assertEquals(57314, Bittijono.kauniitJonot(22));
	}
	
	@Test(timeout = 1000)
	public void testKauniitJonotSyote20006() {
		assertEquals(177789049, Bittijono.kauniitJonot(20006));
	}
	
	@Test(timeout = 1000)
	public void testKauniitJonotSyote100000() {
		assertEquals(935236457, Bittijono.kauniitJonot(100000));
	}
	
}
