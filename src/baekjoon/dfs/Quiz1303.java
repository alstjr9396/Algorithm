package baekjoon.dfs;

import java.util.Scanner;

public class Quiz1303 {
    private static int n;
    private static int m;
    private static char[][] map;
    private static boolean[][] visit;
    private static char team;
    private static int wPower = 0;
    private static int bPower = 0;
    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[m][n];
        visit = new boolean[m][n];

        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt = 0;
                getPower(map[i][j], i, j);
                addPower(map[i][j]);
            }
        }

        System.out.println(wPower + " " + bPower);
    }

    private static void getPower(char team, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n || team != map[i][j] || visit[i][j]) {
            return;
        }

        visit[i][j] = true;
        cnt++;

        getPower(team, i, j - 1);
        getPower(team, i, j + 1);
        getPower(team, i - 1, j);
        getPower(team, i + 1, j);

    }

    private static void addPower(char team) {
        if (cnt <= 0) {
            return;
        }
        if (team == 'B') {
            bPower += Math.pow(cnt, 2);
        }
        if (team == 'W') {
            wPower += Math.pow(cnt, 2);
        }
    }
}
