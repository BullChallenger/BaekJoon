package Baekjoon;

import java.util.*;

public class BJ25757 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        Set<String> blackList = new HashSet<>();
        int limit;

        String game = sc.next();
        if (game.equals("Y")) {
            limit = 2;
        } else if (game.equals("F")) {
            limit = 3;
        } else {
            limit = 4;
        }

        for (int i = 0; i < N; i++) {
            blackList.add(sc.next());
        }

        System.out.println(blackList.size() / limit);
    }

}
