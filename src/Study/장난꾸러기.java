package Study;

import java.util.Arrays;
import java.util.Scanner;

public class 장난꾸러기 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] students = new int[N];

        for (int i = 0; i < N; i++) {
            students[i] = sc.nextInt();
        }

        int[] temp = students.clone();
        Arrays.sort(temp);

        for (int i = 0; i < N; i++) {
            if (students[i] != temp[i]) {
                System.out.print(i + 1 + " ");
            }
        }
    }

}
