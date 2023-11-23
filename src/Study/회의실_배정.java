package Study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 회의실_배정 {

    private static final List<Schedule> schedules = new ArrayList<>();
    private static int N;
    private static int result = 1;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            schedules.add(new Schedule(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(schedules);

        int endTime = schedules.get(0).getEndTime();
        for (int i = 1; i < schedules.size(); i++) {
            Schedule schedule = schedules.get(i);
            if (schedule.getStartTime() >= endTime) {
                result++;
                endTime = schedule.getEndTime();
            }
        }

        System.out.println(result);
    }

}

class Schedule implements Comparable<Schedule> {
    private final int startTime;
    private final int endTime;

    public Schedule(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public int compareTo(Schedule o) {
        if (this.endTime == o.endTime) {
            return this.startTime - o.startTime;
        }
        return this.endTime - o.endTime;
    }

    @Override
    public String toString() {
        return startTime + " :: " + endTime;
    }
}

