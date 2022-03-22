package baekjoon.dfs;

import java.util.Scanner;

public class Quiz14500 {

    static int n; // 세로크기
    static int m; // 가로크기
    static int[][] maps;
    static boolean[][] checked;
    static int result = 0;

    // 왼쪽 오른쪽 위 아래 순으로 한칸 움직였을 때
    static int[] dx = {0, 0, -1, 1}; // 세로
    static int[] dy = {-1, 1, 0, 0}; // 가로

    // ㅜ 일때 모든 경우 (ㅜ,ㅗ,ㅓ,ㅏ 순)
    static int[][] ex = {{0, 0, 0, 1}, {1, 1, 1, 0}, {0, 1, 2, 1}, {0, 1, 2, 1}}; //세로
    static int[][] ey = {{0, 1, 2, 1}, {0, 1, 2, 1}, {1, 1, 1, 0}, {0, 0, 0, 1}}; //가로

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        m = input.nextInt();
        maps = new int[n][m];
        checked = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                maps[i][j] = input.nextInt();
            }
        }

        // 4가지는 dfs (depth=4인)
        // ㅜ 모양은 따로 구해줌
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {

                // 4가지 모양
                checked[i][j] = true;
                dfs(i, j, maps[i][j], 1);
                checked[i][j] = false;

                // ㅜ 모양
                exceptionCase(i, j);
            }
        }

        System.out.println(result);

    }

    // ㅜ를 제외한 4가지 경우 (dfs를 이용하여 모든 경우를 만들 수 있음)
    static void dfs(int x, int y, int sum, int depth) {
        if(depth >= 4) {
            result = Math.max(result, sum);
            return;
        }
        else {
            int nx, ny;
            // 지금 방향에서 왼쪽 오른쪽 위 아래 방향으로 1칸 움직임
            for(int i=0; i<4; i++) {
                nx = x + dx[i]; // 세로
                ny = y + dy[i]; // 가로

                // 종이 범위 넘어가는지 확인
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;

                // 방문한적 없으면
                if(!checked[nx][ny]) {
                    checked[nx][ny] = true;
                    dfs(nx, ny, (sum+maps[nx][ny]), depth+1);

                    // 체크 해제
                    checked[nx][ny] = false;
                }
            }
        }
    }

    // ㅜ,ㅗ,ㅓ,ㅏ 모양 검사
    static void exceptionCase(int x, int y) {
        int nx, ny, sum;
        boolean outCheck = false;

        for(int i=0; i<4; i++) {
            sum = 0;
            outCheck = false;
            for(int j=0; j<4; j++) {
                nx = x + ex[i][j]; // 세로
                ny = y + ey[i][j]; // 가로

                // 종이 범위 넘어가는지 체크
                if(nx<0 || nx>=n || ny<0 || ny>=m) {
                    outCheck = true;
                    continue;
                }

                sum += maps[nx][ny];
            }

            // 범위 안나갔으면
            if(!outCheck)
                result = Math.max(sum, result);
        }
    }
}
