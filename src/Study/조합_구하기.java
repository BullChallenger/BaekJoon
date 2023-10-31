package Study;

import java.util.Scanner;

public class 조합_구하기 {

    private static int N, M;
    private static int[] arr, result;
    private static boolean[] visited;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        visited = new boolean[N + 1];
        result = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        DFS(0, 0);
    }

    private static void DFS(int current, int L) {
        if (L == M) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = current; i < N; i++) {
            if (!visited[arr[i]]) {
                visited[arr[i]] = true;
                result[L] = arr[i];
                DFS(arr[i], L + 1);
                visited[arr[i]] = false;
                result[L] = 0;
            }
        }
    }

}
