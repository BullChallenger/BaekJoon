package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordDistance {

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        String input = input();
        String sentence = input.split(" ")[0];
        char target = input.split(" ")[1].charAt(0);

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == target) System.out.print(0 + " ");
            else {
                if (i - 1 < 0) {
                    int rt = i + 1;
                    while (rt < sentence.length()) {
                        if (sentence.charAt(rt) == target) {
                            System.out.print(rt - i + " ");
                            break;
                        }
                        else rt++;
                    }
                } else if (i + 1 == sentence.length()) {
                    int lt = i - 1;
                    while (lt > 0) {
                        if (sentence.charAt(lt) == target) {
                            System.out.print(i - lt + " ");
                            break;
                        }
                        else lt--;
                    }
                } else {
                    int rt = i + 1;
                    int rtDistance = Integer.MAX_VALUE;
                    int lt = i - 1;
                    int ltDistance = Integer.MAX_VALUE;
                    while (rt < sentence.length()) {
                        if (sentence.charAt(rt) == target) {
                            rtDistance = rt - i;
                            break;
                        }
                        else rt++;
                    }
                    while (lt >= 0) {
                        if (sentence.charAt(lt) == target) {
                            ltDistance = i - lt;
                            break;
                        }
                        else lt--;
                    }
                    if (rtDistance > ltDistance) {
                        System.out.print(ltDistance + " ");
                    } else {
                        System.out.print(rtDistance + " ");
                    }
                }
            }
        }
    }

    private static String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
