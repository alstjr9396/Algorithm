package stackandqueue;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution4 {

  public int[] mySolution(int[] prices) {
    List<Integer> period = new ArrayList<>();
    int i = 0;
    while (i < prices.length-1) {
      int count = 0;
      for (int j = i + 1; j < prices.length; j++) {
        if(prices[i] <= prices[j])
          count++;
      }
      period.add(count);
      i++;
    }
    period.add(0);
    return period.stream().mapToInt(p->p).toArray();
  }

  public int[] bestSolution(int[] prices) {
    Stack<Integer> beginIdxs = new Stack<>();
    int i=0;
    int[] terms = new int[prices.length];

    beginIdxs.push(i);
    for (i=1; i<prices.length; i++) {
      while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
        int beginIdx = beginIdxs.pop();
        terms[beginIdx] = i - beginIdx;
      }
      beginIdxs.push(i);
    }
    while (!beginIdxs.empty()) {
      int beginIdx = beginIdxs.pop();
      terms[beginIdx] = i - beginIdx - 1;
    }

    return terms;
  }

}
