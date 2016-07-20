
package algorithms;

public class Candy {
  
  /** 
   * There are n children and all the children want c[i] amount of candy.
   * To give the candy to the children, there is m candy bags with k candy
   * in each of them. T distribute the candy, each child will in order take
   * c[i] candy from the bag if it has enough and if not, the bag will be
   * thrown away with the rest of the candy and new one opened for the child.
   * Which is the smallest possible k to give each child the amount of candy
   * they want with m candy bags?
   */
  
  public static int smallestK(int[] children, int bags) {
    // This has time complexity O(n log maxK)
    int n = children.length;
    
    // get the max K if all the candy is in one bag.
    int maxK = 0;
    for (int i = 0; i < n; i++) {
      maxK += children[i];
    }
    
    // binary search the smallest K.
    int minK = 0;
    for (int k = maxK / 2; k > 0; k /= 2) {
      while (minK + k < maxK && !allChildrenGetCandy(children, bags, minK + k)) {
        minK += k;
      }
    }
    if (minK == maxK) return -1;
    return minK + 1;
  }
  
  private static boolean allChildrenGetCandy(int[] children, int bags, int k) {
    int neededBags = 0, current = 0;
    for (int i = 0; i < children.length; i++) {
      if (current >= children[i]) {
        current -= children[i];
      } else {
        neededBags++;
        current = k - children[i];
        if (current < 0) return false;
      }
    }
    return neededBags <= bags;
  }
  
  public static void main(String[] args) {
    int[] children1 = {4, 6, 12, 9, 14, 6, 3, 7, 7, 14, 3, 9, 8, 2, 7};
    int[] children2 = {0, 0, 0, 0, 0, 15, 0, 0, 0};
    
    System.out.println("children 1, 1 bags: " + smallestK(children1, 1));
    System.out.println("children 2, 1 bags: " + smallestK(children2, 1));
    
    System.out.println("\nchildren 1, 5 bags: " + smallestK(children1, 5));
    System.out.println("children 2, 5 bags: " + smallestK(children2, 5));
    
    System.out.println("\nchildren 1, 10 bags: " + smallestK(children1, 10));
    System.out.println("children 2, 10 bags: " + smallestK(children2, 10));
  }
  
}
