package Study;

import java.util.Scanner;

public class 연속_부분수열 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        int sum = 0;
        int cnt = 0;
        int minusP = 0;
        int sumP = 0;

        while (minusP < N && sumP < N) {
            if (sum == M) {
                cnt++;
                sum -= input[minusP++];
            }
            else if (sum < M) sum += input[sumP++];
            else {
                sum -= input[minusP++];
            }
        }

        if (sum > M) {
            for (int i = minusP; i < N; i++) {
                sum -= input[i];
                if (sum == M) cnt++;
            }
        } else if (sum == M) cnt++;

        System.out.println(cnt);
    }
}
