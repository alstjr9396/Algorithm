package solvedac.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *          A   C   A   Y   K   P
 *      C   0   1   1   1   1   1
 *      A   1   1   2   2   2   2
 *      P   1   1   2   2   2   3
 *      C   1   2   2   2   2   3
 *      A   1   2   3   3   3   3
 *      K   1   2   3   3   4   4
 */
public class Quiz9251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] map = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    map[i][j] = map[i - 1][j - 1] + 1;
                } else {
                    map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                }
            }
        }

        System.out.println(map[s1.length()][s2.length()]);
    }
}
