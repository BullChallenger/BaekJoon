package Study;

import java.util.*;

public class 최대_수입_스케줄 {

    private static int N;
    private static int D = Integer.MIN_VALUE;
    private static final List<Schedule> schedules = new ArrayList<>();
    private static final Queue<Integer> inDateSchedules = new PriorityQueue<>(Collections.reverseOrder());
    private static int result = 0;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int money = sc.nextInt();
            int date = sc.nextInt();
            schedules.add(new Schedule(money, date));
            D = Math.max(D, date);
        }

        Collections.sort(schedules);

        int j = 0;
        for (int i = D; i >= 1; i--) {
            for (; j < N; j++) {
                if (schedules.get(j).getDate() < i) {
                    break;
                }
                inDateSchedules.offer(schedules.get(j).getMoney());
            }

            if (!inDateSchedules.isEmpty()) result += inDateSchedules.poll();
        }

        System.out.println(result);
    }

    static class Schedule implements Comparable<Schedule> {
        private int money;
        private int date;

        public Schedule(int money, int day) {
            this.money = money;
            this.date = day;
        }

        public int getMoney() {
            return money;
        }

        public int getDate() {
            return date;
        }

        @Override
        public int compareTo(Schedule o) {
            return o.date - this.date;
        }

        @Override
        public String toString() {
            return date + " :: " + money;
        }

        public boolean isInDate(int date) {
            if (date >= this.date) {
                return true;
            }
            return false;
        }
    }

}
