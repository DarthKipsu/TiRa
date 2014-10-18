/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kipsu
 */
public class LaskePinollaTest {
	
	public LaskePinollaTest() {
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

//	@Test
//	public void testaaN1() {
//		long reittienMaara = LaskePinolla.reittienMaara(1);
//		System.out.println(reittienMaara);
//		long tulos = 1;
//		
//		assertEquals(tulos, reittienMaara);
//	}
//	
//	@Test
//	public void testaaN2() {
//		long reittienMaara = LaskePinolla.reittienMaara(2);
//		System.out.println(reittienMaara);
//		long tulos = 1;
//		
//		assertEquals(tulos, reittienMaara);
//	}
	
	@Test
	public void testaaN3() {
		LaskePinolla pino = new LaskePinolla();
		long reittienMaara = pino.reittienMaara(3, 2);
		System.out.println(reittienMaara);
		long tulos = 2;
		
		assertEquals(tulos, reittienMaara);
	}
	
	@Test
	public void testaaN4() {
		LaskePinolla pino = new LaskePinolla();
		long reittienMaara = pino.reittienMaara(4, 2);
		System.out.println(reittienMaara);
		long tulos = 8;
		
		assertEquals(tulos, reittienMaara);
	}
	
//	@Test
//	public void testaaN5() {
//		long reittienMaara = LaskePinolla.reittienMaara(5);
//		System.out.println(reittienMaara);
//		long tulos = 86;
//		
//		assertEquals(tulos, reittienMaara);
//	}
//	
//	@Test
//	public void testaaN6() {
//		long reittienMaara = LaskePinolla.reittienMaara(6);
//		System.out.println(reittienMaara);
//		long tulos = 1770;
//		
//		assertEquals(tulos, reittienMaara);
//	}
	
}
