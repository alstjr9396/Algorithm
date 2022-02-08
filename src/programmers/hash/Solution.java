package programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class Solution {

  public static void main(String[] args) {
    /*
    수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
    마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
    완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
     */
  }

  public String mySolution(String[] participant, String[] completion) {
    Map<String, Integer> participantMap = new HashMap<>();
    Stream<String> participantName = Arrays.stream(participant);
    participantName.forEach(name -> {
      if(participantMap.containsKey(name)){
        int num = participantMap.get(name);
        num++;
        participantMap.put(name, num);
      } else {
        participantMap.put(name, 1);
      }
    });
    Stream<String> completionName = Arrays.stream(completion);
    completionName.forEach(name -> {
      int num = participantMap.get(name);
      num--;
      participantMap.put(name, num);
    });
    List<String> notCompletion = new ArrayList<>();
    participantMap.forEach((name, num) -> {
      if (num > 0) {
        notCompletion.add(name);
      }
    });

    return String.join(",", notCompletion);
  }

  /**
   *  method : getOrDefault
   *  param : key, defaultValue
   *  function :  찾는 key가 존재하면 찾는 키의 값을 반환하고 없으면 기본 값을 반환하는 메소드
   *
   *  method : keySet
   *  function : Map의 key의 값만 반환
   */
  public String bestSolution(String[] participant, String[] completion) {
    String answer = "";
    HashMap<String, Integer> hm = new HashMap<>();
    for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
    for (String player : completion) hm.put(player, hm.get(player) - 1);

    for (String key : hm.keySet()) {
      if (hm.get(key) != 0){
        answer = key;
      }
    }
    return answer;
  }
}