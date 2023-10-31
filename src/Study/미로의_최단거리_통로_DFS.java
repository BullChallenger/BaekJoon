package Study;

import java.util.Scanner;

public class 미로의_최단거리_통로_DFS {

    private static int[][] maze = new int[7][7];
    private static int[] dx = { 1, 0, -1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    private static boolean[][] visited = new boolean[7][7];
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        DFS(0, 0, 0);
        if (result == Integer.MAX_VALUE) result = -1;
        System.out.println(result);
    }

    private static void DFS(int x, int y, int distance) {
        if (x == 6 && y == 6) {
            result = Math.min(distance, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nxtX = dx[i] + x;
            int nxtY = dy[i] + y;

            if (nxtX < 0 || nxtX >= 7 || nxtY < 0 || nxtY >= 7) continue;
            if (maze[nxtX][nxtY] == 1) continue;
            if (visited[nxtX][nxtY]) continue;
            visited[nxtX][nxtY] = true;

            DFS(nxtX, nxtY, distance + 1);
            visited[nxtX][nxtY] = false;
        }
    }

}
