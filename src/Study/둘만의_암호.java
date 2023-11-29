package Study;

import java.util.ArrayList;
import java.util.List;

public class 둘만의_암호 {

    public static void main(String[] args) {
        String s = "zzzz";
        String skip = "abcd";
        int index = 1;

        System.out.println(solution(s, skip, index));
    }

    private static String solution(String s, String skip, int index) {
        List<Character> skipAlphabet = new ArrayList<>();
        for (int i = 0; i < skip.length(); i++) {
            skipAlphabet.add(skip.charAt(i));
        }


        StringBuilder answer = new StringBuilder();
        for (char ch : s.toCharArray()) {
            for (int i = 0; i < index; i++) {
                ch = (char) (ch + 1);
                if (ch > 'z') ch = 'a';
                if (skipAlphabet.contains(ch)) {
                    while (skipAlphabet.contains(ch)) {
                        ch = (char) (ch + 1);
                        if (ch > 'z') ch = 'a';
                    }
                }
            }

            answer.append(ch);
        }

        return answer.toString();
    }

}
