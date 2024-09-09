package solvedac.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Quiz10026 {

    public static Character[][] picture;
    public static int[][] visit;
    public static int n;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        picture = new Character[n][n];
        visit = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                picture[i][j] = line.charAt(j);
            }
        }

        int area = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] < 1) {
                    findArea(area, i, j);
                    area++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'G') {
                    picture[i][j] = 'R';
                }
            }
        }

        sb.append(area - 1).append(" ");

        area = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] < 1) {
                    findArea(area, i, j);
                    area++;
                }
            }
        }

        sb.append(area - 1);

        System.out.println(sb);
    }

    public static void findArea(int area, int i, int j) {
        visit[i][j] = area;

        for (int k = 0; k < 4; k++) {
            int y = i + dy[k];
            int x = j + dx[k];
            if (y < 0 || y >= n || x < 0 || x >= n) {
                continue;
            }
            if (visit[y][x] < 1 && picture[i][j] == picture[y][x]) {
                findArea(area, y, x);
            }
        }
    }




}
