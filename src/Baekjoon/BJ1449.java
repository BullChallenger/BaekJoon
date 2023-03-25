package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        boolean[] pipes = new boolean[1001];
        Arrays.fill(pipes, false);

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pipes[Integer.parseInt(st2.nextToken())] = true;
        }

        int point = 0;
        int cnt = 0;

        while(point < 1001) {
            if (pipes[point] == true) {
                cnt++;
                point += L;
            } else {
                point++;
            }
        }

        System.out.println(cnt);
    }
}
