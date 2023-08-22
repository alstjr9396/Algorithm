package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz12026 {
    private static int n;
    private static char[] map;
    private static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new char[n + 1];
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        sc.nextLine();
        String line = sc.nextLine();
        for (int i = 1; i <= n; i++) {
            map[i] = line.charAt(i - 1);
        }

        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            char pattern = 'B';
            if (map[i] == 'B') {
                pattern = 'O';
            }
            if (map[i] == 'O') {
                pattern = 'J';
            }
            if (map[i] == 'J') {
                pattern = 'B';
            }
            for (int j = i; j <= n; j++) {
                if (map[j] == pattern) {
                    int min = (int) Math.min(dp[j], dp[i] + Math.pow(j - i, 2));
                    dp[j] = min;
                }
            }
        }

        System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
    }
}
