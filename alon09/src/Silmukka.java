
import java.util.Set;
import java.util.TreeSet;

public class Silmukka {
	private static IO io;
	private static long x;
	private static long mod;
	private static Set<Long> prevMemories;

	public static void main(String[] args) {
		io = new IO();
		x = 673717;
		mod = 903983939561L;
		int queries = io.nextInt();
		prevMemories = new TreeSet<>();
		long[] memory = new long[65538];
		long[] exp = new long[65538];
		exp[0] = 1;
		for (int i = 1; i < 65538; i++) exp[i] = (exp[i - 1] * x) % mod; 
		long prevHash = 0;
		
		for (int i = 1; i <= queries; i++) {
			int a = io.nextInt();
			int b = io.nextInt();
			long multi = (exp[a] * b) % mod;
			prevHash -= memory[a];
			if (prevHash < 0) prevHash += mod;
			memory[a] = multi;
			prevHash = (prevHash + memory[a]) % mod;
			if (prevMemories.contains(prevHash)) {
				io.println(i);
				io.close();
				return;
			} else prevMemories.add(prevHash);
		}
		io.println("YAY");
		io.close();
	}
	
}
