
/**
 * Takes the size of a multiplication table and returns the middle value of all
 * the tables products placed in order.
 */
public class Kertotaulu {
	
	public static void main(String[] args) {
		IO io = new IO();
		int height = io.nextInt();
		int width = io.nextInt();
		io.println(middleValue(height, width));
		io.close();
	}
	
	public static long middleValue(long height, long width) {
		long start = 1;
		long end = width * height;
		long search = (start + end) / 2;
		int divisor = (int)Math.min(height, width);
		long maxPrev = Math.max(height, width);
		while (start <= end) {
			long middle = (start + end) / 2;
			long prevNumbers = 0;
			for (int i = divisor; i > 0; i--) {
				long quotient = (middle - 1) / i;
				prevNumbers += quotient < maxPrev ? quotient : maxPrev;
			}
			if (prevNumbers == search) return middle - 1;
			if (prevNumbers > search) end = middle - 1;
			else if (prevNumbers < search) start = middle + 1;
		}
		return end;
	}
	
}
