package baekjoon.dp;

import java.util.*;

public class Quiz12865 {
    private static int n;
    private static int max;
    private static List<int[]> list = new ArrayList<>();
    private static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        max = sc.nextInt();
        dp = new int[n + 1][max + 1];

        for (int i = 0; i < n; i++) {
            list.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= max; j++) {
                dp[i][j] = dp[i - 1][j];

                if(j - list.get(i - 1)[0] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - list.get(i - 1)[0]] + list.get(i - 1)[1]);
                }
            }
        }

        System.out.println(dp[n][max]);
    }
}
