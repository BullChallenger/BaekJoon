package Study;

import java.util.Scanner;

public class 최대_길이_연속부분수열 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        int lp = 0;
        int cnt = 0;
        int length = 0;

        for (int rp = 0; rp < N; rp++) {
            if (input[rp] == 0) cnt++;
            while (cnt > K) {
                if (input[lp] == 0) cnt--;
                lp++;
            }
            length = Math.max(length, rp - lp + 1);
        }
        System.out.println(length);
    }
}
