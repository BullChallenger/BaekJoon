package Study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 가장_가까운_같은_글자 {

    public static void main(String[] args) {
        String s = "banana";
        System.out.println(Arrays.toString(solution(s)));
    }

    private static int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> alphaIdxMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (alphaIdxMap.getOrDefault(target, -1) == -1) {
                alphaIdxMap.put(target, i);
                answer[i] = -1;
            } else {
                answer[i] = i - alphaIdxMap.get(target);
                alphaIdxMap.put(target, i);
            }
        }

        return answer;
    }

}
