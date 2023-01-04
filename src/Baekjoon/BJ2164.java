package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        Queue<Integer> cardDeck = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            cardDeck.add(i);
        }

        while (cardDeck.size() > 1) {
            cardDeck.poll();
            cardDeck.add(cardDeck.poll());
        }
        System.out.println(cardDeck.peek());
    }
}
