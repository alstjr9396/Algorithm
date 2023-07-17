package baekjoon.dfs;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Quiz1260 {
    private static StringBuilder sb = new StringBuilder();
    private static Queue<Integer> queue = new ConcurrentLinkedQueue<>();
    private static int n;
    private static int m;
    private static int start;
    private static int[][] arr;
    private static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            arr[p1][p2] = arr[p2][p1] = 1;
        }

        dfs(start);

        sb.append("\n");

        Arrays.fill(visit, false);
        bfs(start);

        System.out.println(sb.toString());
    }

    private static void dfs(int start) {
        if(visit[start]) {
           return;
        }

        visit[start] = true;
        sb.append(start).append(" ");

        for (int i = 1; i < n + 1; i++) {
            if (arr[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        queue.offer(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start).append(" ");

            for (int i = 0; i < n + 1; i++) {
                if (arr[start][i] == 1 && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}
