package Study;

import java.util.*;

public class K번째큰수 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] cards = new int[N];

        Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        Iterator<Integer> keys = map.keySet().iterator();
        int cnt = 1;
        while (cnt < N) {
            int key = keys.next();
            if (cnt == K) {
                System.out.println(key);
                break;
            }
            cnt++;
        }

        if (cnt == N) System.out.println(-1);
    }
}
