
public class Main {

	public static int laskeKaannot(int[] luvut) {
		int kaannot = 0;

		for (int i = 0; i < luvut.length - 1; i++) {
			for (int j = i + 1; j < luvut.length; j++) {
				if (luvut[i] > luvut[j]) {
					kaannot++;
				}
			}
		}
		return kaannot;
	}

	public static void main(String[] args) {
		System.out.println(laskeKaannot(new int[]{2, 3, 1}));
		System.out.println(laskeKaannot(new int[]{1, 2, 3, 4, 5}));
		System.out.println(laskeKaannot(new int[]{5, 1, 2, 3, 4}));
		System.out.println(laskeKaannot(new int[]{5, 4, 3, 2, 1}));
		System.out.println(laskeKaannot(new int[]{1, 1, 1, 1, 1}));
		System.out.println(laskeKaannot(new int[]{1, 5, 2, 4, 3}));
	}
}
