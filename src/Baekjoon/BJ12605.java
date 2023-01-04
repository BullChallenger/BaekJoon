package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ12605 {

    private static final String PREFIX = "Case #";
    private static final String WHITE_SPACE = " ";
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {

            StringBuilder sb = new StringBuilder();

            stack.clear();

            String sentence = br.readLine();
            sb.append(PREFIX).append(i).append(":").append(" ");

            String[] splitedString = sentence.split(WHITE_SPACE);

            for (String s : splitedString) stack.push(s);

            int size = stack.size();

            for (int j = 0; j < size; j++) sb.append(stack.pop()).append(" ");

            System.out.println(sb);
        }
    }
}
