import java.util.*;

public class Main {
	public static HashMap<Integer, HashSet<Integer>> käydytRuudut;
	
    public static int reitinPituus(String reitti) {
		käydytRuudut = new HashMap<Integer, HashSet<Integer>>();
		HashSet<Integer> nollat = new HashSet<Integer>();
		nollat.add(0);
		käydytRuudut.put(0, nollat);
		int x = 0;
		int y = 0;
		
		for (int i=0; i<reitti.length(); i++) {
			char suunta = reitti.charAt(i);
			
			if (suunta == 'Y') {
				y++;
				if (siirraYsuunnassa(x, y)) return i + 1;
			} else if (suunta == 'A') {
				y--;
				if (siirraYsuunnassa(x, y)) return i + 1;
			} else if (suunta == 'O') {
				x++;
				if (siirraXsuunnassa(x, y)) return i + 1;
			} else {
				x--;
				if (siirraXsuunnassa(x, y)) return i + 1;
			}
		}
		return 0;
    }

	private static boolean siirraYsuunnassa(int x, int y) {
		HashSet<Integer> kaydytY = käydytRuudut.get(x);
		if (kaydytY.contains(y)) return true;
		kaydytY.add(y);
		käydytRuudut.replace(x, kaydytY);
		return false;
	}

	private static boolean siirraXsuunnassa(int x, int y) {
		if (käydytRuudut.containsKey(x)) {
			return siirraYsuunnassa(x, y);
		} else {
			HashSet<Integer> kaydytY = new HashSet<Integer>();
			kaydytY.add(y);
			käydytRuudut.put(x, kaydytY);
		}
		return false;
	}
    
    public static void main(String[] args) {        
        System.out.println(reitinPituus("YYVVAAOO"));
        System.out.println(reitinPituus("YVAOYVAO"));
        System.out.println(reitinPituus("YYYYYYYY"));
        System.out.println(reitinPituus("OYVVAOOO"));
        System.out.println(reitinPituus("YYYAAA"));
    }        
}