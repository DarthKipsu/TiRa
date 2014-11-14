
import java.util.Arrays;

public class Main {
    
    public static long laskeKaannot(int[] luvut) {
		if (luvut.length < 2) return 0;
		
		int keski = (luvut.length + 1) / 2;
		int[] vasen = Arrays.copyOfRange(luvut, 0, keski);
		int[] oikea = Arrays.copyOfRange(luvut, keski, luvut.length);
		
		return laskeKaannot(vasen)
				+ laskeKaannot(oikea)
				+ inversioidenMaara(luvut, vasen, oikea);
    }
	
	private static long inversioidenMaara(int[] luvut, int[] vasen, int[] oikea) {
		long maara = 0;
		int iVasen = 0;
		int iOikea = 0;
		
		while(iVasen < vasen.length || iOikea < oikea.length) {
			if (iVasen == vasen.length) {
				lisaaOikeanPuoleisesta(luvut, iVasen, iOikea, oikea);
				iOikea++;
			} else if (iOikea == oikea.length || vasen[iVasen] <= oikea[iOikea]) {
				lisaaVasemmanPuoleisesta(luvut, iVasen, iOikea, vasen);
				iVasen++;
			} else {
				lisaaOikeanPuoleisesta(luvut, iVasen, iOikea, oikea);
				iOikea++;
				maara += vasen.length - iVasen;
			}
		}
		return maara;
	}

	private static void lisaaVasemmanPuoleisesta(int[] luvut, int iVasen, int iOikea, int[] vasen) {
		luvut[iVasen + iOikea] = vasen[iVasen];
	}

	private static void lisaaOikeanPuoleisesta(int[] luvut, int iVasen, int iOikea, int[] oikea) {
		luvut[iVasen + iOikea] = oikea[iOikea];
	}
    
    public static void main(String[] args) {
        System.out.println(laskeKaannot(new int[] {1, 2, 3, 4, 5}));
        System.out.println(laskeKaannot(new int[] {5, 1, 2, 3, 4}));
        System.out.println(laskeKaannot(new int[] {5, 4, 3, 2, 1}));
        System.out.println(laskeKaannot(new int[] {1, 1, 1, 1, 1}));
        System.out.println(laskeKaannot(new int[] {1, 5, 2, 4, 3}));
    }        
}