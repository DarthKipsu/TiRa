
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
  
  public static int[] naturalMergeSort(int[] input) {
    int n = input.length;
    if (n < 2) return input;
    int[] runs = new int[0];
    for (int i = 1; i < n; i++) {
      if (input[i] < input[i - 1]) {
        runs = merge(runs, Arrays.copyOfRange(input, runs.length, i));
      }
    }
    return runs;
  }
  
  public static int[] quickSort(int[] input) {
    if (input.length < 2) return input;
    int n = input.length - 1;
    int pivot = input[n];
    int i = 0;
    for (int j = 0; j < n; j++) {
      if (pivot > input[j]) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
        i++;
      }
    }
    input[n] = input[i];
    input[i] = pivot;
    int[] beginning = quickSort(Arrays.copyOfRange(input, 0, i));
    int[] end = quickSort(Arrays.copyOfRange(input, i + 1, n + 1));
    for (int j = 0; j < i; j++) {
      input[j] = beginning [j];
    }
    for (int j = i + 1; j <= n; j++) {
      input[j] = end[j - i - 1];
    }
    return input;
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
    System.out.println("natural merge sort: " + 
        Arrays.toString(naturalMergeSort(input)));
    System.out.println("quick sort: " + Arrays.toString(quickSort(input)));
  }
}
