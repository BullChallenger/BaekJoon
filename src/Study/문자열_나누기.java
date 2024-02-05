package Study;

import java.util.HashMap;
import java.util.Map;

public class 문자열_나누기 {

    public static void main(String[] args) {
        String s = "banana";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        int answer = 0;

        char target = s.charAt(0);
        int targetNum = 0;
        int diff = 0;

        for (int i = 0; i < s.length(); i++) {
            if (targetNum == diff) {
                answer++;
                target = s.charAt(i);
            }
        }
        return answer;
    }

}
