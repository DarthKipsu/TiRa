
package algorithms;

import java.util.Arrays;

public class FastSort {
  
  // implement sorting with O(n log n) time complexity
  
  public static int[] mergeSort(int[] input) {
    int n = input.length;
    if (n <= 1) return input;
    int[] left = new int[n / 2];
    int[] right = new int[n / 2 + (n % 2 == 0 ? 0 : 1)];
    for (int i = 0; i < n; i++) {
      if (i < n / 2) {
        left[i] = input[i];
      } else {
        right[i - n / 2] = input[i];
      }
    }
    return merge(mergeSort(left), mergeSort(right));
  }
  
  private static int[] merge(int[] left, int[] right) {
    int[] merged = new int[left.length + right.length];
    int li = 0, ri = 0, mi = 0;
    while (li < left.length && ri < right.length) {
      if (left[li] < right[ri]) {
        merged[mi] = left[li];
        li++;
      } else {
        merged[mi] = right[ri];
        ri++;
      }
      mi++;
    }
    while (li < left.length) {
      merged[mi] = left[li];
      li++;
      mi++;
    }
    while (ri < right.length) {
      merged[mi] = right[ri];
      ri++;
      mi++;
    }
    return merged;
  }
  
  public static void main(String[] args) {
    int[] input = {3, 1, -5, 4, -2, 8, 5, -3, 5, 7 , -2, 7, 4, 0, 0, 3, 5, -1};
    
    System.out.println("merge sort: " + Arrays.toString(mergeSort(input)));
  }
}
