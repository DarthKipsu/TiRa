
public class Tutkimus {
	
	public static void main(String[] args) {
		IO io = new IO();
		
		int size = io.nextInt();
		String[][] crypt = new String[size][4];
		for (int i = 0; i < size; i++) {
			crypt[i] = io.nextLine().split(" ");
		}
		
		io.println(indexForHighest(crypt));
		io.close();
	}
	
	public static int indexForHighest(String[][] crypt) {
		int start = 0;
		int end = crypt.length - 1;
		int highest = Integer.MIN_VALUE;
		int hI = 0;
		int middle = (start + end) / 2;
		while (start < end) {
			middle = (start + end) / 2;
			int middleValue = getDecrypt(crypt, middle);
			if (middle > start) {
				int prev = getDecrypt(crypt, middle - 1);
				if (prev < middleValue) start = middle + 1;
				else end = middle - 1;
				if (prev > highest) {
					highest = prev;
					hI = middle - 1;
				}
			} else {
				int next = getDecrypt(crypt, middle + 1);
				if (next > middleValue) start = middle + 1;
				else end = middle - 1;
				if (next > highest) {
					highest = next;
					hI = middle + 1;
				}
			}
			if (middleValue > highest) {
				highest = middleValue;
				hI = middle;
			}
		}
		return hI;
	}
	
	private static int getDecrypt(String[][] crypt, int i) {
		return decrypt(
				Integer.parseInt(crypt[i][0]),
				Integer.parseInt(crypt[i][1]),
				Integer.parseInt(crypt[i][2]),
				Integer.parseInt(crypt[i][3]));
	}
	
	private static int decrypt(int a, int b, int c, int d) {
		for(int i = 0; i < 10000; ++i) {
			c *= a; d ^= a; c *= b; a ^= c; d += b; a += c;
			b -= a; b *= c; c ^= d; c *= d; d ^= a; c += b;
			a ^= c; d -= b; c += b; b *= a; d -= a; c -= d;
			a += c; c ^= b; b *= a; a ^= d; c -= d; d -= a;
			c -= a; d -= b; c += d; b -= c; c += b; c += d;
			b *= c; b -= d; b *= a; b ^= c; d -= b; d -= a;
		}

		while(a < 0) a -= 1000000000;
		a %= 1000000;
		return a - 500000;
	}
	
}
