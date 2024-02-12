package Baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ2575 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String game = sc.next();
        Set<String> blackList = new HashSet<>();
        int count = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            String nickname = sc.next();
            if (!blackList.contains(nickname)) {
                blackList.add(nickname);
                count++;
                result += readyToPlayGame(game, count);
            }
        }
        System.out.println(result);
    }

    private static int readyToPlayGame(String game, int count) {
        int play = 0;
        if (game.equals("Y")) {
            if (count % 1 == 0) {
                play++;
            }
        } else if (game.equals("F")) {
            if (count % 2 == 0) {
                play++;
            }
        } else {
            if (count % 3 == 0) {
                play++;
            }
        }
        return play;
    }

}