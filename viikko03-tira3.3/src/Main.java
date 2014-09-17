import java.util.*;
import org.omg.CORBA.INTERNAL;

public class Main {

	private static List<int[]> vaihtoehdot;

    public static int nopanheitot(int x) {
		vaihtoehdot = new ArrayList<int[]>();
		heitot(x, 0, new int[x]);
		return vaihtoehdot.size();
    }

	private static void heitot(int x, int i, int[] vaihtoehto) {
		if (x == 0) {
			vaihtoehdot.add(vaihtoehto);
			return;
		}
		if (x >= 6) lisaa(6, i, vaihtoehto, x);
		if (x >= 5) lisaa(5, i, vaihtoehto, x);
		if (x >= 4) lisaa(4, i, vaihtoehto, x);
		if (x >= 3) lisaa(3, i, vaihtoehto, x);
		if (x >= 2) lisaa(2, i, vaihtoehto, x);
		if (x >= 1) lisaa(1, i, vaihtoehto, x);
	}

	private static void lisaa(int silmaluku, int i, int[] vaihtoehto, int x) {
		int[] uusiVaihtoehto = vaihtoehto.clone();
		uusiVaihtoehto[i] = silmaluku;
		heitot(x-silmaluku, i+1, uusiVaihtoehto);
	}
    
    public static void main(String[] args) {
        System.out.println(nopanheitot(4));
		System.out.println(Arrays.toString(vaihtoehdot.get(0)));
		System.out.println(Arrays.toString(vaihtoehdot.get(1)));
		System.out.println(Arrays.toString(vaihtoehdot.get(2)));
		System.out.println(Arrays.toString(vaihtoehdot.get(3)));
		System.out.println(Arrays.toString(vaihtoehdot.get(4)));
		System.out.println(Arrays.toString(vaihtoehdot.get(5)));
		System.out.println(Arrays.toString(vaihtoehdot.get(6)));
		System.out.println(Arrays.toString(vaihtoehdot.get(7)));
        System.out.println(nopanheitot(2));
        System.out.println(nopanheitot(3));
        System.out.println(nopanheitot(1));
        System.out.println(nopanheitot(12));
    }    
}