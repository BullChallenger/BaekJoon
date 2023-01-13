package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String sentence = br.readLine();

        StringBuilder sb = new StringBuilder();

        boolean flag = false;

        for (int i = 0; i < sentence.length(); i++) {
            char part = sentence.charAt(i);

            if (part == '<') {
                flag = true;
                while (!stack.isEmpty()) sb.append(stack.pop());
                sb.append(part);
            } else if (part == '>') {
                flag = false;
                sb.append(part);
            } else if (flag) sb.append(part);
            else if (!flag) {
                if (part == ' ') {
                    while(!stack.isEmpty()) sb.append(stack.pop());
                    sb.append(part);
                } else stack.push(part);
            }
        }

        while( !stack.isEmpty() ) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}
