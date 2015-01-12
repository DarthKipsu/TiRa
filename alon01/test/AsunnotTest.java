
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AsunnotTest {
	
	public AsunnotTest() {
	}
	
	@Before
	public void setUp() {
	}

	@Test(timeout = 1000)
	public void testMatchsWithOneApartment() {
		assertEquals(1, Asunnot.dealApartments(new String[]{"60"}, new String[]{"60"}, 0));
		assertEquals(1, Asunnot.dealApartments(new String[]{"50"}, new String[]{"60"}, 10));
	}

	@Test(timeout = 1000)
	public void testMatchsWithTwoApartments() {
		assertEquals(1, Asunnot.dealApartments(new String[]{"50"}, new String[]{"70", "60"}, 10));
		assertEquals(1, Asunnot.dealApartments(new String[]{"50", "40"}, new String[]{"70", "60"}, 10));
		assertEquals(2, Asunnot.dealApartments(new String[]{"50", "60"}, new String[]{"70", "60"}, 10));
	}

	@Test(timeout = 1000)
	public void testMatchsWithThreeApartments() {
		assertEquals(1, Asunnot.dealApartments(new String[]{"70", "70", "70"}, new String[]{"70", "60", "80"}, 5));
		assertEquals(1, Asunnot.dealApartments(new String[]{"90", "55", "50"}, new String[]{"70", "60", "80"}, 5));
		assertEquals(2, Asunnot.dealApartments(new String[]{"70", "65", "60"}, new String[]{"70", "60", "80"}, 5));
	}

	@Test(timeout = 1000)
	public void testMatchsWithBigArray() {
		StringBuilder wishes = new StringBuilder(20000);
		StringBuilder apartments = new StringBuilder(20000);
		for (int i = 1; i <= 10000; i++) {
			wishes.append(100000 - (i + i));
			wishes.append(" ");
			apartments.append(100000 - i);
			apartments.append(" ");
		}
		assertEquals(5000, Asunnot.dealApartments(wishes.toString().split(" "), apartments.toString().split(" "), 0));
	}

	@Test(timeout = 1000)
	public void testReadFromFile() throws Exception {
		InputStream input = getClass().getResourceAsStream("/asunnot1.txt");
		Scanner sc = new Scanner(input);
		String[] first = sc.nextLine().split(" ");
		String[] second = sc.nextLine().split(" ");
		String[] third = sc.nextLine().split(" ");
		assertEquals(11, Asunnot.dealApartments(second, third, Integer.parseInt(first[2])));
	}

	@Test(timeout = 1000)
	public void testReadFromFile2() throws Exception {
		InputStream input = getClass().getResourceAsStream("/asunnot2.txt");
		Scanner sc = new Scanner(input);
		String[] first = sc.nextLine().split(" ");
		String[] second = sc.nextLine().split(" ");
		String[] third = sc.nextLine().split(" ");
		System.out.println(second.length);
		assertEquals(35, Asunnot.dealApartments(second, third, Integer.parseInt(first[2])));
	}
	
	
}
