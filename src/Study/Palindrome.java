package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toLowerCase();
        char[] words = input.toCharArray();

        for (int i = 0; i < input.length() / 2; i++) {
            if (words[i] != words[input.length() - i - 1]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
