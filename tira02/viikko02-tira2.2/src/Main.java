import java.util.*;

public class Main {
    public static int yleisinLuku(int[] luvut) {
		double keskikohta = Math.ceil(luvut.length / 2);
		Arrays.sort(luvut);

		return luvut[(int)keskikohta];
    }
    
    public static void main(String[] args) {
        System.out.println(yleisinLuku(new int[] {4, 1, 1, 2, 1}));
        System.out.println(yleisinLuku(new int[] {5, 5, 5, 2}));
        System.out.println(yleisinLuku(new int[] {5, 5, 5, 5}));
        System.out.println(yleisinLuku(new int[] {1, 2, 2}));
    }    
}