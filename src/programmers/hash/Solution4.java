package programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution4 {

  public int[] mySolution(String[] genres, int[] plays) {
    List<Integer> answer = new ArrayList<>();
    Map<String, List<Integer>> index = new HashMap<>();
    Map<String, Integer> totalPlays = new HashMap<>();
    for(int i = 0; i < genres.length; i++) {
      if(index.containsKey(genres[i])) {
        for(int j = 0; j < index.get(genres[i]).size(); j++) {
          if (plays[index.get(genres[i]).get(j)] < plays[i]) {
            index.get(genres[i]).add(j, i);
          }
        }
        if (index.get(genres[i]).size() < 2) {
          index.get(genres[i]).add(i);
        }
      } else {
        List<Integer> indexes = new ArrayList<>();
        indexes.add(i);
        index.put(genres[i], indexes);
      }
      totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
    }
    List<String> keys = new ArrayList<>(totalPlays.keySet());
    keys.sort((o1, o2) -> totalPlays.get(o1) - totalPlays.get(o2));
    for (String key : keys) {
      answer.add(index.get(key).get(0));
      if (index.get(key).size() >= 2) {
        answer.add(index.get(key).get(1));
      }
    }
    return answer.stream().mapToInt(i->i).toArray();
  }

  public int[] bestSolution(String[] genres, int[] plays) {
    HashMap<String, Object> genresMap = new HashMap<String, Object>();      //<장르, 곡 정보>
    HashMap<String, Integer> playMap = new HashMap<String, Integer>(); //<장르, 총 장르 재생수>
    ArrayList<Integer> resultAL = new ArrayList<Integer>();

    for(int i = 0; i < genres.length; i++){
      String key = genres[i];
      HashMap<Integer, Integer> infoMap;       // 곡 정보 : <곡 고유번호, 재생횟수>

      if(genresMap.containsKey(key)){
        infoMap = (HashMap<Integer, Integer>)genresMap.get(key);
      }
      else {
        infoMap = new HashMap<Integer, Integer>();
      }

      infoMap.put(i, plays[i]);
      genresMap.put(key, infoMap);

      //재생수
      if(playMap.containsKey(key)){
        playMap.put(key, playMap.get(key) + plays[i]);
      }
      else {
        playMap.put(key, plays[i]);
      }
    }

    int mCnt = 0;
    Iterator it = sortByValue(playMap).iterator();

    while(it.hasNext()){
      String key = (String)it.next();
      Iterator indexIt = sortByValue((HashMap<Integer, Integer>)genresMap.get(key)).iterator();
      int playsCnt = 0;

      while(indexIt.hasNext()){
        resultAL.add((int)indexIt.next());
        mCnt++;
        playsCnt++;
        if(playsCnt > 1) break;
      }
    }

    int[] answer = new int[resultAL.size()];

    for(int i = 0; i < resultAL.size(); i++){
      answer[i] = resultAL.get(i).intValue();
    }

    return answer;
  }

  private ArrayList sortByValue(final Map map){
    ArrayList<Object> keyList = new ArrayList();
    keyList.addAll(map.keySet());

    Collections.sort(keyList, new Comparator(){
      public int compare(Object o1, Object o2){
        Object v1 = map.get(o1);
        Object v2 = map.get(o2);

        return ((Comparable) v2).compareTo(v1);
      }
    });

    return keyList;
  }
}
