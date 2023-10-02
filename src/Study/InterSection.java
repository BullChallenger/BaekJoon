package Study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InterSection {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        int N = sc.nextInt();
        int[] arrA = new int[N];
        for (int i = 0; i < N; i++) {
            arrA[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] arrB = new int[M];
        for (int i = 0; i < M; i++) {
            arrB[i] = sc.nextInt();
        }

        int pA = 0;
        int pB = 0;

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        while (pA < N && pB < M) {
            if (arrA[pA] == arrB[pB]) {
                result.add(arrA[pA++]);
                pB++;
            } else if (arrA[pA] < arrB[pB]) {
                pA++;
            } else {
                pB++;
            }
        }

        result.sort(Integer::compareTo);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
