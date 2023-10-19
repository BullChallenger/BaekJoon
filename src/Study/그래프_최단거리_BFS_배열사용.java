package Study;

import java.util.*;

public class 그래프_최단거리_BFS_배열사용 {

    private static int N, M;
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int[] depth;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N + 1];
        depth = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            graph.get(y).add(x);
        }

        visited[1] = true;
        depth[1] = 0;
        BFS(1);
        for (int i = 2; i < depth.length; i++) {
            System.out.println(i + " :: " + depth[i]);
        }
    }

    private static void BFS(int root) {
        Queue<Integer> Q = new ArrayDeque<>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            int current = Q.poll();
            for (int node : graph.get(current)) {
                if (!visited[node]) {
                    visited[node] = true;
                    Q.offer(node);
                    depth[node] = depth[current] + 1;
                }
            }
        }
    }

}
