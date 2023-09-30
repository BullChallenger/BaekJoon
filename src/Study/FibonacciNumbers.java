package Study;

import java.util.Scanner;

public class FibonacciNumbers {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int prev1 = 0;
        int prev2 = 1;

        for (int i = 0; i < N; i++) {
            if (i == 0) System.out.print(1 + " ");
            else {
                System.out.print(prev1 + prev2 + " ");
                int temp = prev1;
                prev1 = prev2;
                prev2 = temp + prev2;
            }
        }
    }
}
