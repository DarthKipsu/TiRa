import java.util.*;

public class Main {
    public static int keraaLuvut(int[] luvut) {
		HashSet<Integer> lisatyt = new HashSet<Integer>();
		int kierrokset = 1;
		lisatyt.add(0);
		
		for (int luku : luvut) {
			if (!lisatyt.contains(luku - 1)) {
				kierrokset++;
			}
			lisatyt.add(luku);
		}
		
		return kierrokset;
    }
    
    public static void main(String[] args) {
        System.out.println(keraaLuvut(new int[] {1, 2, 3, 4, 5}));
        System.out.println(keraaLuvut(new int[] {5, 1, 2, 3, 4}));
        System.out.println(keraaLuvut(new int[] {5, 4, 3, 2, 1}));
        System.out.println(keraaLuvut(new int[] {1, 5, 2, 4, 3}));
    }        
}