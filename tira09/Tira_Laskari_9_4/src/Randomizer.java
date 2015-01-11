
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Randomizer {
	
	private static int[] createSortedArray(int size) {
		int[] newSorted = new int[size];
		for (int i = 0; i < size; i++) {
			newSorted[i] = i + 1;
		}
		return newSorted;
	}
	
	private static int[] randomize(int[] array) {
		List<Integer> remainingValues = new ArrayList<>();
		Random random = new Random();
		for (Integer value : array) {
			remainingValues.add(value);
		}
		for (int i = 0; i < array.length; i++) {
			int randomIndex = random.nextInt(remainingValues.size());
			array[i] = remainingValues.remove(randomIndex);
		}
		return array;
	}

	public static void main(String[] args) {
		int[] sorted = createSortedArray(1000);
		int[] suffled = randomize(sorted);
		System.out.println(Arrays.toString(suffled));
	}
	
}
