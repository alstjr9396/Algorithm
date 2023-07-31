package baekjoon.dfs;

import java.util.Scanner;

public class Quiz16953 {
    private static int start;
    private static int goal;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = sc.nextInt();
        goal = sc.nextInt();

        makeCalc(start, 1);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void makeCalc(long result, int cnt) {
        if(result > goal) {
            return;
        }
        if (result == goal) {
            if (cnt < answer) {
                answer = cnt;
            }
            return;
        }

        makeCalc(result * 2, cnt + 1);
        makeCalc((result * 10) + 1, cnt + 1);
    }
}
