package Study;

public class 문자열압축 {

    public static void main(String[] args) {
        String solve = "aabbaccc";
        System.out.println(solution(solve));
    }

    private static int solution(String s) {
        int answer = s.length();
        int count = 1;

        for (int i = 1; i <= s.length() / 2; i++){
            StringBuilder result = new StringBuilder();
            String candidate = s.substring(0, i);

            for(int j = i; j <= s.length(); j += i){
                int end = Math.min(j + i, s.length());
                String compare = s.substring(j, end);
                if(candidate.equals(compare)){
                    count++;
                } else {
                    if(count >= 2){
                        result.append(count);
                    }
                    result.append(candidate);
                    candidate = compare;
                    count = 1;
                }
            }
            result.append(candidate);
            answer = Math.min(answer, result.length());
        }

        return answer;
    }

}
