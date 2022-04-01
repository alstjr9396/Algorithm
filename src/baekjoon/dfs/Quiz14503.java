package baekjoon.dfs;

import java.util.Scanner;

public class Quiz14503 {

  private static int m;
  private static int n;
  private static int[][] map;
  private static int[] xpos = {0, 1, 0, -1};
  private static int[] ypos = {-1, 0, 1, 0};
  private static int result = 1;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    m = sc.nextInt();
    n = sc.nextInt();
    map = new int[m][n];

    int y = sc.nextInt();
    int x = sc.nextInt();
    int direction = sc.nextInt();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        map[i][j] = sc.nextInt();
      }
    }

    cleanUp(x, y, direction);
    System.out.println(result);
  }

  private static void cleanUp(int x, int y, int direction) {
    map[y][x] = -1;
    for (int i = 0; i < 4; i++) {
      direction = (direction + 3) % 4;
      int ny = y + ypos[direction];
      int nx = x + xpos[direction];
      if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[ny][nx] == 0) {
        result++;
        cleanUp(nx, ny, direction);
        return;
      }
    }
    int back = (direction + 2) % 4;
    int by = y + ypos[back];
    int bx = x + xpos[back];
    if (bx >= 0 && by >= 0 && bx < n && by < m && map[by][bx] != 1) {
      cleanUp(bx, by, direction);
    }
  }
}
