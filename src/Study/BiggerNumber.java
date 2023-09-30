package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BiggerNumber {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                System.out.print(input[i] + " ");
                continue;
            }
            int x = Integer.parseInt(input[i]);
            int y = Integer.parseInt(input[i - 1]);

            if (x > y) System.out.print(x + " ");
        }
    }
}
