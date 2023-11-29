package Study;

public class 크기가_작은_부분_문자열 {

    public static void main(String[] args) {
        String t = "10203";
        String p = "15";

        System.out.println(solution(t, p));
    }

    private static int solution(String t, String p) {
        int answer = 0;
        int targetLength = p.length();
        long target = Long.parseLong(p);
        int cnt = 0;

        for (int i = 0; i < t.length() - targetLength + 1; i++) {
            long splitT = Long.parseLong(t.substring(i, i + targetLength));
            if (splitT <= target) {
                cnt++;
            }
        }

        answer = cnt;
        return answer;
    }

}
