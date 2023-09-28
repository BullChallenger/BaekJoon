package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeOnlyAlphabet {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toLowerCase();
        char[] words = input.toCharArray();
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (!Character.isAlphabetic(words[start])) start++;
            else if (!Character.isAlphabetic(words[end])) end--;
            else {
                if (words[start] != words[end]) {
                    System.out.println("NO");
                    return;
                } else {
                    start++;
                    end--;
                }
            }
        }
        System.out.println("YES");
    }
}
