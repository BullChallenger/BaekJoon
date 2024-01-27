package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {

    private static int[][] board;
    private static boolean[][] visited;
    private static Queue<Node> Q = new LinkedList<>();


    private static final int[] dx = { 1, 0, -1, 0 };
    private static final int[] dy = { 0, 1, 0, -1 };
    private static final String WHITE_SPACE = " ";
    private static final int FRESH_TOMATO = 1;
    private static final int NOT_FRESH_TOMATO = 0;
    private static final int EMPTY = -1;

    public static void main(String[] args) throws IOException {
        // 상자의 크기를 각각 입력받는다. 가로 M, 세로 N
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), WHITE_SPACE);
        int M = Integer.valueOf(st.nextToken());
        int N = Integer.valueOf(st.nextToken());
        // 토마토를 담을 상자와 방문 여부를 판별하는 방문 지도를 그린다
        board = new int[N][M];
        visited = new boolean[N][M];
        int result = 0;
        // 상자에 저장된 토마토들의 정보를 입력 받는다
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), WHITE_SPACE);
            for (int j = 0; j < M; j++) {
                if (st.hasMoreTokens()) {
                    board[i][j] = Integer.valueOf(st.nextToken());
                }
            }
        }
        // 하루가 지나면 잘 익은 토마토의 인접한 곳에 위치한 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (!visited[y][x] && board[y][x] == FRESH_TOMATO)
                {
                    Q.offer(new Node(x, y, 0));
                }
            }
        }
        result = BFS(N, M, 0);

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (board[y][x] == NOT_FRESH_TOMATO) {
                    result = -1;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    private static int BFS(int boundY, int boundX, int day) {
        // 방문 여부 판별
        while (!Q.isEmpty()) {
            Node now = Q.poll();
            visited[now.getY()][now.getX()] = true;
            day = now.getDay();
            // 인접한 곳에 존재하는 익지 않은 토마토를 확인한다
            for (int i = 0; i < 4; i++) {
                int nextY = now.getY() + dy[i];
                int nextX = now.getX() + dx[i];
                int nextDay = now.getDay() + 1;

                if (!isOutOfBound(nextY, nextX, boundY, boundX) &&
                    board[nextY][nextX] == NOT_FRESH_TOMATO &&
                    !visited[nextY][nextX]
                ) {
                    visited[nextY][nextX] = true;
                    board[nextY][nextX] = FRESH_TOMATO;
                    Q.offer(new Node(nextX, nextY, nextDay));
                }
            }
        }

        return day;
    }

    private static boolean isOutOfBound(int nextY, int nextX, int boundY, int boundX) {
        return nextY < 0 || nextY >= boundY || nextX < 0 || nextX >= boundX ? true : false;
    }

    private static class Node {
        private final int x;
        private final int y;
        private final int day;

        public Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDay() {
            return day;
        }
    }

}
