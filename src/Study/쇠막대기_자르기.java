package Study;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기_자르기 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        char prev = '(';
        for (char ch : input.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else {
                stack.pop();
                if (prev == '(') {
                    cnt += stack.size();
                } else {
                    cnt += 1;
                }
            }
            prev = ch;
        }

        System.out.println(cnt);
    }

}
