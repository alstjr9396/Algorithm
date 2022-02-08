package programmers.dfsandbfs;

public class Solution2 {
    int[] networks;

    public int mySolution(int n, int[][] computers) {
        int answer = 0;
        networks = new int[computers.length];
        for(int i = 0; i < computers.length; i++) {
            if(networks[i] == 1) {
                continue;
            }
            answer += dfs(i, computers);
        }
        return answer;
    }

    public int dfs(int x, int[][] computers) {
        networks[x] = 1;
        for(int i = 0; i < computers[x].length; i++) {
            if(x == i) {
                continue;
            }
            if(computers[x][i] == 1 && networks[i] != 1) {
                dfs(i, computers);
            }
        }
        return 1;
    }

    public class bestSolution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] chk = new boolean[n];
            for(int i = 0; i < n; i++) {
                if(!chk[i]) {
                    dfs(computers, chk, i);
                    answer++;
                }
            }
            return answer;
        }
        void dfs(int[][] computers, boolean[] chk, int start) {
            chk[start] = true;
            for(int i = 0; i < computers.length; i++) {
                if(computers[start][i] == 1 && !chk[i]) {
                    dfs(computers, chk, i);
                }
            }
        }
    }
}

