
public class UusiAita {
	
	public static void main(String[] args) {
		IO io = new IO();
		int aidanPituus = io.nextInt();
		long vaihtoehdot = 1;
		int alku = 0;
		int pituus = 0;
		for (int i = 0; i < aidanPituus; i++) {
			int lauta = io.nextInt();
			if (lauta == 0) pituus++;
			else if (pituus > 0) {
				if (alku == 0) vaihtoehdot *= valinVaihtoehdot(lauta, 0, pituus);
				else if (Math.max(lauta, alku) - Math.min(lauta, alku) > pituus + 1 ||
						(lauta - alku) % 2 == 0 && pituus % 2 == 0 ||
						(lauta - alku) % 2 != 0 && pituus % 2 != 0) {
					vaihtoehdot = 0;
					pituus = 0;
					break;
				} else vaihtoehdot *= valinVaihtoehdot(alku, lauta, pituus);
				vaihtoehdot %= 1000000007;
				alku = lauta;
				pituus = 0;
			} else if (alku != 0 && lauta - alku != 1 && lauta - alku != -1) {
				vaihtoehdot = 0;
				break;
			} else alku = lauta;
		}
		if (pituus > 0) {
			vaihtoehdot *= valinVaihtoehdot(alku, 0, pituus);
			vaihtoehdot %= 1000000007;
		}
		io.println(vaihtoehdot);
		io.close();
	}

	public static long valinVaihtoehdot(int alku, int loppu, int pituus) {
		long[][] d = new long[pituus + 1][alku + pituus + 1];
		if (alku > 1) d[1][alku - 1] = 1;
		d[1][alku + 1] = 1;
		int lahto = alku == 1 ? 1 : alku - 2;
		int leveys = 3;
		for (int i = 2; i <= pituus; i++) {
			for (int j = lahto; j < lahto + leveys * 2 && j < alku + pituus + 1; j+=2) {
				if (j > 0) d[i][j] += d[i - 1][j - 1];
				if (j > 0 && j < alku + pituus) d[i][j] += d[i - 1][j + 1];
				d[i][j] %= 1000000007;
			}
			lahto = lahto > 1 ? lahto - 1 : lahto + 1;
			leveys++;
		}
		long vaihtoehdot = 0;
		if (loppu == 0) {
			for (int i = 0; i < d[0].length; i++) {
				vaihtoehdot += d[pituus][i];
				vaihtoehdot %= 1000000007;
			}
		} else {
			vaihtoehdot += d[pituus][loppu - 1];
			if (loppu < d[0].length) vaihtoehdot += d[pituus][loppu + 1];
			vaihtoehdot %= 1000000007;
		}
		return vaihtoehdot;
	}

}
