package baekjoon.dijkstra;

import java.util.*;

public class Quiz1916 {
    private static int n;
    private static int m;
    private static int start;
    private static int end;
    private static List<Bus>[] busList;
    private static long[] costs;
    private static boolean[] visit;
    private static PriorityQueue<Bus> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        costs = new long[n + 1];
        visit = new boolean[n + 1];
        busList = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            busList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            busList[sc.nextInt()].add(new Bus(sc.nextInt(), sc.nextInt()));
        }
        start = sc.nextInt();
        end = sc.nextInt();

        Arrays.fill(costs, Long.MAX_VALUE);
        costs[start] = 0;
        queue.offer(new Bus(start, 0));
        while (queue.size() > 0) {
            Bus bus = queue.poll();
            if (visit[bus.getDestination()]) {
                continue;
            }
            visit[bus.getDestination()] = true;

            for (Bus b : busList[bus.getDestination()]) {
                if (costs[b.getDestination()] > costs[bus.getDestination()] + b.getCost()) {
                    costs[b.getDestination()] = costs[bus.getDestination()] + b.getCost();

                    queue.offer(new Bus(b.getDestination(), costs[b.getDestination()]));
                }
            }
        }

        System.out.println(costs[end]);
    }

    protected static class Bus implements Comparable<Bus>{
        private int destination;
        private long cost;

        public Bus(int destination, long cost) {
            this.destination = destination;
            this.cost = cost;
        }

        public int getDestination() {
            return destination;
        }

        public long getCost() {
            return cost;
        }

        @Override
        public int compareTo(Bus o) {
            return Long.compare(this.cost, o.cost);
        }
    }
}
