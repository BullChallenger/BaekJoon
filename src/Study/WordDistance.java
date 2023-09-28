package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordDistance {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        String input = input();
        String sentence = input.split(" ")[0];
        char target = input.split(" ")[1].charAt(0);
        int[] answer = new int[sentence.length()];
        int pointer = sentence.length() + 1;

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == target) {
                pointer = 0;
            } else {
                pointer++;
            }
            answer[i] = pointer;
        }

        pointer = sentence.length() + 1;
        for (int i = sentence.length() - 1; i >= 0; i--) {
            if (sentence.charAt(i) == target) {
                pointer = 0;
            } else {
                pointer++;
                answer[i] = Math.min(answer[i], pointer);
            }
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    private static String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
