package Study;

import java.util.Scanner;

public class ReversePrimeNumber {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] numbers = sc.nextLine().split(" ");

        for (int i = 0; i < N; i++) {
            String temp = new StringBuilder(numbers[i]).reverse().toString();
            boolean isPrime = false;
            int x = Integer.parseInt(temp);
            for (int j = 1; j <= x; j++) {
                if (x == 1) {
                    isPrime = true;
                    break;
                } else if (x != j && x % j == 0 && j != 1) {
                    isPrime = true;
                    break;
                }
            }
            if (!isPrime) System.out.print(x + " ");
        }
    }
}
