package Study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 경로탐색_DFS_인접리스트 {

    private static int N, M, result = 0;
    private static ArrayList<ArrayList<Integer>> graph;
    private static int[] visited;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        visited = new int[N + 1];
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            graph.get(y).add(x);
        }
        visited[1] = 1;
        DFS(1);
        System.out.println(result);
    }

    private static void DFS(int v) {
        if (v == N) result++;
        else {
            for (int node : graph.get(v)) {
                if (visited[node] == 0) {
                    visited[node] = 1;
                    DFS(node);
                    visited[node] = 0;
                }
            }
        }
    }

}
