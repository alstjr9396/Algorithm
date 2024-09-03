package solvedac.gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Quiz1013 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String pattern = br.readLine();

            boolean isSTAR_VEGA;
            if (pattern.charAt(0) == '1') {
                isSTAR_VEGA = chkSTAR_VEGA(pattern, 0, 1);
            } else {
                isSTAR_VEGA = chkSTAR_VEGA(pattern, 0, 0);
            }

            if (isSTAR_VEGA) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean chkSTAR_VEGA(String pattern, int index, int type) {
        boolean result = false;
        if (type == 1) {
            if (index + 1 >= pattern.length() || index + 2 >= pattern.length() || index + 3 >= pattern.length()) {
                return false;
            }
            if (pattern.charAt(index + 1) != '0' || pattern.charAt(index + 2) != '0') {
                return false;
            }
            int pass = index + 3;
            while (pass < pattern.length() && pattern.charAt(pass) == '0') {
                pass++;
            }
            if (pass >= pattern.length() || pattern.charAt(pass) != '1') {
                return false;
            }

            if (pass == pattern.length() - 1 && pattern.charAt(pass) == '1') {
                return true;
            }

            int next = pass + 1;
            while (next < pattern.length() && pattern.charAt(next) == '1') {
                if (next == pattern.length() - 1) {
                    return true;
                }
                result = chkSTAR_VEGA(pattern, next, 1);
                if (result) {
                    return true;
                }
                next++;
            }
            result = chkSTAR_VEGA(pattern, next, 0);

        }

        if (type == 0) {
            if (index + 1 >= pattern.length()) {
                return false;
            }
            if (pattern.charAt(index + 1) != '1') {
                return false;
            }
            if (index + 1 == pattern.length() - 1) {
                return true;
            }
            if (pattern.charAt(index + 2) == '1') {
                result = chkSTAR_VEGA(pattern, index + 2, 1);
            } else {
                result = chkSTAR_VEGA(pattern, index + 2, 0);
            }
        }

        return result;
    }

}
