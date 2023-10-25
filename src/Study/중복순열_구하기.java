package Study;

import java.util.Scanner;

public class 중복순열_구하기 {

    private static int N, M;
    private static int[] stones;
    private static int result;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        stones = new int[N];
        for (int i = 0; i < N; i++) {
            stones[i] = i + 1;
        }

        M = sc.nextInt();
        DFS(0, 0, 0);
    }

    private static void DFS(int stone, int L, int prev) {
        if (L == M) {
            System.out.print(prev + " " + stone);
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            DFS(stones[i], L + 1, stone);
        }
    }

}
