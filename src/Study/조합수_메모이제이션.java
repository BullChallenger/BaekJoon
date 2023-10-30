package Study;

import java.util.Scanner;

public class 조합수_메모이제이션 {

    private static int N, R;
    private static int[][] visited;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        visited = new int[N + 1][N + 1];
        System.out.println(DFS(N, R));
    }

    private static int DFS(int N, int R) {
        if (visited[N][R] != 0) return visited[N][R];
        if (N == R || R == 0) return 1;
        return visited[N][R] = DFS(N - 1, R - 1) + DFS(N - 1, R);
    }

}
