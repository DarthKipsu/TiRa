
package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimeIntervals {
  
  /**
   * A restaurant keeps track of visitors enter and leave times. Find out how
   * many people there were at most at one time. The times are (for simplicity
   * recorded as ints where a smaller int means the visitor arrived / left
   * earlier.)
   * 
   * No two same moments in time is found from the record.
   */
  
  public static int countMostVisitros(int[] arrived, int[] left) {
    List<Time> times = new ArrayList<Time>();
    for (int i = 0; i < arrived.length; i++) {
      times.add(new Time(true, arrived[i]));
    }
    for (int i = 0; i < left.length; i++) {
      times.add(new Time(false, left[i]));
    }
    Collections.sort(times);
    int mostVisitors = 0;
    int currentVisitors = 0;
    for (Time time : times) {
      currentVisitors += time.affectVisitors();
      if (currentVisitors > mostVisitors) mostVisitors = currentVisitors;
    }
    return mostVisitors;
  }
  
  public static void main(String[] args) {
    int[] arrived = {1, 3, 5, 7, 9, 10, 13, 14};
    int[] left = {4, 6, 11, 12, 15, 16, 17, 20};
    
    System.out.println("Most visitors at once: " + 
        countMostVisitros(arrived, left));
  }
  
  private static class Time implements Comparable<Time>{
    boolean arrived;
    int time;

    public Time(boolean arrived, int time) {
      this.arrived = arrived;
      this.time = time;
    }
    
    public int affectVisitors() {
      return arrived ? 1 : -1;
    }

    @Override
    public int compareTo(Time other) {
      return this.time - other.time;
    }
  }
  
}
