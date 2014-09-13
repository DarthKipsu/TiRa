import java.util.*;

public class Main {
    public static long pieninMuutos(int[] luvut) {
		Arrays.sort(luvut);
		
		int mediaani = luvut[luvut.length/2];
		long kokonaisMuutos = 0;

		for (int i=0; i<luvut.length; i++) {
			kokonaisMuutos += Math.abs(luvut[i] - mediaani);
		}

		return kokonaisMuutos;
    }
    
    public static void main(String[] args) {
        System.out.println(pieninMuutos(new int[] {1, 7, 3, 4}));
        System.out.println(pieninMuutos(new int[] {1, 2, 1, 2}));
        System.out.println(pieninMuutos(new int[] {7, 7, 7, 7}));
        System.out.println(pieninMuutos(new int[] {1, 1, 1, 100, 1}));
    }    
}