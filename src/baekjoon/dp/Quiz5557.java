package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Quiz5557 {
    private static List<Integer> list = new LinkedList<>();
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n][21];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        dp[0][list.get(0)] = 1;
        int i;
        for (i = 1; i < list.size() - 1; i++) {
            dp(i);
        }

        System.out.println(dp[i - 1][list.get(i)]);
    }

    private static void dp(int i) {
        for (int j = 0; j <= 20; j++) {
            if (dp[i - 1][j] > 0) {
                saveDp(i, j);
            }
        }
    }

    private static void saveDp(int i, int j) {
        if(j + list.get(i) <= 20) {
            dp[i][j + list.get(i)] += dp[i - 1][j];
        }
        if(j - list.get(i) >= 0) {
            dp[i][j - list.get(i)] += dp[i - 1][j];
        }
    }
}
