package Study;

import java.util.Scanner;

public class 재귀연습 {

    static int[] arr;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N + 1];
        DFS(N);
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
    }

    private static int DFS(int n) {
        if (arr[n] != 0) return arr[n];
        if (n == 1) return arr[0] = 1;
        else if (n == 2) return arr[1] = 1;
        else {
            return arr[n] = DFS(n - 1) + DFS(n - 2);
        }
    }

}
