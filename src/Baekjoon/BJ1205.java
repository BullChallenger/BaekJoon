package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BJ1205 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int newRecord = sc.nextInt();
        int P = sc.nextInt();

        List<Integer> ranking  = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            ranking.add(sc.nextInt());
        }

        int rank = 1;
        if (ranking.size() == 0) {
            rank = 1;
        }

        boolean flag = false;
        if (N == P && ranking.get(N - 1) >= newRecord) {
            rank = -1;
            flag = true;
        }

        if (!flag) {
            for (int i = 0; i < ranking.size(); i++) {
                Integer other = ranking.get(i);

                if (other > newRecord) {
                    rank++;
                }
            }
        }
        System.out.println(rank);
    }

}
