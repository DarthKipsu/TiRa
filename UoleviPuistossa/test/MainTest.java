
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {
	
	public MainTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testaaN1() {
		long reittienMaara = Main.reittienMaara(1);
		System.out.println(reittienMaara);
		long tulos = 1;
		
		assertEquals(tulos, reittienMaara);
	}
	
	@Test
	public void testaaN2() {
		long reittienMaara = Main.reittienMaara(2);
		System.out.println(reittienMaara);
		long tulos = 1;
		
		assertEquals(tulos, reittienMaara);
	}
	
	@Test
	public void testaaN3() {
		long reittienMaara = Main.reittienMaara(3);
		System.out.println(reittienMaara);
		long tulos = 2;
		
		assertEquals(tulos, reittienMaara);
	}
	
	@Test
	public void testaaN4() {
		long reittienMaara = Main.reittienMaara(4);
		System.out.println(reittienMaara);
		long tulos = 8;
		
		assertEquals(tulos, reittienMaara);
	}
	
	@Test
	public void testaaN5() {
		long reittienMaara = Main.reittienMaara(5);
		System.out.println(reittienMaara);
		long tulos = 86;
		
		assertEquals(tulos, reittienMaara);
	}
	
	@Test
	public void testaaN6() {
		long reittienMaara = Main.reittienMaara(6);
		System.out.println(reittienMaara);
		long tulos = 1770;
		
		assertEquals(tulos, reittienMaara);
	}
	
}
