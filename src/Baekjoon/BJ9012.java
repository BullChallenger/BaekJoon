package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < T; i++) {
            boolean isVPS = true;
            String brackets = br.readLine();
            for (int j = 0; j < brackets.length(); j++) {
                char target = brackets.charAt(j);
                if (target == '(') {
                    stack.push(target);
                } else {
                    if (!stack.empty()) stack.pop();
                    else {
                        isVPS = false;
                        break;
                    }
                }
            }
            if (!stack.empty()) {
                isVPS = false;
            }
            if (isVPS) System.out.println("YES");
            else System.out.println("NO");
           stack.clear();
        }
    }
}
