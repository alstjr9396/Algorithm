package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

  public static void main(String[] args) {
    /*
     *  전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
        전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

        구조대 : 119
        박준영 : 97 674 223
        지영석 : 11 9552 4421
        전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
        어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
     */
  }

  public boolean mySolution(String[] phone_book) {
    Map<Integer, List<String>> phones = new HashMap<>();
    Arrays.sort(phone_book);
    for (String phone : phone_book) {
      if (phones.containsKey(phone.length())) {
        phones.get(phone.length()).add(phone);
      } else {
        List<String> tmp = new ArrayList<>();
        tmp.add(phone);
        phones.put(phone.length(), tmp);
      }
    }
    for (String phone : phone_book) {
      for (Integer length : phones.keySet()) {
        if (length <= phone.length()) {
          continue;
        }
        for (String p : phones.get(length)) {
          if (p.startsWith(phone)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public boolean bestSolution(String[] phone_book) {
    boolean answer = true;
    HashMap<String, Integer> map = new HashMap<>();
    for(int i = 0 ; i < phone_book.length ; i++)
      map.put(phone_book[i],i);

    for(int i = 0 ; i < phone_book.length ; i++)
      for(int j = 1 ; j < phone_book[i].length() ; j++ )
        if(map.containsKey(phone_book[i].substring(0,j)))  return false;
    return answer;
  }
}
