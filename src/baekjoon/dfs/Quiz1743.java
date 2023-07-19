package baekjoon.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Quiz1743 {
    private static int n;
    private static int m;
    private static int trashCnt;
    private static boolean[][] map;
    private static boolean[][] visit;
    private static Queue<Point> queue = new LinkedList<>();
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        trashCnt = sc.nextInt();
        map = new boolean[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < trashCnt; i++) {
            Point point = new Point(sc.nextInt() - 1, sc.nextInt() - 1);
            map[point.x][point.y] = true;
            queue.offer(point);
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            result = Math.max(result, findMaxPoo(p.x, p.y));
        }

        System.out.println(result);
    }

    private static int findMaxPoo(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return 0;
        }

        if(visit[x][y] || !map[x][y]) {
            return 0;
        }

        visit[x][y] = true;

        int sum = 1;
        sum += findMaxPoo(x - 1, y);
        sum += findMaxPoo(x + 1, y);
        sum += findMaxPoo(x, y - 1);
        sum += findMaxPoo(x, y + 1);

        return sum;
    }

    protected static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
