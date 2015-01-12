
import java.util.Collections;
import java.util.PriorityQueue;


public class Asunnot {
	
	public static void main(String[] args) {
		IO io = new IO();
		
		String[] info = io.nextLine().split(" ");
		int deviation = Integer.parseInt(info[2]);
		String[] wishes = io.nextLine().split(" ");
		String[] apartments = io.nextLine().split(" ");
		
		io.println(dealApartments(wishes, apartments, deviation));
		io.close();
	}
	
	public static int dealApartments(String[] wishes, String[] apartments, int deviation) {
		PriorityQueue<Long> wishQueue = new PriorityQueue<Long>(1,Collections.reverseOrder());
		PriorityQueue<Long> aparQueue = new PriorityQueue<Long>(1,Collections.reverseOrder());
		for (String wish : wishes) {
			wishQueue.add(Long.parseLong(wish));
		}
		for (String apartment : apartments) {
			aparQueue.add(Long.parseLong(apartment));
		}
		int dealt = 0;
		long wish = wishQueue.poll();
		long apartment;
		while (!aparQueue.isEmpty()) {
			apartment = aparQueue.poll();
			while (!wishQueue.isEmpty() && wish > apartment + deviation) {
				wish = wishQueue.poll();
			}
			if (wishQueue.isEmpty() && wish > apartment + deviation) break;
			if (apartment <= wish + deviation && apartment >= wish - deviation) {
				dealt++;
				if (!wishQueue.isEmpty()) wish = wishQueue.poll();
				else break;
			}
		}
		return dealt;
	}
		
}
