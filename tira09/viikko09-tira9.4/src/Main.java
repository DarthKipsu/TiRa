import java.util.*;

public class Main {
    public static int laskeVaihdot(int[] luvut) {
		HashMap<Integer, Luku> erot = new HashMap<Integer, Luku>();
		
		laskeTaulukoidenErot(luvut, erot);
		
		int vaihdot = laskeParienVaihdot(erot);
		vaihdot += kolmenLuvunVaihdot(erot);

		return vaihdot;
    }

	private static void laskeTaulukoidenErot(int[] luvut, HashMap<Integer, Luku> erot) {
		int[] jarjestetty = jarjesta(luvut);
		for (int i = 0; i < luvut.length; i++) {
			if (luvut[i] != jarjestetty[i]) {
				int tunniste = luvut[i] * 10 + jarjestetty[i];
				if (erot.containsKey(tunniste)) {
					erot.get(tunniste).kasvata();
				} else {
					erot.put(tunniste, new Luku());
				}
			}
		}
	}

	private static int[] jarjesta(int[] luvut) {
		int[] jarjestettavat = Arrays.copyOfRange(luvut, 0, luvut.length);
		Arrays.sort(jarjestettavat);
		return jarjestettavat;
	}

	private static int laskeParienVaihdot(HashMap<Integer, Luku> erot) {
		int vaihdot = 0;
		for (int i = 1; i < 3; i++) {
			for (int j = i + 1; j < 4; j++) {
				int tunniste = 10 * i + j;
				int tunnistePeilikuva = 10 * j + i;
				
				if (erot.containsKey(tunniste) && erot.containsKey(tunnistePeilikuva)) {
					int tunnisteArvo = erot.get(tunniste).arvo();
					int peilikuvaArvo = erot.get(tunnistePeilikuva).arvo();
					
					if (tunnisteArvo == peilikuvaArvo) {
						erot.remove(tunniste);
						erot.remove(tunnistePeilikuva);
						vaihdot += tunnisteArvo;
					} else if (tunnisteArvo > peilikuvaArvo) {
						erot.get(tunniste).vahenna(peilikuvaArvo);
						erot.remove(tunnistePeilikuva);
						vaihdot += peilikuvaArvo;
					} else {
						erot.get(tunnistePeilikuva).vahenna(tunnisteArvo);
						erot.remove(tunniste);
						vaihdot += tunnisteArvo;
					}
				}
			}
		}
		return vaihdot;
	}
	
	private static int kolmenLuvunVaihdot(HashMap<Integer, Luku> erot) {
		int vaihdot = 0;
		if (!erot.isEmpty()) {
			for (Luku luku : erot.values()) {
				vaihdot += 2 * luku.arvo();
				return vaihdot;
			}
		}
		return vaihdot;
	}
    
    public static void main(String[] args) {
        System.out.println(laskeVaihdot(new int[] {1, 1, 1, 2, 2, 3}));
        System.out.println(laskeVaihdot(new int[] {3, 3, 3, 1, 1, 1}));
        System.out.println(laskeVaihdot(new int[] {1, 2, 3, 1, 2, 3}));
        System.out.println(laskeVaihdot(new int[] {1, 1, 1, 1, 1, 1}));
        System.out.println(laskeVaihdot(new int[] {2, 2, 3, 3, 1, 1}));
    }        
}