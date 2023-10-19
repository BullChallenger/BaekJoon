package Study;

import java.util.*;

public class 그래프_최단거리_BFS_레벨로_풀기 {

    private static int N, M;
    private static int[] visited;
    private static int[] depth;
    private static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new int[N + 1];
        depth = new int[N + 1];
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < M; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            graph.get(y).add(x);
        }

        visited[1] = 1;
        BFS(1);
        for(int i = 2; i < depth.length; i++) {
            System.out.println(i + " : " + depth[i]);
        }
    }

    private static void BFS(int root) {
        int L = 0;
        Queue<Integer> Q = new ArrayDeque<>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int current = Q.poll();
                depth[current] = L;
                for (int node : graph.get(current)) {
                    if (visited[node] == 0) {
                        Q.offer(node);
                        visited[node] = 1;
                    }
                }
            }
            L++;
        }
    }

}
