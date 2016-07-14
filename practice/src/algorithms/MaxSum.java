
package algorithms;

public class MaxSum {
  
  // implement an algorithm to calculate the max sum of cosecutive elements.
  
  public int cubic(int[] input) {
    int n = input.length;
    int largest = 0;
    for (int i = 0; i < n; i++) {
      for (int j = n - 1; j >= i; j--) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
          sum += input[k];
        }
        if (sum > largest) largest = sum;
      }
    }
    return largest;
  }
  
  public int quadrangular(int[] input) {
    int n = input.length;
    int largest = 0;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += input[j];
        if (sum > largest) largest = sum;
      }
    }
    return largest;
  }
  
  public int constant(int[] input) {
    int n = input.length;
    int largest = 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (sum < 0) {
        sum = input[i];
      } else {
        sum += input[i];
      }
      if (sum > largest) largest = sum;
    }
    return largest;
  }
  
  public static void main(String[] args) {
    MaxSum maxSum = new MaxSum();
    int[] input = {3, 1, -5, 4, -2, 8, 5, -3};
    
    System.out.println("cubic: " + maxSum.cubic(input));
    System.out.println("cubic: " + maxSum.quadrangular(input));
    System.out.println("cubic: " + maxSum.constant(input));
  }
  
}
