package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz15683 {

    private static int x;
    private static int y;
    private int min = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        String arr[][] = new String[y][x];

        for (int i = 0; i < y; i++) {
            arr[i] = br.readLine().split(" ");
        }

        search(0, arr);
    }

    public static void search(int count, String arr[][]) {
        int w = count % x;
        int h = count / x;

        if (arr[h][w].compareTo("0") == 1) {
            detect(arr[h][w], arr);
        }

    }

    private static void detect(String s, String[][] arr) {
        switch (s) {
            case "1" :

        }
    }
}
