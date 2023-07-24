package baekjoon.dfs;

import java.util.Scanner;

public class Quiz2606 {
    private static int n;
    private static int connect;
    private static boolean[][] network;
    private static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        connect = sc.nextInt();
        network = new boolean[n][n];
        visit = new boolean[n];

        for (int i = 0; i < connect; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            network[x - 1][y - 1] = network[y - 1][x - 1] = true;
        }

        System.out.println(findZombiePc(0));
    }

    private static int findZombiePc(int start) {
        if (visit[start]) {
            return 0;
        }

        visit[start] = true;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(network[start][i] && !visit[i]) {
                sum += findZombiePc(i) + 1;
            }
        }
        return sum;
    }
}
