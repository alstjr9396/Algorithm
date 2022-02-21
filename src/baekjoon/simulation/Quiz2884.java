package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz2884 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        minute -= 45;
        if (minute < 0) {
            minute += 60;
            hour--;
        }
        if (hour < 0) {
            hour = 23;
        }

        sb.append(hour);
        sb.append(" ");
        sb.append(minute);
        System.out.println(sb);

        br.close();
    }
}
