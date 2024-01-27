package Study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 씨름선수 {

    private static int N;
    private static List<Player> candidates = new ArrayList<>();

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            candidates.add(new Player(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(candidates);
        int maxWeight = Integer.MIN_VALUE;

        for (Player player : candidates) {
            System.out.println(player.height + " : " + player.weight);
            if (player.weight > maxWeight) {
                maxWeight = player.weight;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static class Player implements Comparable<Player> {

        private int height;
        private int weight;

        public Player(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Player o) {
            return o.height - this.height;
        }

    }

}
