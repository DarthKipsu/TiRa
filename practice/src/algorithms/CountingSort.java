
package algorithms;

import java.util.Arrays;

public class CountingSort {
  
  // Implement sorting when all values are between 0 and 100
  
  public static int[] sort(int[] input) {
    // counting sort time complexity: O(n)
    int n = input.length;
    if (n < 2) return input;
    int[] counts = new int[101];
    for (int i = 0; i < n; i++) {
      counts[input[i]]++;
    }
    for (int i = 0, j = 0; i < 101; i++) {
      for (int k = 0; k < counts[i]; k++) {
        input[j] = i;
        j++;
      }
    }
    return input;
  }
  
  public static void main(String[] args) {
    int[] values = {1, 6, 45, 45, 23, 5, 99, 100, 34, 59, 98, 1, 76, 3, 0};
    
    System.out.println("sorted: " + Arrays.toString(sort(values)));
  }
  
}
