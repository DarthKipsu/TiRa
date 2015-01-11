
public class Main {
    public static boolean yksiPoisto(int[] luvut) {
		boolean yksiPoistettu = false;
		for (int i = 1; i < luvut.length; i++) {
			if (luvut[i] < luvut[i - 1]) {
				if (!yksiPoistettu) {
					yksiPoistettu = true;
				} else {
					return false;
				}
			}
		}
		return true;
    }
    
    public static void main(String[] args) {
        System.out.println(yksiPoisto(new int[] {1, 2, 3, 4, 5}));
        System.out.println(yksiPoisto(new int[] {5, 4, 3, 2, 1}));
        System.out.println(yksiPoisto(new int[] {1, 2, 9, 4, 5}));
        System.out.println(yksiPoisto(new int[] {9, 2, 3, 4, 5}));
        System.out.println(yksiPoisto(new int[] {1, 2, 3, 4, 1}));
        System.out.println(yksiPoisto(new int[] {5, 1, 5, 1, 5}));
    }        
}