
import java.util.HashSet;


public class Main {

	public static void main(String[] args) {
		
		HashSet<Piste1> hashSet1 = new HashSet<>();
		long alku1 = System.nanoTime();
		for (int i=0; i<100000; i++) {
			hashSet1.add(new Piste1(i, -i));
		}
		long loppu1 = System.nanoTime();
		
		HashSet<Piste2> hashSet2 = new HashSet<>();
		long alku2 = System.nanoTime();
		for (int i=0; i<100000; i++) {
			hashSet2.add(new Piste2(i, -i));
		}
		long loppu2 = System.nanoTime();
		
		HashSet<Piste3> hashSet3 = new HashSet<>();
		long alku3 = System.nanoTime();
		for (int i=0; i<10000; i++) {
			hashSet3.add(new Piste3(i, -i));
		}
		long loppu3 = System.nanoTime();
		
		HashSet<Piste4> hashSet4 = new HashSet<>();
		long alku4 = System.nanoTime();
		for (int i=0; i<10000; i++) {
			hashSet4.add(new Piste4(i, -i));
		}
		long loppu4 = System.nanoTime();
		
		System.out.println("Piste1: " + (loppu1 - alku1)/1000000.0 + "ms");
		System.out.println("Piste2: " + (loppu2 - alku2)/1000000.0 + "ms");
		System.out.println("Piste3: " + (loppu3 - alku3)/1000000.0 + "ms");
		System.out.println("Piste4: " + (loppu4 - alku4)/1000000.0 + "ms");
	}
	
}
