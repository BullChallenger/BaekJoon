package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11724 {

    static int N;
    static int M;
    static int[][] arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken()) - 1;
            int y = Integer.parseInt(st2.nextToken()) - 1;

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
    private static void dfs(int start) {
        check[start] = true;

        for (int i = 0; i < N; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }
}
