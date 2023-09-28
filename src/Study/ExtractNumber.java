package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractNumber {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = 0;
        for (char ch : input.toCharArray()) {
            if (ch >=48 && ch <= 57) answer = (answer * 10 + (ch - 48));
        }
        System.out.println(answer);
    }
}
