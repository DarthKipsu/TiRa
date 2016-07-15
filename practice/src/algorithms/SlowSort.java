
package algorithms;

import java.util.Arrays;

public class SlowSort {
  
  // implement sorting with O(n^2) time complexity
  
  public static int[] pubbleSort(int[] input) {
    int n = input.length;
    int[] output = Arrays.copyOf(input, n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        if (output[j] > output[j + 1]) {
          int temp = output[j];
          output[j] = output[j + 1];
          output[j + 1] = temp;
        }
      }
    }
    return output;
  }
  
  public static int[] insertionSort(int[] input) {
    int n = input.length;
    int[] output = Arrays.copyOf(input, n);
    for (int i = 0; i < n - 1; i++) {
      for (int j = n - 1; j > i; j--) {
        if (output[j] < output[j - 1]) {
          int temp = output[j];
          output[j] = output[j - 1];
          output[j - 1] = temp;
        }
      }
    }
    return output;
  }
  
  public static int[] selectionSort(int[] input) {
    int n = input.length;
    int[] output = Arrays.copyOf(input, n);
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (output[j] < output[i]) {
          int temp = output[j];
          output[j] = output[i];
          output[i] = temp;
        }
      }
    }
    return output;
  }
  
  public static void main(String[] args) {
    int[] input = {3, 1, -5, 4, -2, 8, 5, -3};
    
    System.out.println("pubble sort: " + Arrays.toString(pubbleSort(input)));
    System.out.println("insertion sort: " + Arrays.toString(insertionSort(input)));
    System.out.println("selection sort: " + Arrays.toString(selectionSort(input)));
  }
  
}
