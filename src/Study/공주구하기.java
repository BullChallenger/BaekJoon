package Study;

import java.util.*;

public class 공주구하기 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();

        int cnt = 1;
        for (int i = 1; i <= N; i++) queue1.add(i);
        while (queue1.size() != 1) {
            if (cnt % K != 0) {
                queue2.add(queue1.poll());
                queue1.add(queue2.poll());
            }
            else queue1.poll();
            cnt++;
        }

        System.out.println(queue1.poll());
    }

}
