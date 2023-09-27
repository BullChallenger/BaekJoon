package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AlphabetOnlyReverse {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String input = br.readLine();
        for (char ch : input.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                sb.append(" ");
                stack.push(ch);
            } else {
                sb.append(ch);
            }
        }

        for (char ch : sb.toString().toCharArray()) {
            if (Character.isWhitespace(ch)) {
                ch = stack.pop();
            }
            result.append(ch);
        }

        System.out.println(result.toString());
    }
}
