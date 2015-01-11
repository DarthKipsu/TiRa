
package tira_laskari_11_3;

import java.util.ArrayList;
import java.util.Random;

public class RandomVerkonLuoja {
	
	private static ArrayList<Integer>[] verkko;
	private static ArrayList<Integer>[] painot;
	
	public static ArrayList[][] luoVerkko(int solmuja, int yheteyksiaSolmussa){
		verkko = new ArrayList[solmuja + 1];
		painot = new ArrayList[solmuja + 1];
		Random random = new Random();
		for (int i = 1; i <= solmuja; i++) {
			verkko[i] = new ArrayList<Integer>();
			painot[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= solmuja;i++) {
			int yhteyksiaTassaSolmussa = (random.nextInt(yheteyksiaSolmussa -1) + 2) / 2;
			int paino = (random.nextInt(10) + 1) * 10;
			for (int j = 0; j < yhteyksiaTassaSolmussa; j++) {
				int yhteys = random.nextInt(solmuja) + 1;
				if (yhteys == i) {
					if (i != solmuja) {
						yhteys++;
					} else {
						yhteys--;
					}
				}
				if (!verkko[i].contains(yhteys)) {
					verkko[i].add(yhteys);
					verkko[yhteys].add(i);
					painot[i].add(paino);
					painot[yhteys].add(paino);
				}
			}
		}
		ArrayList[][] palautus = new ArrayList[2][];
		palautus[0] = verkko;
		palautus[1] = painot;
		return palautus;
	}
	
}
