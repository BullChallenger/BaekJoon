package Study;

import java.util.Scanner;

public class 선택정렬 {

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

        int idx;
        for (int i = 0; i < N; i++) {
            idx = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[idx] > arr[j]) idx = j;
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
