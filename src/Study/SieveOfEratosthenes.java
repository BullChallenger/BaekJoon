package Study;

import java.util.Scanner;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        int[] numbers = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            if (numbers[i] == 0) {
                cnt++;
                for (int j = i; j <= N; j += i) {
                    numbers[j]++;
                }
            }
        }
        System.out.println(cnt);
    }
}
