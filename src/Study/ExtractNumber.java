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
        int cnt = 0;
        input = input.replaceAll("[^0-9]", "");
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '0') {
                System.out.println(input.substring(cnt));
                return;
            } else {
                cnt++;
            }
        }
    }
}
