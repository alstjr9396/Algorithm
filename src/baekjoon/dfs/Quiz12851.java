package baekjoon.dfs;

import java.util.*;

public class Quiz12851 {
    private static int start;
    private static int goal;
    private static Queue<Integer> queue = new LinkedList<>();
    private static int[] time;
    private static int answer = Integer.MAX_VALUE;
    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = sc.nextInt();
        goal = sc.nextInt();
        time = new int[100_001];

        if (start >= goal) {
            System.out.println((start - goal) + "\n1");
            return;
        }

        queue.offer(start);
        time[start] = 1;
        findMinWay();

        System.out.println(answer);
        System.out.println(cnt);
    }

    private static void findMinWay() {
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (answer < time[cur]) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i == 0) {
                    next = cur + 1;
                }
                if (i == 1) {
                    next = cur - 1;
                }
                if (i == 2) {
                    next = cur * 2;
                }

                if (next == goal) {
                    answer = time[cur];
                    cnt++;
                }

                if ((next > 0 && next < 100_001) && (time[next] == 0 || time[next] >= time[cur] + 1)) {
                    time[next] = time[cur] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
