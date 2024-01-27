package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BJ2667 {

    private static int[][] board;
    private static boolean[][] visited;

    private static final int[] dx = { 1, 0, -1, 0 };
    private static final int[] dy = { 0, 1, 0, -1 };
    private static final int ASCII = 48;
    private static final int HOUSE = 1;
    private static final int NOT_HOUSE = 0;

    public static void main(String[] args) throws IOException {
        // 지도의 크기 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.valueOf(br.readLine());
        // 단지의 수 확인
        int K = 0;

        // 지도 그리기
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.valueOf(row.charAt(j) - ASCII);
            }
        }
        // 방문 여부 판별을 위한 지도 별도로 그리기
        visited = new boolean[N][N];

        // 각 단지에 포함되는 집의 수를 저장할 자료 구조 생성
        List<Integer> town = new ArrayList<>();

        // 지도를 순회하며 1인 값을 발견하면 DFS / BFS 를 통해 단지 형성
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == HOUSE && !visited[i][j]) {
                    K++;
                    town.add(DFS(i, j, N, 1));
                }
                // 0이거나 이미 방문한 값을 발견하면 다음으로 넘어가기
            }
        }

        System.out.println(K);
        Collections.sort(town);
        town.forEach(System.out::println);
    }

    private static int DFS(int nowY, int nowX, int bound, int L) {
        // 방문 여부 체크하기
        visited[nowY][nowX] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = nowX + dx[i];
            int nextY = nowY + dy[i];

            // 인접한 집을 발견할 때마다 L의 값을 증가시킨다
            if (!isOutOfBound(nextY, nextX, bound) && board[nextY][nextX] == HOUSE && !visited[nextY][nextX]) {
                // 한 번의 탐색으로 발견한 집의 수를 저장하고 다음 탐색을 진행한다
                L = DFS(nextY, nextX, bound, L + 1);
            }
        }

        // 특정 지역의 탐색이 완료되면 해당 단지에서 발견한 집의 수를 반환한다
        return L;
    }

    private static boolean isOutOfBound(int nextY, int nextX, int bound) {
        return nextX < 0 || nextX >= bound || nextY < 0 || nextY >= bound ? true : false;
    }

}
