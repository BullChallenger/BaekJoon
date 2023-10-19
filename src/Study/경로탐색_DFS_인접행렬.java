package Study;

import java.util.Scanner;

public class 경로탐색_DFS_인접행렬 {

    private static int N, M, result = 0;
    private static int[][] graph;
    private static int[] visited;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N + 1][N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            graph[y][x] = 1;
        }
        visited[1] = 1;
        DFS(1);
        System.out.println(result);
    }

    private static void DFS(int v) {
        if (v == N) result++;
        else {
            for (int i = 1; i <= N; i++) {
                if (graph[v][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    DFS(i);
                    visited[i] = 0;
                }
            }
        }
    }

}
