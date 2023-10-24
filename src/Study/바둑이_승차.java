package Study;

import java.util.Scanner;

public class 바둑이_승차 {

    private static int C, N;
    private static int[] dogs;
    private static int result;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        N = sc.nextInt();

        dogs = new int[N + 1];
        for (int i = 0; i < N; i++) {
            dogs[i] = sc.nextInt();
        }

        DFS(dogs[0], 0, 0);
        System.out.println(result);
    }

    private static void DFS(int root, int sum, int L) {
        if (sum > C) return;
        if (L == N) {
            result = Math.max(result, sum);
            return;
        }
        DFS(dogs[L + 1], sum + root, L + 1);
        DFS(dogs[L + 1], sum, L + 1);
    }

}
