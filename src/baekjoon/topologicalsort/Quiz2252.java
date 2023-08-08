package baekjoon.topologicalsort;

import java.util.*;
import java.util.concurrent.*;

public class Quiz2252 {
    private static int n;
    private static int cnt;
    private static List<Integer>[] comparedList;
    private static int[] compareCnt;
    private static Queue<Integer> queue = new ConcurrentLinkedQueue<>();
    private static Queue<Integer> line = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cnt = sc.nextInt();
        comparedList = new ArrayList[n + 1];
        compareCnt = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            comparedList[i] = new ArrayList<>();
        }

        for (int i = 0; i < cnt; i++) {
            int first = sc.nextInt();
            int last = sc.nextInt();
            comparedList[first].add(last);
            compareCnt[last] += 1;
        }

        for(int i = 1; i < n + 1; i++) {
            if (compareCnt[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int student = queue.poll();
            line.offer(student);

            for (int i = 0; i < comparedList[student].size(); i++) {
                compareCnt[comparedList[student].get(i)] -= 1;
                if(compareCnt[comparedList[student].get(i)] == 0) {
                    queue.offer(comparedList[student].get(i));
                }
            }
        }

        while (!line.isEmpty()) {
            System.out.print(line.poll() + " ");
        }
    }
}
