package programmers.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public static void main(String[] args) {
    /*
      PriorityQueue : min programmers.heap
     */
  }

  public int mySolution(int[] scoville, int K) {
    int answer = 0;
    Queue<Integer> scovilles = new PriorityQueue<>();
    for (int scov : scoville) {
      scovilles.add(scov);
    }
    while (scovilles.peek() < K) {
      if (scovilles.peek() < K && scovilles.size() == 1) {
        return -1;
      }
      int s = scovilles.poll();
      if (s < K) {
        s += scovilles.poll() * 2;
        scovilles.add(s);
        answer++;
      }
    }
    return answer;
  }

  public int bestSolution(int[] scoville, int K) {
    PriorityQueue<Integer> q = new PriorityQueue<>();

    for(int i = 0; i < scoville.length; i++)
      q.add(scoville[i]);

    int count = 0;
    while(q.size() > 1 && q.peek() < K){
      int weakHot = q.poll();
      int secondWeakHot = q.poll();

      int mixHot = weakHot + (secondWeakHot * 2);
      q.add(mixHot);
      count++;
    }

    if(q.size() <= 1 && q.peek() < K)
      count = -1;

    return count;
  }

}
