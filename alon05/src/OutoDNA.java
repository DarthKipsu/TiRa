
import java.math.BigInteger;


public class OutoDNA {
	
	public static void main(String[] args) {
		IO io = new IO();
		int pituus = io.nextInt();
		io.println(dnaMahdollisuudet(pituus));
		io.close();
	}
	
	public static long dnaMahdollisuudet(int pituus) {
		if (pituus % 2 != 0) return 0;
		if (pituus == 2) return 4;
		if (pituus < 30) return ((2L << (((pituus - 2) / 2) * 4)) ^ (4L << (pituus - 3))) % 1000000007;
		StringBuilder sb = new StringBuilder();
		sb.append('1');
		for (int i = 0; i < pituus - 3; i++) sb.append('0');
		sb.append('1');
		for (int i = 0; i < pituus - 1; i++) sb.append('0');
		BigInteger bi = new BigInteger(sb.toString(), 2);
		return bi.mod(BigInteger.valueOf(1000000007)).longValue();
	}
	
}
