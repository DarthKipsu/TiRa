import java.util.*;

public class Toimisto {
	
	private PriorityQueue<String> asuntojono;

	public Toimisto() {
		asuntojono = new PriorityQueue<String>();
	}
    
    public void lisaaJonoon(String nimi) {
		asuntojono.add(nimi);
    }
    
    public String annaAsunto() {
		return asuntojono.poll();
    }
}
