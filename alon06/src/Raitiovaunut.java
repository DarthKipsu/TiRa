
import java.util.ArrayList;
import java.util.List;


public class Raitiovaunut {

	private static IO io;
	private static List[] verkko;
	private static boolean[] kayty;
	private static int maxYhteydet;

	public static void main(String[] args) {
		io = new IO();
		int pysakeita = io.nextInt();
		int yhteyksia = io.nextInt();
		luoVerkko(pysakeita, yhteyksia);
		haeSuurinKomponentti();
		io.print(maxYhteydet);
		io.close();
	}

	public static void luoVerkko(int solmut, int yhteyksia) {
		verkko = new ArrayList[solmut + 1];
		kayty = new boolean[solmut + 1];
		for (int i = 1; i <= solmut; i++) verkko[i] = new ArrayList();
		for (int i = 0; i < yhteyksia; i++) {
			int mista = io.nextInt();
			int minne = io.nextInt();
			verkko[mista].add(minne);
			verkko[minne].add(mista);
		}
	}

	public static void haeSuurinKomponentti() {
		maxYhteydet = 0;
		for (int i = 1; i < kayty.length; i++) {
			if (kayty[i]) continue;
			haku(i, 1);
		}
	}

	public static int haku(int pysakki, int yhteydet) {
		if (kayty[pysakki]) return 0;
		kayty[pysakki] = true;
		for (int i = 0; i < verkko[pysakki].size(); i++) {
			yhteydet += haku((int)verkko[pysakki].get(i), 1);
		}
		if (yhteydet > maxYhteydet) maxYhteydet = yhteydet;
		return yhteydet;
	}
	
}
