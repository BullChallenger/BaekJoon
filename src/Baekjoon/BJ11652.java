package Baekjoon;

import java.util.*;

public class BJ11652 {

    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Map<Long, Integer> deck = new HashMap<>();

        for (int i = 0; i++ < N;) {
            Long card = sc.nextLong();
            deck.put(card, deck.getOrDefault(card, 0) + 1);
        }

        List<Map.Entry<Long, Integer>> deckList = new LinkedList<>(deck.entrySet());
        Map.Entry<Long, Integer> targetCard = deckList.stream().max(new Comparator<Map.Entry<Long, Integer>>() {
            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                int value = Integer.compare(o1.getValue(), o2.getValue());
                return value == 0 ? Long.compare(o2.getKey(), o1.getKey()) : value;
            };
        }).orElseThrow();
        System.out.println(targetCard.getKey());
    }

}
