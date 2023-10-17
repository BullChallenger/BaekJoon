package Study;

import java.util.Scanner;

public class 부분집합_재귀 {

    private static int N;
    private static int[] visited;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new int[N + 1];

        DFS(1);
    }

    private static void DFS(int root) {
        if (root == N + 1) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == 1) System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        visited[root] = 1;
        DFS(root + 1);
        visited[root] = 0;
        DFS(root + 1);
    }
}
