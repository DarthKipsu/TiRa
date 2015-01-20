
import java.util.Map.Entry;
import java.util.TreeMap;


public class Maantiekiitaja {
	
	private static IO io;
	
	public static void main(String[] args) {
		io = new IO();
		
		long kivienMaara = io.nextLong();
		long tormaykset = io.nextLong();
		TreeMap<Long, long[]> kivet = new TreeMap<>();
		for (long i = 1; i <= kivienMaara; i++) {
			long kivi = io.nextLong();
			long[] info = new long[]{i, io.nextLong(), io.nextLong()}; // 0:id, 1:kiitäjän liike, 2:kiven liike
			kivet.put(kivi, info);
		}
		long[] tormatyt = tulostaKivet(kivet, tormaykset);
		for (long kivi : tormatyt) {
			io.println(kivi);
		}
		io.close();
	}
	
	public static long[] tulostaKivet(TreeMap<Long, long[]> kivet, long tormaykset) {
		long maantiekiitäjä = 0L;
		long[] tormatytKivet = new long[(int)tormaykset];
		for (int i = 0; i < tormaykset; i++) {
			Entry<Long, long[]> kivi = kivet.ceilingEntry(maantiekiitäjä);
			if (kivi == null) kivi = kivet.higherEntry(0L);
			long kiviSijainti = kivi.getKey();
			long[] kiviInfo = kivi.getValue();
			tormatytKivet[i] = kiviInfo[0];
			long kivenSiirtyma = kiviSijainti + kiviInfo[2];
			if (kivenSiirtyma > 1000000000L) kivenSiirtyma -= 1000000000L;
			else if (kivenSiirtyma < 0) kivenSiirtyma += 1000000000L;
			if (kivet.containsKey(kivenSiirtyma)) kivet.remove(kivenSiirtyma);
			kivet.remove(kiviSijainti);
			kivet.put(kivenSiirtyma, kiviInfo);
			maantiekiitäjä = kiviSijainti + kiviInfo[1];
			if (maantiekiitäjä > 1000000000L) maantiekiitäjä -= 1000000000L;
			else if (maantiekiitäjä < 0) maantiekiitäjä += 1000000000L;
			if (kivet.containsKey(maantiekiitäjä)) kivet.remove(maantiekiitäjä);
		}
		return tormatytKivet;
	}
	
}