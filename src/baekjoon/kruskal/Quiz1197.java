package baekjoon.kruskal;

import java.util.*;

public class Quiz1197 {
    private static int n;
    private static int m;
    private static PriorityQueue<Node> queue = new PriorityQueue<Node>();
    private static int[] parent;
    private static long result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            queue.offer(new Node(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (findParent(node.getStart()) == findParent(node.getEnd())) {
                continue;
            }

            result += node.getCost();
            union(node.getStart(), node.getEnd());
        }

        System.out.println(result);
    }

    private static void union(int start, int end) {
        int startParent = findParent(start);
        int endParent = findParent(end);

        if (startParent < endParent) {
            parent[endParent] = startParent;
        }
        if (startParent >= endParent) {
            parent[startParent] = endParent;
        }
    }

    private static int findParent(int index) {
        if (parent[index] == index) {
            return index;
        }

        return findParent(parent[index]);
    }

    public static class Node implements Comparable<Node>{
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
