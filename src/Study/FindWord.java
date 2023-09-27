package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindWord {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toLowerCase();
        char target = br.readLine().toLowerCase().charAt(0);
        int cnt = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == target) cnt++;
        }

        System.out.println(cnt);
    }
}
