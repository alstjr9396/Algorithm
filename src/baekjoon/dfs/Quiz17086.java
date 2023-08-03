package baekjoon.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Quiz17086 {
    private static final int[] DX = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static final int[] DY = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] visit;
    private static Queue<Node> queue = new LinkedList<>();
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1) {
                    continue;
                }
                int tmp = findSafetyZone(i, j);
                if (result < tmp) {
                    result = tmp;
                }
            }
        }

        System.out.println(result);
    }

    private static int findSafetyZone(int x, int y) {
        queue.clear();
        queue.offer(new Node(x, y, 1));
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], false);
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = node.x + DX[i];
                int ny = node.y + DY[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] == 1) {
                    return node.cnt;
                }

                queue.add(new Node(nx, ny, node.cnt + 1));
                visit[node.x][node.y] = true;
            }
        }

        return 0;
    }

    protected static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
