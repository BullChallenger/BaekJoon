package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpperLowChange {
    private static String solution() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = "";

        try {
            input = br.readLine();

            for (int i = 0; i < input.length(); i++) {
                char theChar = input.charAt(i);
                if (Character.isUpperCase(theChar)) {
                    theChar = Character.toLowerCase(theChar);
                } else {
                    theChar =Character.toUpperCase(theChar);
                }
                sb.append(theChar);
            }

            return sb.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
