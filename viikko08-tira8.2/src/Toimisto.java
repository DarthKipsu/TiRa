import java.util.*;

public class Toimisto {
	
	private TreeMap<Integer, PriorityQueue<String>> asuntojono;

	public Toimisto() {
		asuntojono = new TreeMap<Integer, PriorityQueue<String>>();
	}
    
    public void lisaaJonoon(String nimi, int kiire) {
		if (asuntojono.containsKey(kiire)) {
			asuntojono.get(kiire).add(nimi);
		} else {
			PriorityQueue<String> nimet = new PriorityQueue<String>();
			nimet.add(nimi);
			asuntojono.put(kiire, nimet);
		}
    }
    
    public String annaAsunto() {
		PriorityQueue<String> saajat = asuntojono.lastEntry().getValue();
		if (saajat.size() == 1) asuntojono.pollLastEntry();
		return saajat.poll();
    }
}
