import java.util.*;

public class Main {   
    public static boolean etsiSumma(int[] luvut, int x) {
		HashSet<Integer> kaydyt = new HashSet<Integer>();
		kaydyt.add(luvut[0]);
		for (int i=1; i<luvut.length; i++) {
			if (kaydyt.contains(x - luvut[i])) return true;
			kaydyt.add(luvut[i]);
		}
		return false;
    }
    
    public static void main(String[] args) {        
        System.out.println(etsiSumma(new int[] {1, 2, 3}, 5));
        System.out.println(etsiSumma(new int[] {1, 2, 3}, 6));
        System.out.println(etsiSumma(new int[] {1, 3, 3}, 6));
        System.out.println(etsiSumma(new int[] {1, 2, 3}, 6));
    }        
}