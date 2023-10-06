package Study;

import java.util.Scanner;
import java.util.Stack;

public class 후위식연산 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Integer> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) stack.push(Character.getNumericValue(ch));
            else {
                int x = stack.pop();
                int y = stack.pop();

                if (ch == '+') stack.push(x + y);
                else if (ch == '-') stack.push(y - x);
                else if (ch == '*') stack.push(x * y);
                else stack.push(x / y);
            }
        }

        System.out.println(stack.peek());
    }

}
