package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SentenceCompression {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        char[] words = input.toCharArray();
        int cnt = 1;

        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                sb.append(words[i]);
            }
            else if (words[i] != words[i - 1]) {
                if (cnt != 1) sb.append(cnt);
                sb.append(words[i]);
                cnt = 1;
            }
            else cnt++;
        }
        if (cnt != 1) sb.append(cnt);
        System.out.println(sb);
    }
}
