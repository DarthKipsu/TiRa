import java.util.*;

public class Main {
    public static int ennatys(int[] tulot, int[] lahdot) {
		Arrays.sort(tulot);
		Arrays.sort(lahdot);

		int enitenAsiakkaita = 0;
		int nykyisetAsiakkaat = 0;

		int iTulot = 0;
		int iLahdot = 0;
		int iAika = tulot[0] < lahdot[0] ? tulot[0] : lahdot[0];

		while (iTulot < tulot.length) {
			if (tulot[iTulot] == iAika) {
				nykyisetAsiakkaat++;
				iTulot++;
				if (iTulot < tulot.length) {
					iAika = tulot[iTulot] < lahdot[iLahdot] ? tulot[iTulot] : lahdot[iLahdot];
				}
			} else {
				nykyisetAsiakkaat--;
				iLahdot++;
				if (iLahdot < lahdot.length) {
					iAika = tulot[iTulot] < lahdot[iLahdot] ? tulot[iTulot] : lahdot[iLahdot];
				} else {
					iAika = tulot[iTulot];
				}
			}
			if (nykyisetAsiakkaat > enitenAsiakkaita) {
				enitenAsiakkaita = nykyisetAsiakkaat;
			}
		}
		return enitenAsiakkaita;
    }

    public static void main(String[] args) {
        System.out.println(ennatys(new int[] {3, 4, 5, 9},
                                   new int[] {8, 6, 10, 12}));
        System.out.println(ennatys(new int[] {3, 2, 10, 1},
                                   new int[] {8, 9, 20, 5}));
        System.out.println(ennatys(new int[] {1, 3, 5},
                                   new int[] {2, 4, 6}));
        System.out.println(ennatys(new int[] {100, 999},
                                   new int[] {1000, 1001}));
    }    
}