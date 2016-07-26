
package datastructures;

public class SegmentTree {
  
  /**
   * Implement a segment tree for keeping track of sums between elements in an 
   * array  and easily change values in the array.
   * 
   * Assumption: array length is a power of two.
   * 
   * (What if it's not?: You should add extra space to make it one)
   */
  
  private int[] tree;
  private int n;
  
  public SegmentTree(int[] values) {
    n = values.length;
    tree = new int[n * 2];
    for (int i = n; i < n * 2; i++) {
      tree[i] = values[i - n];
    }
    for (int i = n - 1; i > 0; i--) {
      tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }
  }
  
  public int sumForRange(int a, int b) {
    a += n;
    b += n;
    int sum = 0;
    while (a <= b) {
      if (a % 2 == 1) sum += tree[a++];
      if (b % 2 == 0) sum += tree[b--];
      a /= 2;
      b /= 2;
    }
    return sum;
  }
  
  public void changeValue(int i, int value) {
    i += n;
    tree[i] = value;
    i /= 2;
    while (i > 0) {
      tree[i] = tree[i * 2] + tree[i * 2 + 1];
      i /= 2;
    }
  }
  
  public static void main(String[] args) {
    int[] values = {1, 4, 5, 8, 3, 7, 1, 0, 6, 6, 2, 9, 2, 0, 4, 1};
    SegmentTree st = new SegmentTree(values);
    
    System.out.println("Sum between 0 and 5: " + st.sumForRange(0, 5));
    System.out.println("Sum between 5 and 10: " + st.sumForRange(5, 10));
    
    st.changeValue(6, 11);
    
    System.out.println("Sum between 0 and 5: " + st.sumForRange(0, 5));
    System.out.println("Sum between 5 and 10: " + st.sumForRange(5, 10));
  }
  
}
