package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz10798 {
    public static void main(String[] args) throws IOException {
        String arr[][] = new String[5][];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine().split("");
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < arr[j].length) {
                    System.out.print(arr[j][i]);
                }
            }
        }
    }
}
