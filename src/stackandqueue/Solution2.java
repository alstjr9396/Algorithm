package stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {

  public int mySolution(int[] priorities, int location) {
    int answer = 0;
    int min = 10;
    int n = 0;
    List<Integer> indexList = new ArrayList<>();
    for(int i = 0; i < priorities.length; i++) {
      if(priorities[i] > priorities[location]) {
        answer++;
        indexList.add(i);
      }
    }

    for(int index : indexList) {
      if(priorities[index] - priorities[location] <= min) {
        min = priorities[index] - priorities[location];
        n = index;
      }
    }
    if(n <= location) {
      for(int i = n; i < location; i++) {
        if(priorities[i] == priorities[location])
          answer++;
      }
    } else {
      for(int i = n; i < priorities.length; i++) {
        if(priorities[i] == priorities[location])
          answer++;
      }
      for(int i = 0; i < location; i++) {
        if(priorities[i] == priorities[location])
          answer++;
      }
    }

    return ++answer;
  }

  public int bestSolution(int[] priorities, int location) {
    int answer = 0;
    int l = location;

    Queue<Integer> que = new LinkedList<Integer>();
    for(int i : priorities){
      que.add(i);
    }

    Arrays.sort(priorities);
    int size = priorities.length-1;



    while(!que.isEmpty()){
      Integer i = que.poll();
      if(i == priorities[size - answer]){
        answer++;
        l--;
        if(l <0)
          break;
      }else{
        que.add(i);
        l--;
        if(l<0)
          l=que.size()-1;
      }
    }

    return answer;
  }
}
