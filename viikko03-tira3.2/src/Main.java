
import java.util.*;

public class Main {

	private static List<String> merkit;
	private static String pohja;

	public static int ketjumaara(String ketju) {
		merkit = new ArrayList<String>();
		pohja = ketju;
		char[] merkkijono = new char[ketju.length()];

		merkit(0, merkkijono);
		return merkit.size();
	}

	private static void merkit(int i, char[] merkkijono) {
		if (i > 1 && merkkijono[i-2] == merkkijono[i-1]) {
			return;
		} else if (i == pohja.length()) {
			merkit.add(String.valueOf(merkkijono));
			return;
		}
		char merkki = pohja.charAt(i);

		if (merkki != '?') {
			merkkijono[i] = merkki;
			merkit(i + 1, merkkijono);
		} else {
			merkkijono[i] = 'A';
			merkit(i + 1, merkkijono);
			merkkijono[i] = 'C';
			merkit(i + 1, merkkijono);
			merkkijono[i] = 'G';
			merkit(i + 1, merkkijono);
			merkkijono[i] = 'T';
			merkit(i + 1, merkkijono);
		}
	}

	public static void main(String[] args) {
		System.out.println(ketjumaara("A?C?"));
		System.out.println(ketjumaara("???"));
		System.out.println(ketjumaara("AGAG"));
		System.out.println(ketjumaara("A???T"));
	}
}
