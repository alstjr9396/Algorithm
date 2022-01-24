package exhaustivesearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    private int answer = 0;
    private Map<String, Integer> numberMap = new HashMap<>();

    public static void main(String[] args) {
        /*
            best Solution : 순열 사용(내 풀이와 비슷)
         */
    }

    /*
        순열
        n개의 중에서 r개를 뽑는 경우
        순열의 순서가 보장되지 않는다.
     */
    private void permutation(String[] arr, int depth, int n, int r) {
        if (depth == r) {

            String number = "";
            for (int i = 0; i < r; i++) {
                number += arr[i];
            }
            numberMap.put(number, 1);
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    private int checkPrime(String number) {
        if (!number.startsWith("0") && !number.equals("1")) {
            System.out.println(number);
            int n = Integer.parseInt(number);
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return 0;
                }
            }
            return 1;
        }
        return 0;
    }

    private void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public int solution(String numbers) {
        String[] splits = numbers.split("");
        for (int i = 1; i <= splits.length; i++) {
            permutation(splits, 0, splits.length, i);
        }
        for (String key : numberMap.keySet()) {
            answer += checkPrime(key);
        }
        return answer;
    }
}
