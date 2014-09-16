
public class Main {

	public static long potenssi(long x, int n) {
		if (n==0) return 1;
		else return x * potenssi(x, n-1);
	}

	public static long potenssi2(long x, int n) {
		if (n==0) return 1;
		else if (n==1) return x;
		else {
			long potenssi = potenssi2(x, n/2);
			if (n % 2 == 0) {
				return potenssi * potenssi;
			} else {
				return potenssi * potenssi * x;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(potenssi(2, 9));
		System.out.println(potenssi2(2, 9));
	}
	
}
