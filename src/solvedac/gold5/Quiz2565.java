package solvedac.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * LIS 알고리즘
 * 참고: https://www.youtube.com/watch?v=CE2b_-XfVDk
 */
public class Quiz2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] line = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (line[j][1] < line[i][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        System.out.println(n - Arrays.stream(dp).max().orElse(0));
    }
}
