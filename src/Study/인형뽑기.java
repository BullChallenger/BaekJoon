package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 인형뽑기 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(br.readLine());
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int location = Integer.parseInt(st.nextToken()) - 1;
            int depth = 0;
            while (depth < N) {
                if (board[depth][location] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[depth][location]);
                    } else if (stack.peek() == board[depth][location]) {
                        stack.pop();
                        cnt++;
                    } else {
                        stack.push(board[depth][location]);
                    }
                    board[depth][location] = 0;
                    break;
                }
                depth++;
            }
        }

        System.out.println(cnt * 2);
    }
}
