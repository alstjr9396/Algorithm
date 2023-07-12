package baekjoon.greedy;

import java.util.Scanner;

public class Quiz1700 {
    private static int n;
    private static int m;
    private static int[] products;
    private static int[] plugins;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        plugins = new int[n];
        products = new int[m];

        for (int i = 0; i < m ; i++) {
            products[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            if(chkPluggedIn(i)) {
                continue;
            }
            unplug(i);
        }

        System.out.println(result);
    }

    private static boolean chkPluggedIn(int cur) {
        for (int i = 0; i < n; i++) {
            if (plugins[i] == 0) {
                plugins[i] = products[cur];
                return true;
            }
            if (plugins[i] == products[cur]) {
                return true;
            }
        }
        return false;
    }

    private static void unplug(int i) {
        int gap = 0;
        int cursor = 0;
        for (int j = 0; j < n; j++) {
            int temp = chkContains(i, j);
            if (temp == 0) {
                plugins[j] = products[i];
                result += 1;
                return;
            }
            if (gap < temp) {
                gap = temp;
                cursor = j;
            }
        }

        plugins[cursor] = products[i];
        result += 1;
    }

    private static int chkContains(int start, int cur) {
        for (int i = start; i < m; i++) {
            if (products[i] == plugins[cur]) {
                return i - start;
            }
        }
        return 0;
    }
}
