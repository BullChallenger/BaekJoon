package Study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토_BFS {

    private static int N, M;
    private static int[][] box;
    private static Queue<Point> Q = new LinkedList<>();
    private static int[] dx = { 1, 0, -1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    private static int result = Integer.MIN_VALUE;
    private static boolean flag;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        box = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int tomato = sc.nextInt();
                if (tomato == 1) {
                    Q.offer(new Point(i, j, 0));
                }
                box[i][j] = tomato;
            }
        }

        BFS();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void BFS() {
        while (!Q.isEmpty()) {
            Point current = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nxtX = current.x + dx[i];
                int nxtY = current.y + dy[i];

                if (nxtX >= 0 && nxtX < M && nxtY >= 0 && nxtY < N) {
                    if (box[nxtX][nxtY] != 0) continue;
                    Q.offer(new Point(nxtX, nxtY, current.day + 1));
                    box[nxtX][nxtY] = 1;
                    result = Math.max(result, current.day + 1);
                }
            }
        }
    }

    private static class Point {

        private int x;
        private int y;
        private int day;

        public Point(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

}
