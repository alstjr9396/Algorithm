package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    /*
      Arrays.copyOfRange(array, i, j) : array의 i부터 j까지 배열 복사
     */
  }

  public int[] solution(int[] array, int[][] commands) {
    int length = commands.length;
    int[] answer = new int[length];
    for(int j = 0; j < length; j++) {
      List<Integer> subCommand = new ArrayList<>();
      for(int i = commands[j][0]-1; i < commands[j][1]; i++) {
        subCommand.add(array[i]);
      }
      Collections.sort(subCommand);
      answer[j] = subCommand.get(commands[j][2]-1);
    }
    return answer;
  }

  public int[] bestSolution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    for(int i=0; i<commands.length; i++){
      int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
      Arrays.sort(temp);
      answer[i] = temp[commands[i][2]-1];
    }

    return answer;
  }
}
