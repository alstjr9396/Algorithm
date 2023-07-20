package baekjoon.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Quiz2178 {
    private static Queue<Point> queue = new LinkedList<>();
    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] visit;
    private static int result = 1;
    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visit = new boolean[n][m];

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        queue.add(new Point(0, 0, 1));
        findWay();
        System.out.println(result);
    }

    // bfs
    private static void findWay() {
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x == n - 1 && p.y == m - 1) {
                result = p.cnt;
                return;
            }

            visit[p.x][p.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 0 || visit[nx][ny]) {
                    continue;
                }

                visit[nx][ny] = true;
                queue.add(new Point(nx, ny, p.cnt + 1));
                result += 1;
            }
        }
    }

    protected static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    // dfs 시간초과
//    private static void findWay(int i, int j, int jump) {
//        if (i == n - 1 && j == m - 1) {
//            System.out.println(jump);
//            System.exit(0);
//        }
//
//        if(i < 0 || i >= n || j < 0 || j >= m) {
//            return;
//        }
//
//        if(visit[i][j] || map[i][j] == 0) {
//            return;
//        }
//
//        visit[i][j] = true;
//
//        findWay(i + 1, j, jump + 1);
//        findWay(i, j + 1, jump + 1);
//        findWay(i - 1, j, jump + 1);
//        findWay(i, j - 1, jump + 1);
//
//        visit[i][j] = false;
//    }
}
