
import java.util.Arrays;
import java.util.Random;


public class MergeSort {
	
	private static int[] createRandomArray(int size) {
		int[] newRandom = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			newRandom[i] = random.nextInt(1000000) + 1;
		}
		return newRandom;
	}
	
    public static int[] mergeSort(int[] luvut) {
		if (luvut.length < 2) return luvut;
		
		int keski = (luvut.length + 1) / 2;
		int[] vasen = mergeSort(Arrays.copyOfRange(luvut, 0, keski));
		int[] oikea = mergeSort(Arrays.copyOfRange(luvut, keski, luvut.length));
		
		return merge(luvut, vasen, oikea);
    }
	
	private static int[] merge(int[] luvut, int[] vasen, int[] oikea) {
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
			}
		}
		return luvut;
	}

	private static void lisaaVasemmanPuoleisesta(int[] luvut, int iVasen, int iOikea, int[] vasen) {
		luvut[iVasen + iOikea] = vasen[iVasen];
	}

	private static void lisaaOikeanPuoleisesta(int[] luvut, int iVasen, int iOikea, int[] oikea) {
		luvut[iVasen + iOikea] = oikea[iOikea];
	}
	
	public static void main(String[] args) {
		int[] unsorted = createRandomArray(1000000);
		int[] unsorted2 = Arrays.copyOf(unsorted, 1000000);
		
		Long begin = System.nanoTime();
		int[] sorted = mergeSort(unsorted);
		Long middle = System.nanoTime();
		Arrays.sort(unsorted2);
		Long end = System.nanoTime();
		
//		System.out.println(Arrays.toString(sorted));
		System.out.println("Aikaa kului: " + (middle-begin)/1000000.0);
//		System.out.println(Arrays.toString(unsorted2));
		System.out.println("Aikaa kului: " + (end-middle)/1000000.0);
	}
	
}
