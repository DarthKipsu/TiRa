
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
    private int[][] sums2d;

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

    public SumTable(int[][] sums) {
      int n = sums.length;
      if (n < 1) {
        throw new UnsupportedOperationException("Array cannot be empty.");
      }
      int m = sums[0].length;
      this.sums2d = new int[n][m];
      for (int i = 0; i < n; i++) {
        if (i < 1) {
          this.sums2d[i][0] = sums[i][0];
          for (int j = 1; j < m; j++) {
            this.sums2d[i][j] = this.sums2d[i][j - 1] + sums[i][j];
          }
        } else {
          this.sums2d[i][0] = sums[i][0] + this.sums2d[i - 1][0];
          for (int j = 1; j < m; j++) {
            this.sums2d[i][j] = sums[i][j] + 
                this.sums2d[i][j - 1] + 
                this.sums2d[i - 1][j] -
                this.sums2d[i - 1][j - 1];
          }
        }
      }
    }
    
    public int sumForRange(int a, int b) {
      if (a < 0 || a >= sums.length || b < 0 || b >= sums.length) {
        throw new UnsupportedOperationException("Invalid range.");
      }
      if (a == 0) return sums[b];
      return sums[b] - sums[a - 1];
    }
    
    public int sumForRange(int ia, int ib, int ja, int jb) {
      if (ia == 0 && ib == 0) return sums2d[ja][jb];
      return sums2d[ja][jb] - sums2d[ja][ib] - sums2d[ia][jb] + sums2d[ia][ib];
    }
    
  }
  
  public static void main(String[] args) {
    int[] values = {1, 4, 5, 8, 3, 7, 1, 0, 6, 6, 2, 9, 2, 0, 4, 1};
    SumTable st = new SumTable(values);
    
    System.out.println("Sum between 0 and 5: " + st.sumForRange(0, 5));
    System.out.println("Sum between 5 and 10: " + st.sumForRange(5, 10));
    
    int[][] values2d = {
      {1, 4, 5, 8, 3, 7, 1, 0, 6, 6, 2, 9, 2, 0, 4, 1},
      {1, 4, 5, 8, 3, 7, 1, 0, 6, 6, 2, 9, 2, 0, 4, 1},
      {1, 4, 5, 8, 3, 7, 1, 0, 6, 6, 2, 9, 2, 0, 4, 1},
      {1, 4, 5, 8, 3, 7, 1, 0, 6, 6, 2, 9, 2, 0, 4, 1},
      {1, 4, 5, 8, 3, 7, 1, 0, 6, 6, 2, 9, 2, 0, 4, 1},
      {1, 4, 5, 8, 3, 7, 1, 0, 6, 6, 2, 9, 2, 0, 4, 1}
    };
    SumTable st2d = new SumTable(values2d);
    
    System.out.println("Sum between (0,0) and (5,5): " + 
        st2d.sumForRange(0, 0, 5, 5));
    
    System.out.println("Sum between (3,3) and (5,10): " + 
        st2d.sumForRange(3, 3, 5, 10));
  }
  
}
