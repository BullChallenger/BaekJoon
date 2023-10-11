package Study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 좌표정렬 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i][0] + " " + arr[i][1]);
            System.out.println();
        }
    }

}
