package baekjoon.kmp;

import java.util.Scanner;

public class Quiz16916 {
    private static String str;
    private static String pattern;
    private static int[] pi;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        pattern = sc.nextLine();
        pi = new int[pattern.length()];
        getPi();

        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            while(j > 0 && str.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if(str.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length() - 1) {
                    result = 1;
                    break;
                }else{
                    j++;
                }
            }
        }

        System.out.println(result);
    }

    public static void getPi(){
        int j = 0;
        for(int i = 1; i < pattern.length(); i++){
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = pi[j-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)){
                pi[i] = ++j;
            }
        }
    }
}
