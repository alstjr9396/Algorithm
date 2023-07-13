package baekjoon.greedy;

import java.util.Scanner;

public class Quiz18185 {
    private static int n;
    private static int[] ramens;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ramens = new int[n + 2];

        for (int i = 0; i < n ; i++) {
            ramens[i] = sc.nextInt();
        }

        int j = 0;

        while(j < n) {
            chkCanPay(j);

            j++;
        }

        System.out.println(result);
    }

    private static void chkCanPay(int cur) {
        if (ramens[cur] <= 0) {
            return;
        }

        int twoPackCnt = Math.min(ramens[cur], ramens[cur + 1]);
        result += 3 * ramens[cur];
        result += 2 * twoPackCnt;
        ramens[cur + 1] -= twoPackCnt;

        int threePackCnt = Math.min(twoPackCnt, ramens[cur + 2] - Math.min(ramens[cur + 1], ramens[cur + 2]));
        result += 2 * threePackCnt;
        ramens[cur + 2] -= threePackCnt;
    }
}
