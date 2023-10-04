package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 아나그램_찾기 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();

        Map<Character, Integer> inputMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();

        for (char ch : target) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        int lt = 0;
        int cnt = 0;
        int K = target.length;

        for (int i = 0; i < K - 1; i++) {
            inputMap.put(input[i], inputMap.getOrDefault(input[i], 0) + 1);
        }

        for (int rt = K - 1; rt < input.length; rt++) {
            inputMap.put(input[rt], inputMap.getOrDefault(input[rt], 0) + 1);
            if (inputMap.entrySet().containsAll(targetMap.entrySet())) cnt++;
            inputMap.replace(input[lt], inputMap.get(input[lt]) - 1);
            if (input[lt] == 0) inputMap.remove(input[lt]);
            lt++;
        }

        System.out.println(cnt);
    }
}
