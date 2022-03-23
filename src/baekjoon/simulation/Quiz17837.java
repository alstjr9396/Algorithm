package baekjoon.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz17837 {

    private static int n;
    private static int k;
    private static int[][] maps;
    private static Horse[] horses;
    private static List<Integer>[][] nodes;
    private static int result = 0;
    private static int[] xpos = {1, -1, 0, 0};
    private static int[] ypos = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        k = input.nextInt();
        maps = new int[n][n];
        nodes = new List[n][n];
        horses = new Horse[k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maps[i][j] = input.nextInt();
                nodes[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < k; i++) {
            int y = input.nextInt()-1;
            int x = input.nextInt()-1;
            horses[i] = new Horse(x, y, input.nextInt()-1);
            nodes[y][x].add(i);
        }

        while (result < 1000) {
            result++;
            move();
        }
        System.out.println(-1);
    }

    private static void move() {
        for (int i = 0; i < k; i++) {
            int x = horses[i].x;
            int y = horses[i].y;
            int xx = x + xpos[horses[i].direction];
            int yy = y + ypos[horses[i].direction];

            if(checkReverse(horses[i], xx, yy)) {
                horses[i].changeDirection();
                int nx = x + xpos[horses[i].direction];
                int ny = y + ypos[horses[i].direction];
                if (checkReverse(horses[i], nx, ny)) {
                    continue;
                }
                i--;
                continue;
            }
            List<Integer> tmp = new ArrayList<>();
            for (int j = nodes[y][x].indexOf(i); j < nodes[y][x].size(); j++) {
                int index = nodes[y][x].get(j);
                horses[index].move(horses[i].direction);
                tmp.add(index);
            }

            nodes[y][x] = new ArrayList<>(nodes[y][x].subList(0, nodes[y][x].indexOf(i)));

            if (maps[yy][xx] == 1) {
                Collections.reverse(tmp);
                nodes[yy][xx].addAll(tmp);
            } else {
                nodes[yy][xx].addAll(tmp);
            }

            if (nodes[yy][xx].size() >= 4) {
                System.out.println(result);
                System.exit(0);
            }

        }

    }

    private static boolean checkReverse(Horse horse, int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n || maps[y][x] == 2) {
            return true;
        }
        return false;
    }

    protected static class Horse {
        protected int x;
        protected int y;
        protected int direction;

        Horse(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public void changeDirection() {
            if (direction == 0 || direction == 1) {
                direction = 1 - direction;
            } else {
                direction = 5 - direction;
            }
        }

        public void move(int direction) {
            x = x + xpos[direction];
            y = y + ypos[direction];
        }
    }
}
