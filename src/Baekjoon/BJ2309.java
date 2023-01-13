package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2309 {
    public static void main(String[] args) throws IOException {

        final int N = 9;
        int[] height = new int[N];
        int total = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(br.readLine());
            total += height[i];
        }

        Arrays.sort(height);

        realDwarfsChecker(total, N, height);
    }

    private static void realDwarfsChecker(int total, int N, int[] height) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (total - (height[i] + height[j]) == 100) {
                    height[i] = 0;
                    height[j] = 0;
                    print(height);
                    return;
                }
            }
        }
        return;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) System.out.println(arr[i]);
        }
    }
}
