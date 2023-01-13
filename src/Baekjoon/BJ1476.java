package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1476 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int EARTH = Integer.parseInt(st.nextToken());
        int earthCnt = 0;

        final int SUN = Integer.parseInt(st.nextToken());
        int sunCnt = 0;

        final int MOON = Integer.parseInt(st.nextToken());
        int moonCnt = 0;

        int year = 0;

        while(true) {
            year++;
            earthCnt++;
            sunCnt++;
            moonCnt++;

            if (earthCnt == 16) earthCnt = 1;
            if (sunCnt == 29) sunCnt = 1;
            if (moonCnt == 20) moonCnt = 1;


            if (earthCnt == EARTH && sunCnt == SUN && moonCnt == MOON) {
                System.out.println(year);
                break;
            }
        }
    }
}
