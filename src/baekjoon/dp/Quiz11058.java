package baekjoon.dp;

import java.util.*;

public class Quiz11058 {
    private static int n;
    private static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new long[n + 1];

        for (int i = 1; i <= 6 && i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 7; i <= n; i++) {
            for (int j = 2; j <= 5; j++) {
                dp[i] = Math.max(dp[i - (j + 1)] * j, dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}
