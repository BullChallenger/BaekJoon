package Study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 대충만든자판 {

    public static void main(String[] args) {
        String[] keymap = { "AGZ", "BSSS" };
        String[] targets = { "ASA","BGZ" };
        System.out.println(Arrays.toString(solution(keymap, targets)));
    }

    private static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> keyboard = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            String target = keymap[i];
            for (int j = 0; j < target.length(); j++) {
                char key = target.charAt(j);
                if (keyboard.containsKey(key)) {
                    keyboard.replace(key, Math.min(keyboard.get(key), j + 1));
                }
                else {
                    keyboard.put(key, j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int total = 0;
            boolean flag = true;

            for (char key : target.toCharArray()) {
                if (keyboard.containsKey(key)) {
                    total += keyboard.get(key);
                }
                else {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                answer[i] = -1;
            } else {
                answer[i] = total;
            }
        }

        return answer;
    }

}
