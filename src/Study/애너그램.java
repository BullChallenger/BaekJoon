package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 애너그램 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String input2 = br.readLine();

        int N = input.length();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
            map.put(input2.charAt(i), map.getOrDefault(input2.charAt(i), 0) + 1);
        }

        boolean isAnagram = true;
        for (char key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                isAnagram = false;
                System.out.println("NO");
                break;
            }
        }
        if (isAnagram) System.out.println("YES");
    }
}
