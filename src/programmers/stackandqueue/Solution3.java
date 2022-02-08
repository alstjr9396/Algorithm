package programmers.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

  public static void main(String[] args) {
    /*
      best solution 없음
     */
  }

  public int mySolution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    int i = 0;
    Queue<Integer> bridge = new LinkedList<>();
    while(i < truck_weights.length) {
      if (bridge.stream().mapToInt(b->b).sum() + truck_weights[i] <= weight && bridge.size() < bridge_length) {
        bridge.add(truck_weights[i]);
        i++;
      } else {
        bridge.add(0);
      }
      answer++;
      if (bridge.size() == bridge_length) {
        bridge.poll();
      }
    }
    return answer + bridge_length;
  }

}
