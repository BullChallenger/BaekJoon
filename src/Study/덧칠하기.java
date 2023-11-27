package Study;

import java.lang.reflect.Array;
import java.util.stream.Stream;

public class 덧칠하기 {

    public static void main(String[] args) {
        int n = 4;
        int m = 1;
        int[] section = { 1, 2, 3, 4 };

        System.out.println(solution(n, m, section));
    }

    private static int solution(int n, int m, int[] section) {
        int answer = 0;
        int prevTarget = section[0];
        int paintCnt = 1;

        for (int target : section) {
            if (target > prevTarget + m - 1) {
                paintCnt++;
                prevTarget = target;
            }
        }

        answer = paintCnt;
        return answer;
    }

}
