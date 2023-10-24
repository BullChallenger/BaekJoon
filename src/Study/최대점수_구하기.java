package Study;

import java.util.Scanner;

public class 최대점수_구하기 {

    private static int N, M;
    private static Problem[] problems;
    private static int result;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        problems = new Problem[N + 1];

        for (int i = 0; i < N; i++) {
            problems[i] = new Problem(sc.nextInt(), sc.nextInt());
        }

        Problem problem = problems[0];
        DFS(problem, 0, 0, 0);
        System.out.println(result);
    }

    private static void DFS(Problem problem, int time, int score, int L) {
        if (time > M) return;
        if (L == N) {
            result = Math.max(score, result);
            return;
        }
        Problem nxtProblem = problems[L + 1];
        DFS(nxtProblem, time + problem.getTime(), score + problem.getScore(), L + 1);
        DFS(nxtProblem, time, score, L + 1);
    }

    private static class Problem {
        private int score;
        private int time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }

        public int getScore() {
            return score;
        }

        public int getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "Problem{" +
                    "score=" + score +
                    ", time=" + time +
                    '}';
        }
    }

}
