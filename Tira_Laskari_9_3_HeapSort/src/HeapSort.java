
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapSort {

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
		int[] unsorted = new int[]{2,8,5,6,1,3,7,4,2,8,5,6,1,3,7,4,2,8,5,6,1,3,7,4,2,8,5,6,1,3,7,4};
		int[] unsorted2 = new int[]{2,8,5,6,1,3,7,4,2,8,5,6,1,3,7,4,2,8,5,6,1,3,7,4,2,8,5,6,1,3,7,4};
		int[] unsorted3 = new int[]{2,8,5,6,1,3,7,4,2,8,5,6,1,3,7,4,2,8,5,6,1,3,7,4,2,8,5,6,1,3,7,4};
		
		Long begin = System.nanoTime();
		int[] sorted = sortWithExistingHeap(unsorted);
		Long middle = System.nanoTime();
		int[] sorted2 = sort(unsorted2);
		Long end = System.nanoTime();
		Arrays.sort(unsorted3);
		Long sort = System.nanoTime();
		
		System.out.println(Arrays.toString(sorted));
		System.out.println("Aikaa kului: " + (middle-begin)/1000000.0);
		System.out.println(Arrays.toString(sorted2));
		System.out.println("Aikaa kului: " + (end-middle)/1000000.0);
		System.out.println(Arrays.toString(unsorted3));
		System.out.println("Aikaa kului: " + (sort-end)/1000000.0);
	}

}
