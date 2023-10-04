package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class 괄호문자제거 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == ')') {
                Character target = stack.pop();
                while (target != '(') {
                    target = stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        Iterator<Character> words = stack.iterator();
        while (words.hasNext()) {
            System.out.print(words.next());
        }
    }
}
