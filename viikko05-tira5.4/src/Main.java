import java.util.*;

public class Main {
    
    public static int pisinPolku(Puu puu) {
		int[] hannat = longestTail(puu);
		return hannat[1];
    }
	
	private static int[] longestTail(Puu puu) {
		if (puu == null) return new int[]{0,0};
		
		int[] vasen = longestTail(puu.vasen);
		int[] oikea = longestTail(puu.oikea);

		return new int[]{
			Math.max(vasen[0], oikea[0]) + 1,
			longestPath(oikea, vasen)
		};
	}

	private static int longestPath(int[] oikea, int[] vasen) {
		return Math.max(
				vasen[0] + oikea[0],
				Math.max(oikea[1], vasen[1])
		);
	}
    
    public static void main(String[] args) {        
        Puu puu = new Puu(1,
                          new Puu(3,
                                  new Puu(2, null, null),
                                  null),
                          new Puu(3,
                                  new Puu(3, null, null),
                                  new Puu(2, null, null)));

        System.out.println(pisinPolku(puu));
    }        
}