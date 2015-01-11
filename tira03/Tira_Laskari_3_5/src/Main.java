
public class Main {

	public static long fibo(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		else return fibo(n - 2) + fibo(n - 1);
	}

	public static long nFibo(int n) {
		if(n == 0) return 0;
		return nFibo(n, 0, 1);
	}

	public static long nFibo(int n, long a, long b) {
		if (n == 1) {
			return b;
		} else {
			return nFibo(n-1, b, a+b);
		}
	}

	public static void main(String[] args) {
		long alku;
		long loppu;
		alku = System.nanoTime();
		System.out.println(nFibo(92));
		loppu = System.nanoTime();
		System.out.println(" Aikaa kesti nFibon 92 luvulla: " + ((loppu - alku)/1000000.0) + " ms");
		alku = System.currentTimeMillis();
		System.out.println(fibo(40));
		loppu = System.currentTimeMillis();
		System.out.println(" Aikaa kesti fibon 40 luvulla: " + (loppu - alku) + " ms");
	}
	
}
