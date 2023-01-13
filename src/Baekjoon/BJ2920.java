package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2920 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] musicCode = new int[8];

        for (int i = 0; i < 8; i++) {
            musicCode[i] = Integer.parseInt(st.nextToken());
        }

        String judge = " ";

        for (int i = 0; i < musicCode.length - 1; i++) {
            if (musicCode[i] == musicCode[i + 1] - 1) judge = "ascending";
            else if (musicCode[i] == musicCode[i + 1] + 1) judge = "descending";
            else {
                judge = "mixed";
                break;
            }
        }

        System.out.println(judge);
    }
}
