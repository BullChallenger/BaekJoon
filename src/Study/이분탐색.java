package Study;

import java.util.Arrays;
import java.util.Scanner;

public class 이분탐색 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int lp = 0;
        int rp = arr.length - 1;
        while (lp <= rp) {
            int mid = (lp + rp) / 2;
            if (arr[mid] == M) {
                System.out.print(mid + 1);
                break;
            } else if (arr[mid] < M) {
                lp = mid + 1;
            } else {
                rp = mid - 1;
            }
        }
    }

}
