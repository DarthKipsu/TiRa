
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class HeapSort {
	
	private static int[] createRandomArray(int size) {
		int[] newRandom = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			newRandom[i] = random.nextInt(1000000) + 1;
		}
		return newRandom;
	}

	private static int[] sortWithExistingHeap(int[] array) {
		PriorityQueue<Integer> heap = createMaxHeap(array);
		int[] sortedArray = new int[array.length];
		for (int i = sortedArray.length - 1; i >= 0; i--) {
			sortedArray[i] = heap.poll();
		}
		return sortedArray;
	}

	private static PriorityQueue<Integer> createMaxHeap(int[] array) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (Integer value : array) {
			heap.add(value);
		}
		return heap;
	}

	private static int[] sort(int[] array) {
		MaxHeap heap = new MaxHeap(array);
		int[] sortedArray = new int[array.length];
		for (int i = sortedArray.length - 1; i >= 0; i--) {
			sortedArray[i] = heap.getMax();
		}
		return sortedArray;
	}

	public static void main(String[] args) {
		int[] unsorted = createRandomArray(1000000);
		int[] unsorted2 = Arrays.copyOf(unsorted, 1000000);
		int[] unsorted3 = Arrays.copyOf(unsorted, 1000000);
		
		Long begin = System.nanoTime();
		int[] sorted = sortWithExistingHeap(unsorted);
		Long middle = System.nanoTime();
		int[] sorted2 = sort(unsorted2);
		Long end = System.nanoTime();
		Arrays.sort(unsorted3);
		Long sort = System.nanoTime();
		
//		System.out.println(Arrays.toString(sorted));
		System.out.println("Aikaa kului: " + (middle-begin)/1000000.0);
//		System.out.println(Arrays.toString(sorted2));
		System.out.println("Aikaa kului: " + (end-middle)/1000000.0);
//		System.out.println(Arrays.toString(unsorted3));
		System.out.println("Aikaa kului: " + (sort-end)/1000000.0);
	}

}
