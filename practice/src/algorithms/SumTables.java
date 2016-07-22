
package algorithms;

public class SumTables {
  
  /**
   * You have a table with numbers and you want to efficiently calculate the sum
   * of those numbers from between a given range.
   * 
   * What if the table has 2 dimensions?
   */
  
  public static class SumTable {
    private int[] sums;

    public SumTable(int[] sums) {
      int n = sums.length;
      if (n < 1) {
        throw new UnsupportedOperationException("Array cannot be empty.");
      }
      this.sums = new int[n];
      this.sums[0] = sums[0];
      for (int i = 1; i < n; i++) {
        this.sums[i] = this.sums[i - 1] + sums[i];
      }
    }
    
    public int sumForRange(int a, int b) {
      if (a < 0 || a >= sums.length || b < 0 || b >= sums.length) {
        throw new UnsupportedOperationException("Invalid range.");
      }
      if (a == 0) return sums[b];
      return sums[b] - sums[a - 1];
    }
    
  }
  
  public static void main(String[] args) {
    int[] values = {1, 4, 5, 8, 3, 7, 1, 0, 6, 6, 2, 9, 2, 0, 4, 1};
    SumTable st = new SumTable(values);
    
    System.out.println("Sum between 0 and 5: " + st.sumForRange(0, 5));
    System.out.println("Sum between 5 and 10: " + st.sumForRange(5, 10));
  }
  
}
