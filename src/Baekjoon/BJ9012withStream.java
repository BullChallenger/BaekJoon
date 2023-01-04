package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9012withStream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());

        long openCount = 0;
        long closeCount = 0;

        String brackets = br.readLine();

        openCount = brackets.chars().map(bracket -> (char) bracket).filter(bracket -> bracket == '(').count();
        closeCount = brackets.chars().map(bracket -> (char) bracket).filter(bracket -> bracket == ')').count();

        if (openCount - closeCount == 0) System.out.println("YES");
        else System.out.println("NO");
    }
}
