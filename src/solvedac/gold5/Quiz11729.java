package solvedac.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz11729 {

    private static StringBuilder sb = new StringBuilder();
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        hanoi(n, 1, 2, 3);

        System.out.println(cnt);
        System.out.println(sb);
    }

    public static void hanoi(int n, int d1, int d2, int d3) {
        cnt++;
        if (n == 1) {
            sb.append(d1 + " " + d3 + "\n");
            return;
        }

        hanoi(n - 1, d1, d3, d2);
        sb.append(d1 + " " + d3 + "\n");
        hanoi(n - 1, d2, d1, d3);
    }

}
