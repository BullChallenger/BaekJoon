package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 학급회장 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int maxVote = Integer.MIN_VALUE;
        char candi = 0;
        Map<Character, Integer> votes = new HashMap<>();

        for (int i = 0; i < N; i++) {
            votes.put(input.charAt(i), votes.getOrDefault(input.charAt(i), 0) + 1);
        }

        for (char key : votes.keySet()) {
            if (maxVote < votes.get(key)) {
                maxVote = votes.get(key);
                candi = key;
            }
        }
        System.out.println(candi);
    }
}
