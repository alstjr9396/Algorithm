package heap;

import java.util.*;

public class Solution3 {

  public int[] mySolution(String[] operations) {
    Queue<Integer> numQueue = new PriorityQueue<>();
    for (String operation : operations) {
      String[] splits = operation.split(" ");
      if (splits[0].equals("I")) {
        numQueue.add(Integer.parseInt(splits[1]));
      } else {
        if (splits[1].equals("1")) {
          int max = numQueue.stream().mapToInt(i->i).max().orElseGet(() -> 0);
          numQueue.remove(max);
        } else {
          numQueue.poll();
        }
      }
    }
    if (numQueue.size() == 0) {
      return new int[]{0, 0};
    } else if(numQueue.size() == 1) {
      return new int[]{numQueue.peek(), numQueue.peek()};
    } else {
      int max = numQueue.stream().mapToInt(i->i).max().orElseGet(() -> 0);
      return new int[]{max, numQueue.poll()};
    }
  }

  public int[] bestSolution(String[] operations) {
    /*
      - min heap
      Queue<Integer> numQueue = new PriorityQueue<>();

      - max heap
      Queue<Integer> maxNumQueue = new PriorityQueue<>(Collections.reverseOrder());
     */
    return null;
  }

}
