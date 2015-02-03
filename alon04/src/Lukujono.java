
import java.util.PriorityQueue;


public class Lukujono {

	private static IO io;

	public static void main(String[] args) {
		io = new IO();
		int n = io.nextInt();
		io.println(nthUolevinacci(n));
		io.close();
	}

	public static int nthUolevinacci(int n) {
		int[] luvut = new int[n / 2 + 1];
		luvut[1] = 1;
		luvut[2] = 1;
		luvut[3] = 2;
		PriorityQueue<Integer> tarvittavatLuvut = new PriorityQueue<>();
		int nimittaja = 2;
		while (nimittaja <= n / 2) {
			tarvittavatLuvut.add(n / nimittaja);
			nimittaja++;
		}
		n = n - tarvittavatLuvut.size() - 1;
		while (!tarvittavatLuvut.isEmpty()) {
			int luku = tarvittavatLuvut.poll();
			if (luvut[luku] == 0) {
				int nim2 = 2;
				int n2 = (luku + 1) / 2;
				while (nim2 <= luku / 2) {
					n2 += luvut[luku / nim2];
					nim2++;
				}
				luvut[luku] = n2;
			}
			n += luvut[luku];
		}
		return n;
	}
	
}
