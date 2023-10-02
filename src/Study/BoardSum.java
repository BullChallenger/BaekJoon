package Study;

import java.util.Scanner;

public class BoardSum {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N][N];
        int max = 0;
        int sum = 0;
        int sum2 = 0;

        for (int i = 0; i < N; i++) {
            sum = 0;
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
                sum += board[i][j];
            }
            if (sum > max) max = sum;
        }

        for (int i = 0; i < N; i++) {
            sum = 0;
            for (int j = 0; j < N; j++) {
                sum += board[j][i];
            }
            if (sum > max) max = sum;
        }

        sum = 0;
        for (int i = 0; i < N; i++) {
            sum += board[i][i];
            sum2 += board[N - 1 - i][i];
        }
        if (sum > max) max = sum;
        if (sum2 > max) max = sum2;

        System.out.println(max);
    }
}
