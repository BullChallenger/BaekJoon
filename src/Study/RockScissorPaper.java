package Study;

import java.util.Scanner;

public class RockScissorPaper {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0) A[j] = sc.nextInt();
                else B[j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            if (Math.abs(A[i] - B[i]) == 1) {
                if (A[i] > B[i]) System.out.println("A");
                else System.out.println("B");
            }
            else if (A[i] - B[i] == 0) System.out.println("D");
            else {
                if (A[i] < B[i]) System.out.println("A");
                else System.out.println("B");
            }
        }
    }
}
