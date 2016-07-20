
package algorithms;

public class TopValue {
  
  /**
   * Search for the top value in an array containing first increasing then 
   * decreasing values.
   * The array can not contain the same value in a row more than once.
   */
  
  public static int topValue(int[] input) {
    // time complexity: O(log n)
    int n = input.length;
    if (n == 1) return input[0];
    if (n > 1 && input[0] > input[1]) return input[0];
    
    int i = 0;
    for (int j = n / 2; j > 0; j /= 2) {
      while (j + i < n - 1 && input[j + i] < input[j + i + 1]) {
        i += j;
      }
    }
    return input[i + 1];
  }
  
  public static void main(String[] args) {
    int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 5, 4, 3, 2, 1, 0};
    System.out.println("Biggest value: " + topValue(values));
    
    int[] values2 = {56, 45, 34, 23, 12, 0};
    System.out.println("\nBiggest value: " + topValue(values2));
    
    int[] values3 = {56};
    System.out.println("\nBiggest value: " + topValue(values3));
    
    int[] values4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13};
    System.out.println("\nBiggest value: " + topValue(values4));
  }
}
