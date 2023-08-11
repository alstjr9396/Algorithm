package baekjoon.dp;

import java.util.Scanner;

public class Quiz1890 {
    private static int n;
    private static int[][] map;
    private static long[][] dp;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 0) {
                    break;
                }
                if (i + map[i][j] < n) {
                    dp[i + map[i][j]][j] += dp[i][j];
                }
                if (j + map[i][j] < n) {
                    dp[i][j + map[i][j]] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}
