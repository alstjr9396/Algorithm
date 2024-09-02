package solvedac.gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * distance     minArr              answer      top     answerList
 * 1            1  				    1           1	    1 2 3
 * 2            1 1 				2	        1
 * 3            1 1 1 			    3	        1
 * 4            1 2 1			    3	        2	    3 4 5
 * 5            1 2 1 1 			4	        2
 * 6            1 2 2 1			    4	        2
 * 7            1 2 2 1 1			5	        2
 * 8            1 2 2 2 1			5	        2
 * 9            1 2 3 2 1			5	        3 	    5 6 7
 * 10           1 2 3 2 1 1		    6	        3
 * 11           1 2 3 2 2 1		    6	        3
 * 12           1 2 3 3 2 1		    6	        3
 * 13           1 2 3 3 2 1 1		7	        3
 * 14           1 2 3 3 2 2 1		7	        3
 * 15           1 2 3 3 3 2 1		7	        3
 * 16           1 2 3 4 3 2 1		7	        4	    7 8 9
 * 17           1 2 3 4 3 2 1 1		4           4
 * ```
 * ```
 * ```
 * 24           1 2 3 4 4 4 3 2 1	9 	        4
 * 25           1 2 3 4 5 4 3 2 1	9	        5	    9 10 11
 */
public class Quiz1011 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int distance = Y - X;

            int top = (int) Math.sqrt(distance);
            // top을 기준으로 좌우 대칭
            int comm = 0;
            for (int j = 1; j < top; j++) {
                comm += j;
            }
            comm *= 2;

            if (distance == comm + top) {
                sb.append(top * 2 - 1);
            } else if (distance <= comm + top * 2) {
                sb.append(top * 2);
            } else {
                sb.append(top * 2 + 1);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
