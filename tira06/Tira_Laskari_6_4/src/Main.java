
import java.util.*;

public class Main {
	
	public static TreeSet<Integer> createTree(int[] array) {
		TreeSet<Integer> tree = new TreeSet<>();
		for (int i : array) {
			tree.add(i);
		}
		return tree;
	}

	public static int[] combineArrays(int[] array1, int[] array2) {
		int[] combined = new int[array1.length + array2.length];
		for (int i=0; i<array1.length; i++) {
			combined[i] = array1[i];
		}
		for (int i=0; i<array2.length; i++) {
			combined[array1.length + i] = array2[i];
		}
		Arrays.sort(combined);
		return combined;
	}
	
	public static List<Integer> findDublicates(TreeSet<Integer> tree, int[] array) {
		List<Integer> duplicates = new ArrayList<>();
		for (int i : array) {
			if (tree.contains(i)) duplicates.add(i);
		}
		return duplicates;
	}
	
	public static List<Integer> findDublicates(int[] array) {
		List<Integer> duplicates = new ArrayList<>();
		for (int i=1; i<array.length; i++) {
			if (array[i] == array[i-1]) duplicates.add(array[i]);
		}
		return duplicates;
	}
	
	public static void main(String[] args) {
		int[] array1 = new int[1000000];
		int[] array2 = new int[10000];
		
		for (int i=0; i<1000000; i++) {
			array1[i] = i*2;
		}
		for (int i=0; i<10000; i++) {
			array2[i] = i;
		}
		
		long start = System.nanoTime();
		TreeSet<Integer> tree = createTree(array1);
		List<Integer> treeSet = findDublicates(tree, array2);
		long middle = System.nanoTime();
		int[] combined = combineArrays(array1, array2);
		List<Integer> array = findDublicates(combined);
		long end = System.nanoTime();
		
		System.out.println("TreeSet pituus: " + treeSet.size() + 
			", aika: " + ((middle - start)/1000000.0));
		System.out.println("Array pituus: " + array.size() + 
			", aika: " + ((end - middle)/1000000.0));
	}
	
}
