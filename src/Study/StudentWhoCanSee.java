package Study;

import java.util.Scanner;

public class StudentWhoCanSee {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        int prev = 0;

        for (int i = 0; i < N; i++) {
            int tall = sc.nextInt();
            if (tall > prev) {
                cnt++;
                prev = tall;
            }
        }

        System.out.println(cnt);
    }
}
