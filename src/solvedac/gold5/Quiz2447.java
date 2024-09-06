package solvedac.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz2447 {

    private static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        map = new String[n][n];

        star(n, 0, 0, false);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void star(int n, int x, int y, boolean isBlank) {
        if (isBlank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    map[i][j] = " ";
                }
            }
            return;
        }

        if(n <= 1){
            map[x][y] = "*";
            return;
        }

        int length = n / 3;
        int cnt = 0;
        for (int i = y; i < y + n; i += length) {
            for (int j = x; j < x + n; j += length) {
                cnt++;
                if (cnt == 5) {
                    star(length, j, i, true);
                } else {
                    star(length, j, i, false);
                }
            }
        }
    }


}
