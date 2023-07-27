package baekjoon.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Quiz14226 {
    private static int n;
    private static boolean[][] visit;
    private static int[] time;
    private static Queue<Step> queue = new LinkedList<>();
    private static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visit = new boolean[n * 2][n * 2];
        time = new int[n * 2];

        queue.add(new Step(1, 0, 0));
        while (!queue.isEmpty()) {
            Step step = queue.poll();
            int length = step.length;
            int clipBoard = step.clipBoard;
            int time = step.time;

            if (length > n) {
                continue;
            }
            if (length == n) {
                System.out.println(time);
                return;
            }

            if (clipBoard != length && !visit[length][length]) {
                queue.add(new Step(length, length, time + 1));
                visit[length][length] = true;
            }

            if(step.clipBoard > 0 && !visit[length + clipBoard][clipBoard]) {
                queue.add(new Step(length + clipBoard, clipBoard, time + 1));
                visit[length + clipBoard][clipBoard] = true;
            }

            if(length > 0 && !visit[length - 1][clipBoard]) {
                queue.add(new Step(length - 1, clipBoard, time + 1));
                visit[length - 1][clipBoard] = true;
            }
        }
    }

    protected static class Step {
        int length;
        int clipBoard;
        int time;

        public Step(int length, int clipBoard, int time) {
            this.length = length;
            this.clipBoard = clipBoard;
            this.time = time;
        }
    }
}
