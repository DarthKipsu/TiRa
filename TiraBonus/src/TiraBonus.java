import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class TiraBonus {

	private static class Kurssi implements Comparable<Kurssi> {

		public int numero;
		public int paallekkaisyydet;

		public Kurssi(int numero) {
			this.numero = numero;
			this.paallekkaisyydet = 0;
		}

		@Override
		public int compareTo(Kurssi o) {
			if (paallekkaisyydet < o.paallekkaisyydet) return 1;
			else if (paallekkaisyydet > o.paallekkaisyydet) return -1;
			else return 0;
		}
	}

	private static Kurssi[] kurssienOsallistujamaarat;
	private static int[] kurssienPaikat;
	private static int[] kurssipaikkojenOpiskelijat;
	private static File kurssit;
	private static Scanner lukija;

	public static void main(String[] args) {
		kurssienOsallistujamaarat = new Kurssi[5000];
		kurssienPaikat = new int[5001];
		kurssipaikkojenOpiskelijat = new int[26];
		try {
			kurssit = new File(ClassLoader.getSystemResource("kurssit.txt").toURI());
			lukija = new Scanner(kurssit);
			lukija.nextLine();
		} catch (Exception e) {}

		while (lukija.hasNextLine()) {
			String rivi = lukija.nextLine();
			String[] kurssit = rivi.split(" ");
			for (int i = 2; i < kurssit.length; i++) {
				int k = Integer.parseInt(kurssit[i]);
				if (kurssienOsallistujamaarat[k - 1] == null) {
					kurssienOsallistujamaarat[k - 1] = new Kurssi(k);
				}
				kurssienOsallistujamaarat[k - 1].paallekkaisyydet++;
			}
		}

		Arrays.sort(kurssienOsallistujamaarat);

		for (int i = 0; i < kurssienOsallistujamaarat.length; i++) {
			int j = 1;
			int pienin = 100000;
			for (int k = 1; k < kurssipaikkojenOpiskelijat.length; k++) {
				if (kurssipaikkojenOpiskelijat[k] < pienin) {
					pienin = kurssipaikkojenOpiskelijat[k];
					j = k;
				}
			}
			kurssienPaikat[kurssienOsallistujamaarat[i].numero] = j;
			kurssipaikkojenOpiskelijat[j] += kurssienOsallistujamaarat[i].paallekkaisyydet;
		}

		kirjoitaKurssit();
	}

	private static void kirjoitaKurssit() {
		int i = 1;
		try {
			File jarjestetty = new File("jarjestetyt.txt");
			FileWriter kirjoittaja = new FileWriter(jarjestetty);
			for (int j = 1; j <= 5000; j++) {
				if (kurssienPaikat[j] == 0) {
					j = i;
					if (i > 25) {
						i = 1;
					}
				}
				kirjoittaja.write(j + " " + kurssienPaikat[j] + "\n");
			}
			kirjoittaja.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
