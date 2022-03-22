package baekjoon.dfs;

import java.util.Scanner;

public class Quiz14890 {

    private static int n;
    private static int l;
    private static int[][] maps;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        l = input.nextInt();

        maps = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maps[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            heightDfs(i, maps[0][i], 1, 1);
            widthDfs(i, maps[i][0], 1, 1);
        }

        System.out.println(result);
    }

    private static void widthDfs(int i, int previous, int depth, int ground) {
        if (depth == n) {
            if (ground >= 0) {
                result++;
            }
            return;
        }

        if (previous == maps[i][depth]) {
            widthDfs(i, maps[i][depth], depth+1, ground+1);
        }
        if (previous < maps[i][depth] && maps[i][depth] - previous == 1  && ground >= l) {
            widthDfs(i, maps[i][depth], depth+1, 1);
        }
        if (previous > maps[i][depth] && previous - maps[i][depth] == 1 && n - depth >= l && ground >= 0) {
            widthDfs(i, maps[i][depth], depth+1, -l + 1);
        }
    }

    private static void heightDfs(int i, int previous, int depth, int ground) {
        if (depth == n) {
            if (ground >= 0) {
                result++;
            }
            return;
        }

        if (previous == maps[depth][i]) {
            heightDfs(i, maps[depth][i], depth+1, ground+1);
        }
        if (previous < maps[depth][i] && maps[depth][i] - previous == 1  && ground >= l) {
            heightDfs(i, maps[depth][i], depth+1, 1);
        }
        if (previous > maps[depth][i] && previous - maps[depth][i] == 1  && n - depth >= l && ground >= 0) {
            heightDfs(i, maps[depth][i], depth+1, -l + 1);
        }

    }

}
