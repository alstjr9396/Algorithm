package solvedac.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Quiz1759 {

    public static String[] alpha;
    public static String[] alpha1 = {"a", "i", "o", "u", "e"};

    public static int L;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        alpha = new String[C];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken();
        }
        Arrays.sort(alpha);

        for (int i = 0; i < C; i++) {
            makeSecret(i, alpha[i]);
        }
    }

    public static void makeSecret(int index, String secret) {
        if (secret.length() == L) {
            if (validateSecret(secret)) {
                System.out.println(secret);
            }
            return;
        }
        if (index + 1 == alpha.length) {
            return;
        }
        for (int i = index + 1; i < alpha.length; i++) {
            makeSecret(i, secret + alpha[i]);
        }
    }

    public static boolean validateSecret(String secret) {
        int alpha1Cnt = 0;
        for (int i = 0; i < secret.length(); i++) {
            for (int j = 0; j < alpha1.length; j++) {
                if (alpha1[j].equals(String.valueOf(secret.charAt(i)))) {
                    alpha1Cnt++;
                    break;
                }
            }
        }

        if (alpha1Cnt >= 1 && alpha1Cnt <= secret.length() - 2) {
            return true;
        }

        return false;
    }

}
