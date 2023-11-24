package Study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 추억점수 {

    public static void main(String[] args) {
        String[] name = { "may", "kein", "kain", "radi" };
        int[] yearning = { 5, 10, 1, 3 };
        String[][] photo = { { "may", "kein", "kain", "radi" }, { "may", "kein", "brin", "deny" }, { "kon", "kain", "may", "coni" } };

        System.out.println(Arrays.toString(solution(name, yearning, photo)));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> personInPhoto = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            personInPhoto.put(name[i], yearning[i]);
        }

        int idx = 0;
        for (String[] pic : photo) {
            int score = 0;
            for (String person : pic) {
                if (personInPhoto.containsKey(person)) {
                    score += personInPhoto.get(person);
                }
            }
            answer[idx] = score;
            idx++;
        }

        return answer;
    }

}

