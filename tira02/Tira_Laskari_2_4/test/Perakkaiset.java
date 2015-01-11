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
public class Perakkaiset {
	
	public Perakkaiset() {
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
	public void arrayOf5() {
		int[] taulukko = {3,3,4,4,4};
		int esiintymiset = 3;
		int tulos = Laskuri.montakoLukua(taulukko, 4);

		assertEquals(esiintymiset, tulos);
	}

	@Test
	public void arrayOf5Binaari() {
		int[] taulukko = {3,3,4,4,4};
		int esiintymiset = 3;
		int tulos = Laskuri.montakoLukuaBinaarilla(taulukko, 4);

		assertEquals(esiintymiset, tulos);
	}
	
	@Test
	public void arrayOf10() {
		int[] taulukko = {1,2,3,3,4,4,4,5,5,6};
		int esiintymiset = 2;
		int tulos = Laskuri.montakoLukua(taulukko, 3);

		assertEquals(esiintymiset, tulos);
	}
		
	@Test
	public void arrayOf10binaari() {
		int[] taulukko = {1,2,3,3,4,4,4,5,5,6};
		int esiintymiset = 2;
		int tulos = Laskuri.montakoLukuaBinaarilla(taulukko, 3);

		assertEquals(esiintymiset, tulos);
	}
	
	@Test
	public void arrayOf20() {
		int[] taulukko = {0, 2, 3, 4, 4, 5, 5, 6, 7, 7, 8, 8, 9, 11, 11, 14, 16, 17, 18, 20};
		int esiintymiset = 1;
		int tulos = Laskuri.montakoLukua(taulukko, 9);

		assertEquals(esiintymiset, tulos);
	}
		
	@Test
	public void arrayOf20binaari() {
		int[] taulukko = {0, 2, 3, 4, 4, 5, 5, 6, 7, 7, 8, 8, 9, 11, 11, 14, 16, 17, 18, 20};
		int esiintymiset = 1;
		int tulos = Laskuri.montakoLukuaBinaarilla(taulukko, 9);

		assertEquals(esiintymiset, tulos);
	}
	
	@Test
	public void arrayOf200() {
		int[] taulukko = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4,
			4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7,
			7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10,
			10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11,
			11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13,
			13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15,
			15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16,
			16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18,
			18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20,
			20, 20};
		int esiintymiset = 16;
		int tulos = Laskuri.montakoLukua(taulukko, 16);

		assertEquals(esiintymiset, tulos);
	}
	
	@Test
	public void arrayOf200binaarilla() {
		int[] taulukko = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4,
			4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7,
			7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10,
			10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11,
			11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13,
			13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15,
			15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16,
			16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18,
			18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20,
			20, 20};
		int esiintymiset = 16;
		int tulos = Laskuri.montakoLukuaBinaarilla(taulukko, 16);

		assertEquals(esiintymiset, tulos);
	}

}
