package solvedac.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Quiz15686 {

    private static final List<int[]> houseList = new ArrayList<>();
    private static final List<int[]> storeList = new ArrayList<>();

    private static int max;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                int spot = Integer.parseInt(st.nextToken());
                if (spot == 1) {
                    houseList.add(new int[]{i, j});
                }
                if (spot == 2) {
                    storeList.add(new int[]{i, j});
                }
            }
        }

        pickStore(0, new ArrayList());

        System.out.println(min);
    }

    public static void pickStore(int start, List<int []> pickedStoreList) {
        if (pickedStoreList.size() == max) {
            chkDistance(pickedStoreList);
            return;
        }
        for (int i = start; i < storeList.size(); i++) {
            pickedStoreList.add(storeList.get(i));
            pickStore(i + 1, pickedStoreList);
            pickedStoreList.remove(pickedStoreList.size() - 1);
        }
    }

    public static void chkDistance(List<int[]> pickedStoreList) {
        int distance = 0;
        for (int[] house : houseList) {
            int tmp = Integer.MAX_VALUE;
            for (int[] store : pickedStoreList) {
                int x = Math.abs(store[0] - house[0]);
                int y = Math.abs(store[1] - house[1]);
                if (x + y < tmp) {
                    tmp = x + y;
                }
            }
            distance += tmp;
        }

        if (distance < min) {
            min = distance;
        }
    }
}
