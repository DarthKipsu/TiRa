
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;


public class Main {

	public static void main(String[] args) {
		int[] random1 = createRandomArray(10000);
		int[] random2 = createRandomArray(100000);
		int[] random3 = createRandomArray(1000000);
		
		long add1 = System.nanoTime();
		TreeSet<Integer> tree1 = addToTreeSet(random1);
		long delete1 = System.nanoTime();
		removeValues(tree1, 10000);
		long add2 = System.nanoTime();
		PriorityQueue<Integer> queue1 = addToPriorityQueue(random1);
		long delete2 = System.nanoTime();
		removeValues(queue1, 10000);
		long add3 = System.nanoTime();
		int[] array1 = addToArray(random1);
		long delete3 = System.nanoTime();
		goThrough(array1);
		long end1 = System.nanoTime();
		
		long add4 = System.nanoTime();
		TreeSet<Integer> tree2 = addToTreeSet(random2);
		long delete4 = System.nanoTime();
		removeValues(tree2, 100000);
		long add5 = System.nanoTime();
		PriorityQueue<Integer> queue2 = addToPriorityQueue(random2);
		long delete5 = System.nanoTime();
		removeValues(queue2, 100000);
		long add6 = System.nanoTime();
		int[] array2 = addToArray(random2);
		long delete6 = System.nanoTime();
		goThrough(array2);
		long end2 = System.nanoTime();
		
		long add7 = System.nanoTime();
		TreeSet<Integer> tree3 = addToTreeSet(random3);
		long delete7 = System.nanoTime();
		removeValues(tree3, 1000000);
		long add8 = System.nanoTime();
		PriorityQueue<Integer> queue3 = addToPriorityQueue(random3);
		long delete8 = System.nanoTime();
		removeValues(queue3, 1000000);
		long add9 = System.nanoTime();
		int[] array3 = addToArray(random3);
		long delete9 = System.nanoTime();
		goThrough(array3);
		long end3 = System.nanoTime();
		
		System.out.println("TreeSet add 10 000 values: " + (delete1 - add1)/1000000.0 + "ms");
		System.out.println("PriorityQueue add 10 000 values: " + (delete2 - add2)/1000000.0 + "ms");
		System.out.println("Array add 10 000 values: " + (delete3 - add3)/1000000.0 + "ms");
		System.out.println("TreeSet remove 10 000 values: " + (add2 - delete1)/1000000.0 + "ms");
		System.out.println("PriorityQueue remove 10 000 values: " + (add3 - delete2)/1000000.0 + "ms");
		System.out.println("Array go through 10 000 values: " + (end1 - delete3)/1000000.0 + "ms\n");
		
		System.out.println("TreeSet add 100 000 values: " + (delete4 - add4)/1000000.0 + "ms");
		System.out.println("PriorityQueue add 100 000 values: " + (delete5 - add5)/1000000.0 + "ms");
		System.out.println("Array add 100 000 values: " + (delete6 - add6)/1000000.0 + "ms");
		System.out.println("TreeSet remove 100 000 values: " + (add5 - delete4)/1000000.0 + "ms");
		System.out.println("PriorityQueue remove 100 000 values: " + (add6 - delete5)/1000000.0 + "ms");
		System.out.println("Array go through 100 000 values: " + (end2 - delete6)/1000000.0 + "ms\n");
		
		System.out.println("TreeSet add 1 000 000 values: " + (delete7 - add7)/1000000.0 + "ms");
		System.out.println("PriorityQueue add 1 000 000 values: " + (delete8 - add8)/1000000.0 + "ms");
		System.out.println("Array add 1 000 000 values: " + (delete9 - add9)/1000000.0 + "ms");
		System.out.println("TreeSet remove 1 000 000 values: " + (add8 - delete7)/1000000.0 + "ms");
		System.out.println("PriorityQueue remove 1 000 000 values: " + (add9 - delete8)/1000000.0 + "ms");
		System.out.println("Array go through 1 000 000 values: " + (end3 - delete9)/1000000.0 + "ms\n");
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
	
	private static int[] addToArray(int[] values) {
		int[] newArray = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			newArray[i] = values[i];
		}
		Arrays.sort(newArray);
		return newArray;
	}
	
	private static void removeValues(TreeSet<Integer> tree, int amount) {
		for (int i = 0; i < amount || !tree.isEmpty(); i++) {
			tree.pollFirst();
		}
	}
	
	private static void removeValues(PriorityQueue<Integer> queue, int amount) {
		for (int i = 0; i < amount || !queue.isEmpty(); i++) {
			queue.poll();
		}
	}
	
	private static void goThrough(int[] values) {
		for (Integer value : values) {
			value = null;
		}
	}
}
