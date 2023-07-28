package baekjoon.dfs;

import java.util.*;

public class Quiz16930 {
    private static int n;
    private static int m;
    private static int size;
    private static char[][] map;
    private static int[][] goal;
    private static Queue<int[]> queue = new LinkedList<>();
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};
    private static int[][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        size = sc.nextInt();
        map = new char[n][m];
        visit = new int[n][m];
        goal = new int[2][2];

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }

        goal[0][0] = sc.nextInt() - 1;
        goal[0][1] = sc.nextInt() - 1;
        goal[1][0] = sc.nextInt() - 1;
        goal[1][1] = sc.nextInt() - 1;

        queue.add(new int[] {goal[0][0], goal[0][1]});
        findMinPath();
        System.out.println(visit[goal[1][0]][goal[1][1]] == Integer.MAX_VALUE ? -1 : visit[goal[1][0]][goal[1][1]]);
    }

    private static void findMinPath() {
        visit[goal[0][0]][goal[0][1]] = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            if(node[0] == goal[1][0] && node[1] == goal[1][1]) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= size; j++) {
                    int nx = node[0] + DX[i] * j;
                    int ny = node[1] + DY[i] * j;

                    if(nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == '#') {
                        break;
                    }

                    if(visit[nx][ny] < visit[node[0]][node[1]] + 1) {
                        break;
                    }

                    if (map[nx][ny] == '.' && visit[nx][ny] == Integer.MAX_VALUE) {
                        queue.add(new int[]{nx, ny});
                        visit[nx][ny] = visit[node[0]][node[1]] + 1;
                    }
                }
            }
        }
    }
}
