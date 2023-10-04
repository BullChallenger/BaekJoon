package Study;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 매출액의_종류 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] sales = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            sales[i] = sc.nextInt();
            if (i < K) {
                map.put(sales[i], map.getOrDefault(sales[i], 0) + 1);
            }
        }
        System.out.print(map.size() + " ");

        int rt = K;
        int lt = 0;

        while(rt < N) {
            int sale = sales[lt];
            map.put(sales[rt], map.getOrDefault(sales[rt], 0) + 1);
            map.replace(sale, map.get(sale) - 1);
            if (map.get(sale) == 0) map.remove(sale);
            System.out.print(map.size() + " ");
            rt++;
            lt++;
        }
    }
}
