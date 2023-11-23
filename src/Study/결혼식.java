package Study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 결혼식 {

    private static int N;
    private static final List<Person> guest = new ArrayList<>();
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            guest.add(new Person(sc.nextInt(), sc.nextInt()));
        }

        for (int i = 0; i <= 72; i++) {
            int time = i;
            result = (int) Math.max(guest.stream().filter(person -> person.isLocate(time)).count(), result);
        }

        System.out.println(result);
    }

}

class Person {
    private final int startTime;
    private final int endTime;

    public Person(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public boolean isLocate(int time) {
        if (time < startTime || time >= endTime) {
            return false;
        }

        return true;
    }
}
