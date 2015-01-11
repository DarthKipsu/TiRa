
import java.util.Random;


public class RandomVerkonLuoja {
	
	private static int[][] painot;
	
	public static int[][] luoVerkko(int solmuja, int yheteyksiaSolmussa){
		painot = new int[solmuja + 1][solmuja + 1];
		Random random = new Random(42);
//		}
		for (int i = 1; i <= solmuja;i++) {
			int yhteyksiaTassaSolmussa = (random.nextInt(yheteyksiaSolmussa -1) + 2) / 2;
			for (int j = 0; j < yhteyksiaTassaSolmussa; j++) {
				int paino = (random.nextInt(9) + 1);
				int yhteys = random.nextInt(solmuja) + 1;
				if (yhteys == i) {
					if (i != solmuja) {
						yhteys++;
					} else {
						yhteys--;
					}
				}
				if (painot[i][yhteys] == 0) {
					painot[i][yhteys] = paino;
					painot[yhteys][i] = paino;
				}
			}
		}
		return painot;
	}
	
}
