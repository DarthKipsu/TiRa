import java.util.*;

public class Main {

	private static List<List<Integer>> vaihtoehdot;

    public static int nopanheitot(int x) {
		vaihtoehdot = new ArrayList<List<Integer>>();
		heitot(x, new ArrayList<Integer>());
		return vaihtoehdot.size();
    }

	private static void heitot(int x, List<Integer> vaihtoehto) {
		if (x == 0) {
			vaihtoehdot.add(vaihtoehto);
			return;
		}
		if (x >= 6) lisaa(6, vaihtoehto, x);
		if (x >= 5) lisaa(5, vaihtoehto, x);
		if (x >= 4) lisaa(4, vaihtoehto, x);
		if (x >= 3) lisaa(3, vaihtoehto, x);
		if (x >= 2) lisaa(2, vaihtoehto, x);
		if (x >= 1) lisaa(1, vaihtoehto, x);
	}

	private static void lisaa(int silmaluku, List<Integer> vaihtoehto, int x) {
		vaihtoehto.add(silmaluku);
		heitot(x-silmaluku, vaihtoehto);
	}
    
    public static void main(String[] args) {
        System.out.println(nopanheitot(4));
        System.out.println(nopanheitot(2));
        System.out.println(nopanheitot(3));
        System.out.println(nopanheitot(1));
        System.out.println(nopanheitot(12));
    }    
}