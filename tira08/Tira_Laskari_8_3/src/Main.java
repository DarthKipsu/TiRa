
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;


public class Main {

	public static void main(String[] args) {
		int[] random1 = createRandomArray(10000);
		int[] random2 = createRandomArray(10000);
		int[] random3 = createRandomArray(100000);
		int[] random4 = createRandomArray(100000);
		int[] random5 = createRandomArray(1000000);
		int[] random6 = createRandomArray(1000000);
		
		long add1 = System.nanoTime();
		TreeSet<Integer> tree1 = addToTreeSet(random1);
		long replace1 = System.nanoTime();
		replaceValues(tree1, random2);
		long add2 = System.nanoTime();
		PriorityQueue<Integer> queue1 = addToPriorityQueue(random1);
		long replace2 = System.nanoTime();
		replaceValues(queue1, random2);
		long end1 = System.nanoTime();
		
		long add3 = System.nanoTime();
		TreeSet<Integer> tree2 = addToTreeSet(random3);
		long replace3 = System.nanoTime();
		replaceValues(tree2, random4);
		long add4 = System.nanoTime();
		PriorityQueue<Integer> queue2 = addToPriorityQueue(random3);
		long replace4 = System.nanoTime();
		replaceValues(queue2, random4);
		long end2 = System.nanoTime();
		
		long add5 = System.nanoTime();
		TreeSet<Integer> tree3 = addToTreeSet(random5);
		long replace5 = System.nanoTime();
		replaceValues(tree3, random6);
		long add6 = System.nanoTime();
		PriorityQueue<Integer> queue3 = addToPriorityQueue(random5);
		long replace6 = System.nanoTime();
		replaceValues(queue3, random6);
		long end3 = System.nanoTime();
		
		System.out.println("TreeSet add 10 000 values: " + (replace1 - add1)/1000000.0 + "ms");
		System.out.println("PriorityQueue add 10 000 values: " + (replace2 - add2)/1000000.0 + "ms");
		System.out.println("TreeSet replace 10 000 values: " + (add2 - replace1)/1000000.0 + "ms");
		System.out.println("PriorityQueue replace 10 000 values: " + (end1 - replace2)/1000000.0 + "ms\n");
		
		System.out.println("TreeSet add 100 000 values: " + (replace3 - add3)/1000000.0 + "ms");
		System.out.println("PriorityQueue add 100 000 values: " + (replace4 - add4)/1000000.0 + "ms");
		System.out.println("TreeSet replace 100 000 values: " + (add4 - replace3)/1000000.0 + "ms");
		System.out.println("PriorityQueue replace 100 000 values: " + (end2 - replace4)/1000000.0 + "ms\n");
		
		System.out.println("TreeSet add 1 000 000 values: " + (replace5 - add5)/1000000.0 + "ms");
		System.out.println("PriorityQueue add 1 000 000 values: " + (replace6 - add6)/1000000.0 + "ms");
		System.out.println("TreeSet replace 1 000 000 values: " + (add6 - replace5)/1000000.0 + "ms");
		System.out.println("PriorityQueue replace 1 000 000 values: " + (end3 - replace6)/1000000.0 + "ms\n");
	}
	
	private static int[] createRandomArray(int size) {
		int[] values = new int[size];
		for (int i = 0; i < size; i++) {
			values[i] = new Random().nextInt(size);
		}
		return values;
	}
	
	private static TreeSet<Integer> addToTreeSet(int[] values) {
		TreeSet<Integer> tree = new TreeSet<Integer>();
		for (int value : values) {
			tree.add(value);
		}
		return tree;
	}
	
	private static PriorityQueue<Integer> addToPriorityQueue(int[] values) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int value : values) {
			queue.add(value);
		}
		return queue;
	}
	
	private static void replaceValues(TreeSet<Integer> tree, int[] newValues) {
		for (Integer value : newValues) {
			tree.pollFirst();
			tree.add(value);
		}
	}
	
	private static void replaceValues(PriorityQueue<Integer> queue, int[] newValues) {
		for (Integer value : newValues) {
			queue.poll();
			queue.add(value);
		}
	}
	
}
