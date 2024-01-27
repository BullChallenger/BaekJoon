package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1697 {

    private static final boolean[] visited = new boolean[100001];
    private static final int[] board = new int[100001];
    private static final String[] dx = { "WALK", "BACK_WALK", "TELEPORT" };

    public static void main(String[] args) throws IOException {
        // 술래의 위치와 쫓기는 사람의 위치를 각각 입력받는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());
        board[K] = -1;

        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        BFS(N, K);
    }

    private static void BFS(int start, int K) {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[] {start, 1});
        visited[start] = true;

        while (!Q.isEmpty()) {
            int[] now = Q.poll();
            board[now[0]] = now[1];
            visited[now[0]] = true;

            if (now[0] - 1 == K || now[0] + 1 == K || now[0] * 2 == K) {
                System.out.println(now[1]);
                return;
            }

            if (!isOutOfBound(now[0] + 1) && !visited[now[0] + 1]) {
                Q.offer(new int[] {now[0] + 1, now[1] + 1});
            }
            if (!isOutOfBound(now[0] - 1) && !visited[now[0] - 1]) {
                Q.offer(new int[] {now[0] - 1, now[1] + 1});
            }
            if (!isOutOfBound(now[0] * 2) && !visited[now[0] * 2]) {
                Q.offer(new int[] {now[0] * 2, now[1] + 1});
            }
        }
    }

    private static boolean isOutOfBound(int next) {
        return next < 0 || next > board.length - 1;
    }

}
