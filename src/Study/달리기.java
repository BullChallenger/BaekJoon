package Study;

import java.util.*;

public class 달리기 {

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(solution(players, callings)));
    }

    public static String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> playerKeyMap = new HashMap<>();
        Map<Integer, String> rankingKeyMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerKeyMap.put(players[i], i);
            rankingKeyMap.put(i, players[i]);
        }

        for (String calling : callings) {
            int ranking = playerKeyMap.get(calling);
            String player = rankingKeyMap.get(ranking);

            String frontPlayer = rankingKeyMap.get(ranking - 1);

            playerKeyMap.replace(player, ranking - 1);
            playerKeyMap.replace(frontPlayer, ranking);

            rankingKeyMap.replace(ranking - 1, player);
            rankingKeyMap.replace(ranking, frontPlayer);
        }

        for (int i = 0; i < players.length; i++) {
            answer[i] = rankingKeyMap.get(i);
        }

        return answer;
    }
}