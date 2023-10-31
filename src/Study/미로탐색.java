package Study;

import java.util.Scanner;

public class 미로탐색 {

    private static int[][] maze = new int[7][7];
    private static int[] dx = { 1, 0, -1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    private static boolean[][] visited = new boolean[7][7];
    private static int cnt = 0;

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

        DFS(0, 0);
        System.out.println(cnt);
    }

    private static void DFS(int x, int y) {
        if (maze[x][y] == 1) return;
        if (visited[x][y]) return;
        if (x == 6 && y == 6) {
            cnt++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            visited[x][y] = true;
            if (x + dx[i] < 0 || x + dx[i] >= 7 || y + dy[i] < 0 || y + dy[i] >= 7) {
                continue;
            }
            DFS(x + dx[i], y + dy[i]);
            visited[x][y] = false;
        }
    }

}
