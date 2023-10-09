package Study;

import java.util.*;

public class 응급실 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Queue<Integer> queue = new ArrayDeque();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int t = sc.nextInt();
            queue.offer(t);
            list.add(t);
        }
        Collections.sort(list, Collections.reverseOrder());

        int danger = 0;
        int pointer = M;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int sickP = queue.poll();
            if (pointer != 0) {
                if (sickP == list.get(danger)) {
                    danger++;
                    cnt++;
                }
                else queue.offer(sickP);
                pointer--;
            } else {
                if (sickP != list.get(danger)) {
                    queue.offer(sickP);
                    pointer = queue.size() - 1;
                }
                else {
                    System.out.println(cnt);
                    break;
                }
            }
        }
    }

}
