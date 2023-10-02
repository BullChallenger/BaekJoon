package Study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombineArray {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        int N = sc.nextInt();
        int[] arrA = new int[N];
        int pA = 0;
        for (int i = 0; i < N; i++) arrA[i] = sc.nextInt();

        int M = sc.nextInt();
        int[] arrB = new int[M];
        int pB = 0;
        for (int i = 0; i < M; i++) arrB[i] = sc.nextInt();

        while (pA < N && pB < M) {
            if (arrA[pA] <= arrB[pB]) result.add(arrA[pA++]);
            else result.add(arrB[pB++]);
        }

        while (pA < N) result.add(arrA[pA++]);
        while (pB < M) result.add(arrB[pB++]);
        
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
