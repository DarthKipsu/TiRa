import java.util.*;

public class Main {    
    public static int[] suuremmat(int[] luvut) {
		Deque<Integer> pino = new ArrayDeque<Integer>();
		
		for (int i=luvut.length-1; i>=0; i--) {
			
			while (!pino.isEmpty()) {
				if (pino.peek() > luvut[i]) {
					int vanhaYlin = pino.peek();
					pino.push(luvut[i]);
					luvut[i] = vanhaYlin;
					break;
				} else {
					pino.pop();
				}
			}
			
			if (pino.isEmpty()) {
				pino.push(luvut[i]);
				luvut[i] = 0;
			}
		}
		
		return luvut;
    }
    
    
    public static void main(String[] args) {
        int[] tulos1 = suuremmat(new int[] {1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(tulos1));
        int[] tulos2 = suuremmat(new int[] {5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(tulos2));
        int[] tulos3 = suuremmat(new int[] {4, 3, 2, 1, 5});
        System.out.println(Arrays.toString(tulos3));
        int[] tulos4 = suuremmat(new int[] {1, 5, 2, 4, 3});
        System.out.println(Arrays.toString(tulos4));
    }        
}