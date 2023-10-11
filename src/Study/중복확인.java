package Study;

import java.util.Arrays;
import java.util.Scanner;

public class 중복확인 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        String result = "U";
        Arrays.sort(arr);
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                result = "D";
                break;
            }
        }
        System.out.println(result);
    }

}
