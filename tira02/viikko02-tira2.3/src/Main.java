import java.util.*;

public class Main {
    public static long pieninKasvatus(int[] luvut) {
		Arrays.sort(luvut);
		int suurinVarattu = luvut[0];
		long kasvatettu = 0;

		for (int i=1; i<luvut.length; i++) {
			if (luvut[i] <= suurinVarattu) {
				suurinVarattu++;
				kasvatettu += suurinVarattu - luvut[i];
			} else {
				suurinVarattu = luvut[i];
			}
		}
		return kasvatettu;
    }
    
    public static void main(String[] args) {
        System.out.println(pieninKasvatus(new int[] {2, 3, 2, 3}));
        System.out.println(pieninKasvatus(new int[] {2, 2, 2, 2}));
        System.out.println(pieninKasvatus(new int[] {2, 4, 1, 7}));
        System.out.println(pieninKasvatus(new int[] {3, 1, 2, 1, 1}));
    }    
}