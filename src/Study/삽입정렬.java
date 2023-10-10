package Study;

import java.util.Arrays;
import java.util.Scanner;

public class 삽입정렬 {

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

        int temp;
        for (int i = 1; i < N; i++) {
            temp = arr[i];
            int idx = - 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) arr[j + 1] = arr[j];
                else {
                    idx = j;
                    break;
                }
            }
            arr[idx + 1] = temp;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
