package baekjoon.bruteforce;

import java.util.*;

public class Quiz1062 {
    private static int n;
    private static int k;
    private static List<String> words = new ArrayList<>();
    private static int result = 0;
    private static List<Character> alphabet = new ArrayList<>();
    private static final String REGEX = "[antic]";
    private static Set<Character> visit = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String word = sc.nextLine().replaceAll(REGEX, "");
            words.add(word);
            extractAlphabet(word);
        }

        // 모든 알파벳를 배울 수 있을때
        if (k == 26) {
            System.out.println(n);
            return;
        }

        // 기본 알파벳를 배울 수 없을떄
        if (k < 5) {
            System.out.println(0);
            return;
        }

        // 기본 알파벳만 배울 수 있을때
        if (k == 5) {
            System.out.println(words.stream().filter(s -> s.length() == 0).count());
            return;
        }

        // 배울 수 있는 알파벳이 배워야할 알파벳보다 많을때
        if (alphabet.size() <= k - 5) {
            System.out.println(n);
            return;
        }

        selectAlpha(0);

        System.out.println(result);
    }

    private static void extractAlphabet(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!alphabet.contains(word.charAt(i))) {
                alphabet.add(word.charAt(i));
            }
        }
    }

    private static void selectAlpha(int i) {
        if (visit.size() >= k - 5 || i >= alphabet.size()) {
            getMakeWordCnt();
            return;
        }

        for (int j = i; j < alphabet.size(); j++) {
            visit.add(alphabet.get(j));
            selectAlpha(j + 1);
            visit.remove(alphabet.get(j));
        }
    }

    private static void getMakeWordCnt() {
        int cnt = 0;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() == 0) {
                cnt++;
                continue;
            }
            if (hasCharacter(words.get(i))) continue;
            cnt++;
        }
        if (cnt  > result) {
            result = cnt;
        }
    }

    private static boolean hasCharacter(String temp) {
        for (int j = 0; j < temp.length(); j++) {
            if (!visit.contains(temp.charAt(j))) {
                return true;
            }
        }
        return false;
    }
}
