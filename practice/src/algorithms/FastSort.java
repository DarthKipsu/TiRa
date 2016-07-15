
package algorithms;

import java.util.Arrays;
import java.util.LinkedList;

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
    LinkedList<Integer> list = new LinkedList<Integer>();
    for (int i = 0; i < input.length; i++) {
      list.addLast(input[i]);
    }
    list = naturalMergeSort(list);
    int[] result = new int[list.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = list.pollFirst();
    }
    return result;
  }
  
  private static LinkedList<Integer> naturalMergeSort(
        LinkedList<Integer> input) {
    int n = input.size();
    if (n <= 1) return input;
    LinkedList<LinkedList<Integer>> runs = 
        new LinkedList<LinkedList<Integer>>();
    LinkedList<Integer> lastRun = new LinkedList<Integer>();
    runs.addLast(lastRun);
    runs.getFirst().addLast(input.getFirst());
    for (int i = 1; i < n; i++) {
      if (input.get(i) < lastRun.getLast()) {
        lastRun = new LinkedList<Integer>();
        runs.addLast(lastRun);
      }
      lastRun.addLast(input.get(i));
    }
    for (int i = 0; i < runs.size() - 1; i++) {
      lastRun = merge(lastRun, runs.get(i));
    }
    return lastRun;
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
  
  private static LinkedList<Integer> merge(LinkedList<Integer> left,
        LinkedList<Integer> right) {
    LinkedList<Integer> merged = new LinkedList<Integer>();
    while (!left.isEmpty() && !right.isEmpty()) {
      if (left.getFirst() < right.getFirst()) {
        merged.addLast(left.pollFirst());
      } else {
        merged.addLast(right.pollFirst());
      }
    }
    while (!left.isEmpty()) {
      merged.addLast(left.pollFirst());
    }
    while (!right.isEmpty()) {
      merged.addLast(right.pollFirst());
    }
    return merged;
  }
  
  public static void main(String[] args) {
    int[] input = {3, 1, -5, 4, -2, 8, 5, -3, 5, 7 , -2, 7, 4, 0, 0, 3, 5, -1};
    
    System.out.println("merge sort: " + Arrays.toString(mergeSort(input)));
    System.out.println("natural merge sort: " + 
        Arrays.toString(naturalMergeSort(input)));
  }
}
