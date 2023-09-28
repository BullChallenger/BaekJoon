package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeWithReverse {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String temp = new StringBuilder(input).reverse().toString();

        if (input.equalsIgnoreCase(temp)) System.out.println("YES");
        else System.out.println("NO");
    }
}
