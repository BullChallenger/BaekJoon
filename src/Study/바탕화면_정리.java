package Study;

import java.util.Arrays;

public class 바탕화면_정리 {

    public static void main(String[] args) {
        String[] wallpaper = { "..........", ".....#....", "......##..", "...##.....", "....#....." };
        System.out.println(Arrays.toString(solution(wallpaper)));
    }

    private static int[] solution(String[] wallpaper) {
        int[] answer = {};
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            String line = wallpaper[i];
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '#') {
                    if (lux > j) {
                        lux = j;
                    }

                    if (luy > i) {
                        luy = i;
                    }

                    if (rdx <= j) {
                        rdx = j + 1;
                    }

                    if (rdy <= i) {
                        rdy = i + 1;
                    }
                }
            }
        }

        answer = new int[] { luy, lux, rdy, rdx };
        return answer;
    }

}
