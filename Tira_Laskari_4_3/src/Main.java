
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class Main {

	public static void main(String[] args) {

		Deque<Integer> arrayDeque = new ArrayDeque<>();
		List<Integer> linkedList = new LinkedList<>();

		long dequeStart = System.nanoTime();

		for (int i=0; i<100000; i++) {
			arrayDeque.push(i);
		}
		for (int i=0; i<100000; i++) {
			arrayDeque.pop();
		}

		long dequeStop = System.nanoTime();
		long listStart = System.nanoTime();

		for (int i=0; i<100000; i++) {
			linkedList.add(i);
		}
		for (int i=0; i<100000; i++) {
			linkedList.remove(0);
		}

		long linkedStop = System.nanoTime();

		System.out.println("ArrayDequella kesti: " + ((dequeStop - dequeStart)/1000000.0) + " ms");
		System.out.println("LinkedListalla kesti: " + ((linkedStop - listStart)/1000000.0) + " ms");
	}
	
}
