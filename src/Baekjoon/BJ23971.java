package Baekjoon;

import java.util.Scanner;

public class BJ23971 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final int N = sc.nextInt() + 1;
        final int M = sc.nextInt() + 1;

        int count = 0;
        for (int i = 0; i < H; i += N) {
            for (int j = 0; j < W; j += M) {
                count++;
            }
        }
        System.out.println(count);
    }

}
