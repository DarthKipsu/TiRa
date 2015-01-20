
public class Junaetsiva {
	
	public static void main(String[] args) {
		IO io = new IO();
		
		int size = io.nextInt();
		long[] passengers = new long[size + 1];
		passengers[0] = 0;
		for (int i = 1; i <= size; i++) passengers[i] = passengers[i-1] + io.nextLong();
		
		int maxQueries = io.nextInt();
		for (int i = 0; i < maxQueries; i++) {
			int query = io.nextInt();
			if (query == 1) passengers[io.nextInt()] -= io.nextLong();
			else {
				int start = io.nextInt();
				int end = io.nextInt();
				io.println(passengers[end] - passengers[start - 1]);
			}
		}
		io.close();
	}
	
}
