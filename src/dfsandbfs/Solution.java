package dfsandbfs;

public class Solution {
    int[] arr;
    int answer = 0;

    public int solution(int[] numbers, int target) {
        arr = numbers;

        dfs(0, 0, target);

        return answer;
    }

    public void dfs(int sum, int i, int target) {
        if(i == arr.length) {
            if(sum == target) answer++;
            return;
        }

        dfs(sum+arr[i], i+1, target);
        dfs(sum-arr[i], i+1, target);
    }
}
