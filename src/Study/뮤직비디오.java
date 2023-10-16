package Study;

import java.util.Arrays;
import java.util.Scanner;

public class 뮤직비디오 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        int sum = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int lp = Arrays.stream(arr).max().getAsInt();
        int rp = sum;
        while (lp <= rp) {
            int mid = (lp + rp) / 2;
            if (count(arr, mid) <= M) {
                rp = mid - 1;
                result = mid;
            }
            else {
                lp = mid + 1;
            }
        }
        System.out.println(result);
    }

    private static int count(int[] arr, int capacity) {
        int sum = 0;
        int cnt = 1;

        for (int x : arr) {
            if (sum + x <= capacity) sum += x;
            else {
                cnt++;
                sum = x;
            }
        }

        return cnt;
    }

}
