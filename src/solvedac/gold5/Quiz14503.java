package solvedac.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz14503 {

    public static String[][] map;
    public static int x;
    public static int y;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new String[y][x];

        st = new StringTokenizer(br.readLine(), " ");
        int ry = Integer.parseInt(st.nextToken());
        int rx = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                map[i][j] = st.nextToken();
            }
        }

        map[ry][rx] = "2";
        while (true) {
            boolean isPassed = false;
            for (int i = 1; i <= 4; i++) {
                int head = (direction  + 4 - i) % 4;
                int ny = ry + dy[head];
                int nx = rx + dx[head];
                if (ny >= y || ny < 0 || nx >= x || nx < 0 || !map[ny][nx].equals("0")) {
                    continue;
                }
                answer++;
                map[ny][nx] = "2";
                ry = ny;
                rx = nx;
                direction = head;
                isPassed = true;
                break;
            }

            if (isPassed) {
                continue;
            }

            int by = ry + dy[direction] * -1;
            int bx = rx + dx[direction] * -1;
            if (by >= y || by < 0 || bx >= x || bx < 0 || map[by][bx].equals("1")) {
                break;
            }
            ry = by;
            rx = bx;
        }

        System.out.println(answer);
    }
}
