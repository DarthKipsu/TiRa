
public class Taikasana {

	private static IO io;

	public static void main(String[] args) {
		io = new IO();
		char[] loitsu = io.next().toCharArray();
		char[] taikasana = io.next().toCharArray();
		int offset = taikasana.length + 1;
		char[] merkit = new char[loitsu.length + taikasana.length + 1];
		for (int i = 0; i < merkit.length; i++) {
			if (i < taikasana.length) merkit[i] = taikasana[i];
			else if (i == taikasana.length) merkit[i] = '#';
			else merkit[i] = loitsu[i - offset];
		}
		int[] z = new int[merkit.length];
		int a = 0;
		int b = 0;
		for (int i = 1; i < merkit.length; i++) {
			if (i > b) {
				for (int j = i; j < merkit.length; j++) {
					if (merkit[j - i] == merkit[j]) z[i]++;
					else break;
				}
			} else if (i + z[i - a] <= b) {
				z[i] = z[i - a];
			} else {
				z[i] = b - i + 1;
				for (int j = b + 1; j < merkit.length; j++) {
					if (merkit[j - i] == merkit[j]) z[i]++;
					else break;
				}
			}
			if (i + z[i] - 1 > b) {
				a = i;
				b = i + z[i] - 1;
			}
		}
		int summa = 0;
		for (int i = offset; i < merkit.length; i++) {
			summa += z[i];
		}
		io.println(summa);
		io.close();
	}
	
}
