package dfsandbfs;

import java.util.*;

public class Solution4 {
    public static void main(String[] args) {
        /*
            (x)
         */
    }

    List<String> answer;
    public String[] solution(String[][] tickets) {
        Map<String, List<String>> route = new HashMap<>();
        Arrays.stream(tickets).sorted((t1, t2) -> {
            if (t1[0] == t2[0]) {
                return t1[1].compareTo(t2[1]);
            }
            return t1[0].compareTo(t2[0]);
        });
        for (String[] ticket : tickets) {
            if (route.containsKey(ticket[0])) {
                route.get(ticket[0]).add(ticket[1]);
            } else {
                List<String> tmp = new ArrayList<>(Arrays.asList(ticket[1]));
                route.put(ticket[0], tmp);
            }
        }
        dfs(route, new ArrayList<>(Arrays.asList("ICN")), "ICN", tickets.length);
        return (String[]) answer.stream().toArray();
    }

    public void dfs(Map<String, List<String>> route, List<String> cities, String start, int total) {
        if(cities.size() == total+1) {
            answer = new ArrayList<>(cities);
            return;
        }
        if (!route.get(start).isEmpty()) {
            for (String city : route.get(start)) {
                Map<String, List<String>> tmp = new HashMap<>(route);
                tmp.get(start).remove(city);
                List<String> tmpList = new ArrayList<>(cities);
                tmpList.add(city);
                dfs(tmp, tmpList, city, total);
            }
        }
    }

    class bestSolution {
        public String[] solution(String[][] tickets) {
            String[] answer = new String[tickets.length+1];
            String[] s = new String[tickets.length];
            boolean[] visited = new boolean[tickets.length];
            for(int i=0;i<tickets.length;i++)
                s[i] = tickets[i][0] + tickets[i][1];
            Arrays.sort(s);
            for(int i=0;i<s.length;i++) {
                tickets[i][0] = s[i].substring(0,3);
                tickets[i][1] = s[i].substring(3,6);
            }
            find("ICN",tickets,answer,visited,0);
            return answer;
        }
        public boolean find(String s, String[][] tickets, String[] answer, boolean[] visited, int cnt) {
            answer[cnt] = s;
            if(cnt == answer.length-1) {
                return true;
            }
            for(int i=0;i<tickets.length;i++) {
                if(answer[cnt].equals(tickets[i][0]) && visited[i] == false) {
                    visited[i] = true;
                    if(find(tickets[i][1],tickets,answer,visited,cnt+1))
                        return true;
                    visited[i] = false;
                }
            }
            return false;
        }
    }
}
