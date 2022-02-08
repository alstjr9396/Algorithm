package programmers.dfsandbfs;

public class Solution3 {
    int answer = 0;

    public int solution(String begin, String target, String[] words) {
        dfs(0, begin, target, words, 0);
        return answer;
    }

    public void dfs(int n, String begin, String target, String[] words, int count) {
        if (n == target.length()) {
            return;
        }
        for(int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == words[n].charAt(i) && begin.charAt(i) != target.charAt(i)) {
                String tmp = begin;
                StringBuilder stringBuilder = new StringBuilder(tmp);
                stringBuilder.setCharAt(i, target.charAt(i));
                if (tmp.equals(target)) {
                    if (answer == 0 || answer > count+1) {
                        answer = count+1;
                        return;
                    }
                }
                dfs(n++, tmp, target, words, count++);
            }
        }
        dfs(n++, begin, target, words, count);
    }

    class bestSolution {
        public int solution(String begin, String target, String[] words) {
            final boolean[] visited = new boolean[words.length];
            final int ans = dfs(begin, target, words, visited, 1, Integer.MAX_VALUE);
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }

        private int dfs(String begin, String target, String[] words, boolean[] visited, int cnt, int ans) {
            if (begin.equals(target)) {
                return cnt - 1;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && onlyOneDifferentChar(begin, words[i])) {
                    visited[i] = true;
                    ans = Math.min(ans, dfs(words[i], target, words, visited, cnt + 1, ans));
                    visited[i] = false;
                }
            }
            return ans;
        }

        private boolean onlyOneDifferentChar(String a, String b) {
            if (a.length() != b.length()) {
                return false;
            }

            int differentCnt = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    differentCnt++;
                }
            }
            return differentCnt == 1;
        }
    }
}
