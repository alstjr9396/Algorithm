package baekjoon.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 조합 + 백트래킹
 */
public class Quiz15686 {

  private static int n;
  private static int m;
  private static int[][] map;
  private static List<Place> chickenPlaces = new ArrayList<>();
  private static List<Place> houses = new ArrayList<>();
  private static List<Place> selectedChickenPlace = new ArrayList<>();
  private static int result = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();

    map = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        map[i][j] = sc.nextInt();
        if (map[i][j] == 1) {
          houses.add(new Place(j, i));
        }
        if (map[i][j] == 2) {
          chickenPlaces.add(new Place(j, i));
        }
      }
    }

    getChickenDistance(0, 0);

    System.out.println(result);
  }

  private static void getChickenDistance(int start, int count) {
    // m개의 chickenPlace가 선택되면 거리를 계산
    if (count == m) {
      calcDistance();
      return;
    }

    // chickenPlaces.size() n개 중의 m개의 chickenPlace를 선택하는 조합
    for (int i = start; i < chickenPlaces.size(); i++) {
      selectedChickenPlace.add(chickenPlaces.get(i));
      getChickenDistance(i + 1, count + 1);
      selectedChickenPlace.remove(chickenPlaces.get(i));
    }

  }

  private static void calcDistance() {
    int sum = 0;
    for (Place house : houses) {
      int min = Integer.MAX_VALUE;
      for (Place chickenPlace : selectedChickenPlace) {
        int dist = Math.abs(house.x - chickenPlace.x) + Math.abs(house.y - chickenPlace.y);
        min = Math.min(min, dist);
      }
      sum += min;

      // 백트래킹, 계산한 거리가 현재 최소 거리보다 크면 의미없는 값이므로 중단
      if (sum > result) {
        return;
      }
    }

    result = Math.min(sum, result);
  }

  protected static class Place {
    protected int x;
    protected int y;

    protected Place(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }


}
