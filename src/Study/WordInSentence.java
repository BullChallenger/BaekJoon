package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordInSentence {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String maxString = "";

        String[] words = input.split(" ");
        for (String str : words) {
            if (maxString.length() < str.length()) maxString = str;
        }

        System.out.println(maxString);
    }
}
