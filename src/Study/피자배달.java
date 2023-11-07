package Study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 피자배달 {

    private static int N, M;
    private static int[][] map;
    private static int[] combinationIndex;
    private static int result = Integer.MAX_VALUE;
    private static List<Point> pizzas = new ArrayList<>();
    private static List<Point> houses = new ArrayList<>();

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][N];
        combinationIndex = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    pizzas.add(new Point(i, j));
                }
                if (map[i][j] == 1) {
                    houses.add(new Point(i, j));
                }
            }
        }

        DFS(0, 0);
        System.out.println(result);
    }

    private static void DFS(int start, int L) {
        if (L == M) {
            int sum = 0;
            for (Point house : houses) {
                int distance = Integer.MAX_VALUE;
                for (int idx : combinationIndex) {
                    distance = Math.min(distance, Math.abs(house.x - pizzas.get(idx).x) + Math.abs(house.y - pizzas.get(idx).y));
                }
                sum += distance;
            }
            result = Math.min(result, sum);
        } else {
            for (int i = start; i < pizzas.size(); i++) {
                combinationIndex[L] = i;
                DFS(i + 1, L + 1);
            }
        }
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
