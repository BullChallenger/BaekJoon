package Study;

import java.util.Scanner;

public class Mentoring {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int solve = 0;
        int[][] board = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int cnt = 0;
                for (int k = 0; k < M; k++) {
                    int rankI = 0;
                    int rankJ = 0;
                    for (int s = 0; s < N; s++) {
                        if (board[k][s] == i) {
                            rankI = s;
                            continue;
                        }
                        if (board[k][s] == j) {
                            rankJ = s;
                        }
                    }
                    if (rankI < rankJ) cnt++;
                }
                if (cnt == M) solve++;
            }
        }
        System.out.println(solve);
    }
}
