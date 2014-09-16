
public class Main {

	public static long summa(int n) {
		if (n == 0) return 0;
		return n + summa(n - 1);
	}

	public static void summa2(int summa, int n) {
		if (n == 0) System.out.println(summa);
		else summa2(summa + n, n - 1);
	}

	public static void main(String[] args) {
		System.out.println(summa(12900));
		summa2(0, 9900);
	}
	
}
