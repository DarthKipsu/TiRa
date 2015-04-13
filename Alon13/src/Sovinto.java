
public class Sovinto {

	public static void main(String[] args) {
		IO io = new IO();
		int[] pizzat = new int[io.nextInt()];
		for (int i = 0; i < pizzat.length; i++) {
			pizzat[i] = io.nextInt();
		}
		int suurinYhteinen = 0;
		for (int i = 0; i < pizzat.length; i++) {
			for (int j = i + 1; j < pizzat.length; j++) {
				int syt = syt(pizzat[i], pizzat[j]);
				if (syt > suurinYhteinen) suurinYhteinen = syt;
			}
		}
		io.println(suurinYhteinen);
		io.close();
	}

	private static int syt(int a, int b) {
		if (b == 0) return a;
		return syt(b, a % b);
	}
	
}
