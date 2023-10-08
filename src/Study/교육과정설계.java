package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 교육과정설계 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String input = br.readLine();

        Queue<Character> queue = new ArrayDeque<>();
        for (char ch : target.toCharArray()) {
            queue.offer(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch == queue.peek()) queue.poll();
            if (queue.isEmpty()) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
