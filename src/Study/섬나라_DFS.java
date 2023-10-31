package Study;

import java.util.Scanner;

public class 섬나라_DFS {

    private static int N;
    private static int[][] island;
    private static boolean[][] visited;
    private static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
    private static int[] dy = { 0, 1, 0, -1, -1, 1, -1, 1 };
    private static int result = 0;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        island = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                island[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (island[i][j] == 1 && !visited[i][j]) {
                    DFS(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);

    }

    private static void DFS(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int nxtX = dx[i] + x;
            int nxtY = dy[i] + y;

            if (nxtX >= 0 && nxtX < N && nxtY >= 0 && nxtY < N) {
                if (island[nxtY][nxtX] != 0 && !visited[nxtY][nxtX]) {
                    DFS(nxtY, nxtX);
                }
            }
        }
    }

}
