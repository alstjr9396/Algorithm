package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz2490 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                sum += Integer.parseInt(st.nextToken());
            }
            switch (sum) {
                case 4:
                    System.out.println("E");
                    break;
                case 3:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 1:
                    System.out.println("C");
                    break;
                case 0:
                    System.out.println("D");
                    break;
            }
        }
        br.close();
    }
}
