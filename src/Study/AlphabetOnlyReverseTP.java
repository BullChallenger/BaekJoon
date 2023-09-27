package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlphabetOnlyReverseTP {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] chars = input.toCharArray();
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (!Character.isAlphabetic(chars[start])) start++;
            else if (!Character.isAlphabetic(chars[end])) end--;
            else {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        System.out.println(chars);
    }
}
