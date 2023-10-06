package baekjoon.dp;

import java.util.Scanner;

public class Quiz12869 {
    private static int n;
    private static int[] hp;
    private static int[][][] dp = new int[61][61][61];
    private static int[][] damage = {{-9, -3, -1}, {-9, -1, -3}, {-3, -9, -1}, {-1, -9, -3},
            {-3, -1, -9}, {-1, -3, -9}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        hp = new int[3];

        for (int i = 0; i < n; i++) {
            hp[i] = sc.nextInt();
        }
        dp[0][0][0] = Integer.MAX_VALUE;

        for (int i = 0; i < 6; i++) {
            dfs(hp);
        }

        System.out.println(dp[0][0][0]);
    }

    private static void dfs(int[] hp) {
        for (int i = 0; i < 6; i++) {
            int[] tmp = new int[3];

            for (int j = 0; j < n; j++) {
                tmp[j] = hp[j] + damage[i][j];
            }
            for (int j = 0; j < n; j++) {
                if(tmp[j] < 0) {
                    tmp[j] = 0;
                }
            }

            if(dp[tmp[0]][tmp[1]][tmp[2]] != 0 && dp[tmp[0]][tmp[1]][tmp[2]] <= dp[hp[0]][hp[1]][hp[2]] + 1) {
                continue;
            }
            if (tmp[0] <= 0 && tmp[1] <= 0 && tmp[2] <= 0) {
                dp[0][0][0] = Math.min(dp[0][0][0], dp[hp[0]][hp[1]][hp[2]] + 1);
                return;
            }

            dp[tmp[0]][tmp[1]][tmp[2]] = dp[hp[0]][hp[1]][hp[2]] + 1;
            dfs(tmp);
        }
    }
}
