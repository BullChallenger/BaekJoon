package Study;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로의_최단거리_통로_BFS {

    private static int[][] maze = new int[7][7];
    private static int[] dx = { 1, 0, -1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    private static boolean[][] visited = new boolean[7][7];
    private static Queue<Point> Q = new LinkedList<>();
    private static int[][] distance = new int[7][7];

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

        BFS(0, 0);
    }

    private static void BFS(int x, int y) {
        Q.offer(new Point(x, y));
        visited[x][y] = true;

        while (!Q.isEmpty()) {
            Point current = Q.poll();
            visited[current.x][current.y] = true;

            for (int i = 0; i < 4; i++) {
                int nxtX = current.x + dx[i];
                int nxtY = current.y + dy[i];

                if (nxtX < 0 || nxtX >= 7 || nxtY < 0 || nxtY >= 7) continue;
                if (maze[nxtX][nxtY] == 1) continue;
                if (visited[nxtX][nxtY]) continue;

                Q.offer(new Point(nxtX, nxtY));
                distance[nxtX][nxtY] = distance[current.x][current.y] + 1;
            }
        }

        if (distance[6][6] == 0) {
            System.out.println(-1);
        } else
            System.out.println(distance[6][6]);
    }

    private static class Point {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
