import java.util.*;

public class Main {
    public static int pieninEtaisyys(int[] luvut) {
		Arrays.sort(luvut);
		int pieninEteaisyys = luvut[1] - luvut[0];
		if (luvut.length == 2) return pieninEteaisyys;

		for (int i=2; i<luvut.length; i++) {
			if (luvut[i] - luvut[i-1] < pieninEteaisyys) {
				pieninEteaisyys = luvut[i] - luvut[i-1];
			} 
		}
		return pieninEteaisyys;
    }
    
    public static void main(String[] args) {
        System.out.println(pieninEtaisyys(new int[] {4, 1, 6, 2}));
        System.out.println(pieninEtaisyys(new int[] {3, 1, 5, 1}));
        System.out.println(pieninEtaisyys(new int[] {2, 60}));
        System.out.println(pieninEtaisyys(new int[] {-1000, 1001, 0}));
    }    
}