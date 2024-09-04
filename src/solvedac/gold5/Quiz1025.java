package solvedac.gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz1025 {

    private static int y;
    private static int x;
    private static String[][] map;
    private static int max = -1;
    private static String tmp = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new String[y][x];

        for (int i = 0; i < y; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = String.valueOf(line.charAt(j));
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                findMaximum(j, i);
            }
        }

        System.out.println(max);
    }

    public static void findMaximum(int xx, int yy) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                makeNumber(xx, yy, i, j);
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j > -x; j--) {
                makeNumber(xx, yy, i, j);
            }
        }
        for (int i = 0; i > -y; i--) {
            for (int j = 0; j < x; j++) {
                makeNumber(xx, yy, i, j);
            }
        }
        for (int i = 0; i > -y; i--) {
            for (int j = 0; j > -x; j--) {
                makeNumber(xx, yy, i, j);
            }
        }
    }

    public static void makeNumber(int xx, int yy, int i, int j) {
        tmp = "";
        if (i == 0 && j == 0) {
            tmp = map[yy][xx];
            chkMax(tmp);
        } else {
            while (xx < x && yy < y && xx >= 0 && yy >= 0) {
                tmp += map[yy][xx];
                chkMax(tmp);
                xx += j;
                yy += i;
            }
        }
    }

    public static void chkMax(String tmp) {
        int number = Integer.parseInt(tmp);
        int ans = (int) Math.sqrt(number);
        if (ans * ans == number && number > max) {
            max = number;
        }
    }

}
