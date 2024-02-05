package Study;

import java.util.*;

public class 숫자판점프 {

    private static int[][] board;
    private static int[] dx = { 0, 1, 0, -1 };
    private static int[] dy = { 1, 0, -1, 0 };
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        final int N = 5;
        board = new int[N][N];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                DFS(0, j, i, 0);
            }
        }

        System.out.println(set.size());
    }

    private static void DFS(int result, int nowX, int nowY, int L) {
        if (L == 6) {
            set.add(result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nxtX = nowX + dx[i];
            int nxtY = nowY + dy[i];
            if (nxtX < 0 || nxtX > 4 || nxtY < 0 || nxtY > 4) {
                continue;
            }
            int tailNumber = board[nowY][nowX];
            DFS(result * 10 + tailNumber , nxtX, nxtY, L + 1);
        }
    }

}
