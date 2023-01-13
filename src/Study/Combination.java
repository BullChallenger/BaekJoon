package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Combination {
    public static void main(String[] args) throws IOException {
        final int N = 9;
        int[] height = new int[N];
        boolean[] visited = new boolean[N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(height);

        combination(height, visited, 0, N, 7);
    }

    private static void combination(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        if (depth == n) return;

        visited[depth] = true;
        combination(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        combination(arr, visited, depth + 1, n, r);
    }

    private static void print(int[] arr, boolean[] visited, int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
