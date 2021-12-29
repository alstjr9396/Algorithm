package stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public int[] mySolution(int[] progresses, int[] speeds) {
    int front = 0;
    int back = progresses.length;
    List<Integer> answer = new ArrayList<>();
    while(front < back) {
      int n = 0;
      for(int i = front; i < progresses.length; i++)
        progresses[i] += speeds[i];
      while(front < back && progresses[front] >= 100) {
        n++;
        front++;
      }
      if(n > 0)
        answer.add(n);
    }
    return answer.stream().mapToInt(i->i).toArray();
  }

  public int[] bestSolution(int[] progresses, int[] speeds) {
    int[] dayOfend = new int[100];
    int day = -1;
    for(int i=0; i<progresses.length; i++) {
      while(progresses[i] + (day*speeds[i]) < 100) {
        day++;
      }
      dayOfend[day]++;
    }
    return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
  }
}
