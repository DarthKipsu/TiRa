
import java.util.Arrays;

public class Pitkospuut {
	
	public static void main(String[] args) {
		IO io = new IO();
		int lautojenLkm = io.nextInt();
		int reitinPituus = io.nextInt();
		int[] laudat = new int[lautojenLkm];
		for (int i = 0; i < lautojenLkm; i++) {
			laudat[i] = io.nextInt();
		}
		Arrays.sort(laudat);
		int[] maarat = new int[reitinPituus + 1];
		int[] valitut = new int[reitinPituus + 1];
		
		for (int i = 1; i <= reitinPituus; i++) {
			maarat[i] = reitinPituus + 1;
			for (int j = 0; j < lautojenLkm; j++) {
				if (i - laudat[j] < 0) continue;
				if (maarat[i - laudat[j]] + 1 < maarat[i]) {
					maarat[i] = maarat[i - laudat[j]] + 1;
					valitut[i] = laudat[j];
				}
			}
		}
		
		while (reitinPituus > 0) {
			io.println(valitut[reitinPituus]);
			reitinPituus -= valitut[reitinPituus];
		}
		io.close();
	}
	
}
