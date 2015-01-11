
import java.util.Arrays;

public class MaxHeap {

	private int[] heap;
	private int size;
	
	public MaxHeap(int[] array) {
		size = array.length;
		heap = new int[array.length];
		orderMaxHeap(array);
	}
	
	public Integer getMax() {
		int max = heap[0];
		heap[0] = heap[size-1];
		size--;
		keepHeapInOrder();
		return max;
	}

	private void orderMaxHeap(int[] array) {
		heap[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			int parent = parentIndex(i);
			if (valueSmallerThanParent(array, i, parent)) {
				heap[i] = array[i];
			} else {
				reorderHeap(i, parent, array);
			}
		}
	}

	private static int parentIndex(int i) {
		return (i-1)/2;
	}

	private void reorderHeap(int i, int parent, int[] array) {
		heap[i] = heap[parent];
		while (tempIsGreaterThanParent(parent, array, i)) {
			parent = moveUp(parent);
		}
		heap[parent] = array[i];
	}

	private boolean valueSmallerThanParent(int[] array, int i, int parent) {
		return array[i] <= heap[parent];
	}

	private boolean tempIsGreaterThanParent(int parent, int[] array, int i) {
		return parent > 0 && array[i] > heap[parentIndex(parent)];
	}

	private int moveUp(int parent) {
		heap[parent] = heap[parentIndex(parent)];
		parent = parentIndex(parent);
		return parent;
	}

	private void keepHeapInOrder() {
		int i = 0;
		while (i < size) {
			Integer biggerChild = getBiggerChild(i);
			if (biggerChild == null) break;
			if (heap[i] < heap[biggerChild]) {
				replaceValues(i, biggerChild);
			}
			i = biggerChild;
		}
	}
	
	private Integer getBiggerChild(int i) {
		int left = leftIndex(i);
		int right = rightIndex(i);
		if (right < size)  return heap[left] > heap[right] ? left : right;
		else if (left < size)  return left;
		else return null;
	}

	private static int leftIndex(int i) {
		return i*2+1;
	}

	private static int rightIndex(int i) {
		return i*2+2;
	}

	private void replaceValues(int i, int biggerChild) {
		int temp = heap[i];
		heap[i] = heap[biggerChild];
		heap[biggerChild] = temp;
	}

	@Override
	public String toString() {
		return Arrays.toString(heap);
	}
	
}
