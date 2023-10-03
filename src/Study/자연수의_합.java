package Study;

import java.util.Scanner;

public class 자연수의_합 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = N / 2 + 1;
        int[] board = new int[M];
        for (int i = 0; i < M; i++) {
            board[i] = i + 1;
        }

        int rp;
        int lp = 0;
        int sum = 0;
        int cnt = 0;

        for (rp = 0; rp < M; rp++) {
            sum += board[rp];
            if (sum == N) {
                cnt++;
                sum -= board[lp++];
            }
            while (sum >= N) {
                sum -= board[lp++];
                if (sum == N) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
