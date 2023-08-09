package baekjoon.dp;

import java.util.*;

public class Quiz1495 {
    private static int n;
    private static int cur;
    private static int max;
    private static int[] songLiist;
    private static Map<Integer, List<Integer>> dp = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cur = sc.nextInt();
        max = sc.nextInt();
        songLiist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            songLiist[i] = sc.nextInt();
        }

        dp.put(0, List.of(cur));
        for (int i = 1; i <= n; i++) {
            List<Integer> volumnList = new ArrayList<>();
            for (int volumn : dp.get(i - 1)) {
                if(volumn + songLiist[i] <= max) {
                    volumnList.add(volumn + songLiist[i]);
                }
                if(volumn - songLiist[i] >= 0) {
                    volumnList.add(volumn - songLiist[i]);
                }
            }
            if (volumnList.isEmpty()) {
                System.out.println("-1");
                return;
            }
            dp.put(i, volumnList);
        }

        System.out.println(dp.get(n).stream().max(Integer::compareTo).get());
    }
}
