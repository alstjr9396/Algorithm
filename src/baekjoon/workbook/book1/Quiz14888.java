package baekjoon.workbook.book1;

import java.util.Scanner;

public class Quiz14888 {
    private static int n;
    private static int[] num;
    private static int[] sign = new int[4];

    private static long min = 10000000000000l;

    private static long max = -10000000000000l;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n];

        for (int i = 0; i < n ; i++) {
            num[i] = sc.nextInt();
        }
        for (int i = 0; i < 4 ; i++) {
            sign[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            if(sign[i] -1 >= 0) {
                makeExpression(1, num[0], i);
                sign[i] += 1;
            }
        }

        System.out.println(max);
        System.out.println(min);
    }

    private static void makeExpression(int i, long result, int direction) {
        if(i >= n) {
            chkResult(result);
            return;
        }
        sign[direction] -= 1;

        result = calc(i, result, direction);

        int cnt = 0;
        for (int j = 0; j < 4; j++) {
            if(sign[j] -1 >= 0) {
                makeExpression(i+1, result, j);
                sign[j] += 1;
            } else {
                cnt++;
            }
        }
        if (cnt == 4) {
            chkResult(result);
        }

    }

    private static void chkResult(long result) {
        if(result < min) {
            min = result;
        }

        if(result > max) {
            max = result;
        }
    }

    private static long calc(int i, long result, int direction) {
        if (direction == 0) {
            return result + num[i];
        }
        if (direction == 1) {
            return result - num[i];
        }
        if (direction == 2) {
            return result * num[i];
        }
        if (direction == 3) {
            return result / num[i];
        }

        return result;
    }
}
