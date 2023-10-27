package Study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class 순열_구하기 {

    private static int N, M;
    private static int[] arr;
    private static int[] result;
    private static boolean[] visited;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0, -1);
    }

    private static void DFS(int L, int idx) {
        if (L == M) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < N; i++) {
            int current = arr[i];
            if (!visited[i]) {
                result[L] = current;
                visited[i] = true;
                DFS(L + 1, idx + 1);
                visited[i] = false;
            }
        }
    }

}
