package Study;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 동전교환 {

    private static int N, M;
    private static Integer[] coins;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        coins = new Integer[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder());
        M = sc.nextInt();

        DFS(0,  0);
        System.out.println(result);
    }

    private static void DFS(int sum, int L) {
        if (sum > M) return;
        if (L > result) return;
        if (sum == M) {
            result = Math.min(L, result);
            return;
        }

        for (int i = 0; i < N; i++) {
            int next = coins[i];
            DFS(sum + next, L + 1);
        }
    }
}
