package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {

  public String mySolution(int[] numbers) {
    String answer = "";
    List<String> numberList = new ArrayList<>();
    for(int n : numbers) {
      numberList.add(String.valueOf(n));
    }
    Collections.sort(numberList, ((o1, o2) -> Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2)));
    for (String s : numberList) {
      answer += s;
    }
    if(Collections.frequency(numberList, "0") == numberList.size()) {
      return "0";
    }
    return answer;
  }

  public String bestSolution(int[] numbers) {
    String answer = "";
    List<String> numberList = new ArrayList<>();
    for(int n : numbers) {
      numberList.add(String.valueOf(n));
    }
    Collections.sort(numberList, ((o1, o2) -> Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2)));
    for (String s : numberList) {
      answer += s;
    }
    if(answer.charAt(0) == '0') {
      return "0";
    }
    return answer;
  }

}
