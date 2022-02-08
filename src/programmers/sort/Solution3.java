package programmers.sort;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution3 {
    public static void main(String[] args) {

    }

    public int solution(int[] citations) {
        int answer = 0;
        int over = 0;
        Map<Integer, Integer> citationCount = new LinkedHashMap<>();
        for (int i = 0; i < citations.length - 1; i++) {
            for (int j = i+1; j < citations.length; j++) {
                if (citations[j] > citations[i]) {
                    int tmp = citations[j];
                    citations[j] = citations[i];
                    citations[i] = tmp;
                }
            }
        }

        for (int citation : citations) {
            citationCount.put(citation, citationCount.getOrDefault(citationCount.get(citation), 0) + 1);
        }
        for (int key : citationCount.keySet()) {
            over += citationCount.get(key);
            answer++;
            if (over >= key || over == citations.length) {
                answer = over;
                break;
            }
        }
        return answer;
    }

    public int bestSolution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= citations.length - i) {
                answer = citations.length - i;
                break;
            }
        }

        return answer;
    }
}
