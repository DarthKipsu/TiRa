
package algorithms;

public class Search {
  
  // implement searching from a sorted array in O(log n) time
  
  public static int jumpingBinary(int[] input, int goal) {
    int n = input.length;
    if (n < 1) return -1;
    int i = 0;
    for (int jump = n / 2; jump >= 1; jump /= 2) {
      while (i + jump < n && input[i + jump] <= goal) i += jump;
    }
    return input[i] == goal ? i : -1;
  }
  
  public static int binarySearch(int[] input, int goal) {
    int n = input.length;
    if (n < 1) return -1;
    int i = 0, j = n - 1;
    while (i <= j) {
      int middlePoint = (i + j) / 2;
      if (input[middlePoint] == goal) return middlePoint;
      if (input[middlePoint] < goal) {
        i = middlePoint + 1;
      } else {
        j = middlePoint - 1;
      }
    }
    return -1;
  }
  
  public static void main(String[] args) {
    int[] values = {1, 2, 4, 5, 5, 7, 8, 8, 8, 10, 11, 14, 16, 17, 17, 20};
    
    System.out.println("Jumping binary:");
    System.out.println("2 is in index " + jumpingBinary(values, 2));
    System.out.println("11 is in index " + jumpingBinary(values, 11));
    System.out.println("12 is in index " + jumpingBinary(values, 12));
    
    System.out.println("\nNormal binary:");
    System.out.println("2 is in index " + binarySearch(values, 2));
    System.out.println("11 is in index " + binarySearch(values, 11));
    System.out.println("12 is in index " + binarySearch(values, 12));
  }
  
}
