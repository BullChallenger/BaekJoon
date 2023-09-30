package Study;

import java.util.Scanner;

public class ScoreCheck {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int score = 0;
        int total = 0;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                score = 0;
            } else {
                score += 1;
                total += score;
            }
        }

        System.out.println(total);
    }
}
