package Study;

import java.util.Arrays;
import java.util.Scanner;

public class 합이_같은_부분집합 {

    private static String result = "NO";
    private static int N, total;
    private static boolean flag = false;
    private static int[] arr;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        DFS(0, 0);
        System.out.println(result);
    }

    private static void DFS(int L, int sum) {
        if (flag || sum > (total / 2)) return;
        if (L == N) {
            if ((total / 2) == sum) {
                result = "YES";
                flag = true;
            }
        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }

}
