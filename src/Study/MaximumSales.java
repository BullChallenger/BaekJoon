package Study;

import java.util.Scanner;

public class MaximumSales {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int max = 0;
        int sum = 0;

        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (i < K) {
                sum += input[i];
            } else {
                if (max < sum) {
                    max = sum;
                }
                sum -= input[i - K];
                sum += input[i];
            }
        }

        System.out.println(max);
    }
}
