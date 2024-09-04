package solvedac.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Quiz7576 {

    private static int[][] map;
    private static int x;
    private static int y;
    private static int max = 0;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        map = new int[y][x];
        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    que.add(new int[]{i, j, 0});
                }
            }
        }

        int day = 0;
        while (!que.isEmpty()) {
            int[] potato = que.poll();
            day = potato[2];

            for (int k = 0; k < 4; k++) {
                int xx = potato[1] + dx[k];
                int yy = potato[0] + dy[k];
                if (xx < x && xx >= 0 && yy < y && yy >= 0 && map[yy][xx] == 0) {
                    map[yy][xx] = 1;
                    que.add(new int[]{yy, xx, day + 1});
                }
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
            }
        }

        System.out.println(day);
    }
}
