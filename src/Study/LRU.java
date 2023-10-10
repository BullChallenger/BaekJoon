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
        List<Integer> cache = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int t = sc.nextInt();
            if (!cache.contains(t)) {
                if (cache.size() >= S) cache.remove(0);
                cache.add(t);
            } else {
                cache.remove(Integer.valueOf(t));
                cache.add(t);
            }
        }

        Collections.reverse(cache);
        for (Integer i : cache) {
            System.out.print(i + " ");
        }
    }

}
