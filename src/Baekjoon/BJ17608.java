package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ17608 {
    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        int max = 0;
        int count = 1;

        for (int i = 0; i < N; i++) {
            int stickLength = Integer.parseInt(br.readLine());
            stack.push(stickLength);
        }

        max = stack.pop();

        for (int i = 0; i < N - 1; i++) {
            int stickLength = stack.pop();
            if (stickLength > max) {
                count++;
                max = stickLength;
            }
        }

        System.out.println(count);
    }
}
