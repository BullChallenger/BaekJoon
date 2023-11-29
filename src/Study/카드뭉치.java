package Study;

import java.util.*;

public class 카드뭉치 {

    public static void main(String[] args) {
        String[] cards1 = { "i", "water", "drink" };
        String[] cards2 = { "want", "to" };
        String[] goal = { "i", "want", "to", "drink", "water" };

        System.out.println(solution(cards1, cards2, goal));
    }

    private static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> cardList1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> cardList2 = new LinkedList<>(Arrays.asList(cards2));
        Queue<String> goalList = new LinkedList<>(Arrays.asList(goal));

        while (!goalList.isEmpty()) {
            if (goalList.peek().equals(cardList1.peek())) {
                cardList1.poll();
                goalList.poll();
            } else if (goalList.peek().equals(cardList2.peek())) {
                cardList2.poll();
                goalList.poll();
            } else {
                answer = "No";
                break;
            }
        }
        return answer;
    }

}
