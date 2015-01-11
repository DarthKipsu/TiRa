import java.util.*;

public class Main {
    public static int ketjumaara(int n) {
		return 4 * (int)Math.pow(3, n-1);
    }

	public static int maaraRekursiivisesti(int n) {
		if (n == 0) return 1;
		else if (n == 1) return 4 * maaraRekursiivisesti(n-1);
		else return 3 * maaraRekursiivisesti(n-1);
	}
    
    public static void main(String[] args) {
        System.out.println(ketjumaara(3));
        System.out.println(maaraRekursiivisesti(3));
        System.out.println(ketjumaara(1));
		System.out.println(maaraRekursiivisesti(1));
        System.out.println(ketjumaara(2));
		System.out.println(maaraRekursiivisesti(2));
		long alku = System.nanoTime();
        System.out.println(ketjumaara(5));
		long keski = System.nanoTime();
		System.out.println(maaraRekursiivisesti(5));
		long loppu = System.nanoTime();
		System.out.println("Aikaa ekaan: " + ((keski-alku)/1000000.0) + " ms");
		System.out.println("Aikaa tokaan: " + ((loppu-keski)/1000000.0) + " ms");
    }    
}