package solvedac.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz1074 {

    public static int cnt = 0;
    public static int x;
    public static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        divide(n, 0, 0);
    }

    public static void divide(int n, int yy, int xx) {
        if (n == 1) {
            System.out.println(cnt);
            return;
        }

        int length = n / 2;
        int quadrant = length * length;
        if (x < xx + length) {
            if (y < yy + length) {
                divide(n / 2, yy, xx);
            } else {
                cnt += quadrant * 2;
                divide(n / 2, yy + length, xx);
            }
        } else {
            if (y < yy + length) {
                cnt += quadrant;
                divide(n / 2, yy, xx + length);
            } else {
                cnt += quadrant * 3;
                divide(n / 2, yy + length, xx + length);
            }
        }
    }
}
