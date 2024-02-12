package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ20125 {

    private static char[][] board;
    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, 1, -1 };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int leftArm = 0;
        int rightArm = 0;
        int body = 0;
        int leftLeg = 0;
        int rightLeg = 0;

        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        Heart heart = null;
        Loop1 :
        for (int i = 0; i < N; i++) {
            Loop2 :
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '*') {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextX = j + dx[k];
                        int nextY = i + dy[k];

                        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                            if (board[nextY][nextX] == '*') {
                                count++;
                            }
                        }
                    }

                    if (count == 4) {
                        heart = new Heart(j, i);
                        System.out.println(heart.y + " " + heart.x);
                        break Loop1;
                    }
                }
            }
        }

        leftArm = bodyCheck(N, heart, -1, 0, -1, 0);
        rightArm = bodyCheck(N, heart, 1, 0, 1, 0);
        body = bodyCheck(N, heart, 0, 1, 0, 1);
        leftLeg = bodyCheck(N, heart, -1, body + 1, 0, 1);
        rightLeg = bodyCheck(N, heart, 1, body + 1, 0, 1);

        System.out.println(leftArm + " " + rightArm + " " + body + " " + leftLeg + " " + rightLeg);
    }

    private static int bodyCheck(int N, Heart heart, int x, int y, int moveX, int moveY) {
        int len = 0;
        int nextX = heart.x + x - 1;
        int nextY = heart.y + y - 1;

        while(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && board[nextY][nextX] == '*') {
            len++;
            nextX += moveX;
            nextY += moveY;
        }

        return len;
    }

    static class Heart {
        private int x;
        private int y;

        public Heart(int x, int y) {
            this.x = x + 1;
            this.y = y + 1;
        }
    }

}
