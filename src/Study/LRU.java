package Study;

import java.util.*;

public class LRU {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] cache = new int[S];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : arr) {
            int p = -1;
            for (int j = 0; j < S; j++) if (i == cache[j]) p = j;
                if (p == -1) {
                    for (int k = S - 1; k >= 1; k--) {
                        cache[k] = cache[k - 1];
                    }
                } else {
                    for (int k = p; k >= 1; k--) {
                        cache[k] = cache[k - 1];
                    }
                }
                cache[0] = i;
        }

        for (int i : cache) {
            System.out.print(i + " ");
        }
    }

}
