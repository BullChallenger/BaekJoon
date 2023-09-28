package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Secret {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        for (int i = 0; i < N; i++) {
            String temp = input.substring(0, 7).replace('#', '1').replace('*', '0');
            char binaryChar = (char) Integer.parseInt(temp, 2);
            sb.append(binaryChar);
            input = input.substring(7);
        }
        System.out.println(sb);
    }
}
