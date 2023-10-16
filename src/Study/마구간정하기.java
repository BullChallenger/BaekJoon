package Study;

import java.util.Arrays;
import java.util.Scanner;

public class 마구간정하기 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] horses = new int[N];

        for (int i = 0; i < N; i++) {
            horses[i] = sc.nextInt();
        }

        int rp = Arrays.stream(horses).max().getAsInt() - Arrays.stream(horses).min().getAsInt();
        int lp = 1;
        int result = 0;

        Arrays.sort(horses);

        while (lp <= rp) {
            int mid = (rp + lp) / 2;
            if (count(horses, mid) < C) {
                rp = mid - 1;
            } else {
                lp = mid + 1;
                result = mid;
            }
        }

        System.out.println(result);
    }

    private static int count(int[] horses, int distance) {
        int cnt = 1;
        int start = horses[0];

        for (int i = 0; i < horses.length; i++) {
            if (horses[i] - start >= distance) {
                cnt++;
                start = horses[i];
            }
        }

        return cnt;
    }

}
