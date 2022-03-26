package baekjoon.simulation;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz17144 {

  private static int x;
  private static int y;
  private static int time;
  private static int[][] maps;
  private static int[][] dust;
  private static int[] xpos = {-1, 1, 0, 0};
  private static int[] ypos = {0, 0, -1, 1};
  private static List<Integer> machineLocation = new ArrayList<>();
  private static int result = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    y = sc.nextInt();
    x = sc.nextInt();
    time = sc.nextInt();

    maps = new int[y][x];

    for (int i = 0; i < y; i++) {
      for (int j = 0; j < x; j++) {
        maps[i][j] = sc.nextInt();
        if (maps[i][j] == -1) {
          machineLocation.add(i);
        }
      }
    }

    for (int i = 0; i < time; i++) {
      dust = new int[y][x];
      spreadOut();
      addDust();
      topCleanUp();
      bottomCleanUp();
    }

    for (int i = 0; i < y; i++) {
      for (int j = 0; j < x; j++) {
        if (maps[i][j] == -1 || maps[i][j] == 0) {
          continue;
        }
        result += maps[i][j];
      }
    }
    System.out.println(result);
  }

  // 확산된 먼지 추가
  private static void addDust() {
    for (int i = 0; i < y; i++) {
      for (int j = 0; j < x; j++) {
        maps[i][j] += dust[i][j];
      }
    }
  }

  // 한 노드에서 먼지 확산
  private static void spreadOut() {
    for (int i = 0; i < y; i++) {
      for (int j = 0; j < x; j++) {
        spreadToSpot(j, i);
      }
    }
  }

  // 4방향으로 먼지 확산
  private static void spreadToSpot(int xx, int yy) {
    if (maps[yy][xx] < 5 || maps[yy][xx] == -1 || maps[yy][xx] == 0) {
      return;
    }
    int dustSize = maps[yy][xx] / 5;
    for (int i = 0; i < 4; i++) {
      int nx = xx + xpos[i];
      int ny = yy + ypos[i];
      if (nx < 0 || nx >= x || ny < 0 || ny >= y || maps[ny][nx] == -1) {
        continue;
      }
      dust[ny][nx] += dustSize;
      maps[yy][xx] -= dustSize;
    }
  }

  // 공기 청정기 위쪽 먼지 제거
  private static void topCleanUp() {
    int m1 = machineLocation.get(0);

    for (int i = m1 - 2; i >= 0; i--) {
      maps[i + 1][0] = maps[i][0];
    }
    for (int i = 0; i < x - 1; i++) {
      maps[0][i] = maps[0][i + 1];
    }
    for (int i = 0; i < m1; i++) {
      maps[i][x - 1] = maps[i + 1][x - 1];
    }
    for (int i = x - 2; i > 0; i--) {
      maps[m1][i+1] = maps[m1][i];
    }
    maps[m1][1] = 0;
  }

  // 공기 청정기 아래쪽 먼지 제거
  private static void bottomCleanUp() {
    int m2 = machineLocation.get(1);

    for (int i = m2 + 2; i < y; i++) {
      maps[i - 1][0] = maps[i][0];
    }
    for (int i = 1; i < x; i++) {
      maps[y-1][i-1] = maps[y-1][i];
    }
    for (int i = y - 2; i >= m2; i--) {
      maps[i + 1][x-1] = maps[i][x-1];
    }
    for (int i = x - 2; i > 0; i--) {
      maps[m2][i+1] = maps[m2][i];
    }
    maps[m2][1] = 0;
  }
}
