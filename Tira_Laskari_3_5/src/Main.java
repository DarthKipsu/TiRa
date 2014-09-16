
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
		long alku = System.currentTimeMillis();
		System.out.println(fibo(40));
		long loppu = System.currentTimeMillis();
		System.out.println("Aikaa kesti: " + (loppu - alku) + " ms");
		alku = System.currentTimeMillis();
		System.out.println(nFibo(4000));
		loppu = System.currentTimeMillis();
		System.out.println("Aikaa kesti: " + (loppu - alku) + " ms");
	}
	
}
