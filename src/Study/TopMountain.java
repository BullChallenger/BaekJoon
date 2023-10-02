package Study;

import java.util.Arrays;
import java.util.Scanner;

public class TopMountain {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N + 2][N + 2];
        int cnt = 0;

        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < N + 2; j++) {
                if (j == 0 || i == 0 || j == N + 1 || i == N + 1) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = sc.nextInt();
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (board[i][j] <= board[i - 1][j]) continue;
                if (board[i][j] <= board[i + 1][j]) continue;
                if (board[i][j] <= board[i][j - 1]) continue;
                if (board[i][j] <= board[i][j + 1]) continue;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
