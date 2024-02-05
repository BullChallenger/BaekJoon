package Study;

import java.util.LinkedList;
import java.util.Queue;

public class 석유시추 {

    private static int[] dx = { 1, 0, -1, 0};
    private static int[] dy = { 0, 1, 0, -1};
    private static boolean[][] visited;

    public static void main(String[] args) {
        int[][] land = { {0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1} };
        System.out.println(solution(land));
    }

    private static int solution(int[][] land) {
        int answer = 0;
        int width = land[0].length;
        int height = land.length;
        int[] candidates = new int[width];
        int result = 0;

        visited = new boolean[height][width];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (land[j][i] == 1) {
                    BFS(land, j, i, 1);
                }
            }
        }

        return answer;
    }

    private static void BFS (int[][] land, int y, int x, int L) {
        Queue<Integer> Q = new LinkedList<>();
    }

}
