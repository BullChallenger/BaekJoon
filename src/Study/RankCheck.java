package Study;

import java.util.Scanner;

public class RankCheck {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] scores = new int[N];
        int[] ranks = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
            ranks[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            int score = scores[i];
            for (int j = 0; j < N; j++) {
                if (score > scores[j]) {
                    ranks[j]++;
                }
            }
        }

        for (int rank : ranks) {
            System.out.print(rank + " ");
        }
    }
}
