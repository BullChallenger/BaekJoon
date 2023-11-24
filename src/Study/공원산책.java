package Study;

import java.util.Arrays;

public class 공원산책 {

    public static void main(String[] args) {
        String[] park = { "OSO","OOO","OXO","OOO" };
        String[] routes = { "E 2","S 3","W 1" };

        System.out.println(Arrays.toString(solution(park, routes)));
    }

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int boardWidth = park[0].length();
        int boardHeight = park.length;
        int[] startPoint = new int[2];

        char[][] board = new char[boardHeight][ boardWidth];
        for (int i = 0; i < boardHeight; i++) {
            char[] puzzles = park[i].toCharArray();
            for (int j = 0; j < boardWidth; j++) {
                board[i][j] = puzzles[j];
                if (puzzles[j] == 'S') {
                    startPoint[0] = i;
                    startPoint[1] = j;
                }
            }
        }
        int tempX;
        int tempY;
        for (String route : routes) {
            tempY = startPoint[0];
            tempX = startPoint[1];

            if (route.split(" ")[0].equals("S") || route.split(" ")[0].equals("N")) {
                for (int i = 0; i < Integer.parseInt(route.split(" ")[1]); i++) {
                    startPoint[0] += move(route);
                    if (startPoint[0] > boardHeight - 1 || startPoint[0] < 0 || board[startPoint[0]][startPoint[1]] == 'X') {
                        startPoint[0] = tempY;
                        break;
                    }
                }
                answer[0] = startPoint[0];
                continue;
            }

            for (int i = 0; i < Integer.parseInt(route.split(" ")[1]); i++) {
                startPoint[1] += move(route);
                if (startPoint[1] > boardWidth - 1 || startPoint[1] < 0 || board[startPoint[0]][startPoint[1]] == 'X') {
                    startPoint[1] = tempX;
                    break;
                }
            }
            answer[1] = startPoint[1];
        }

        return answer;
    }

    private static int move(String route) {
        String movePoint = route.split(" ")[0];
        if (movePoint.equals("E") || movePoint.equals("S")) {
            return 1;
        }
        return -1;
    }

}
