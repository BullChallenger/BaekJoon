package Study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 개인정보_수집_유효기간 {

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = { "A 48" };
        String[] privacies = { "2021.05.02 A" };
        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }

    private static int[] solution(String today, String[] terms, String[] privacies) {
        TempDate currentDate = splitDate(today);
        List<Term> termList = new ArrayList<>();
        for (String term : terms) {
            termList.add(splitTerm(term));
        }

        List<Integer> idxList = new ArrayList<>();
        for (int i = 1; i <= privacies.length; i++) {
            Privacy savedPrivacy = splitPrivacy(privacies[i - 1]);
            for (Term term : termList) {
                if (savedPrivacy.isExpired(term, currentDate)) {
                    idxList.add(i);
                }
            }
        }
        int[] answer = new int[idxList.size()];
        for (int i = 0; i < idxList.size(); i++) {
            answer[i] = idxList.get(i);
        }
        return answer;
    }

    private static Privacy splitPrivacy(String privacy) {
        String date = privacy.split(" ")[0];
        String termType = privacy.split(" ")[1];

        return new Privacy(date, termType);
    }

    private static Term splitTerm(String term) {
        String termType = term.split(" ")[0];
        int termSaveDuration = Integer.parseInt(term.split(" ")[1]);

        return new Term(termType, termSaveDuration);
    }

    private static TempDate splitDate(String date) {
        String year = date.split("\\.")[0];
        String month = date.split("\\.")[1];
        String day = date.split("\\.")[2];

        return new TempDate(year, month, day);
    }

    private static class Term {
        private String type;
        private int duration;

        public Term(String type, int duration) {
            this.type = type;
            this.duration = duration;
        }
    }

    private static class Privacy {
        private TempDate createdAt;
        private String termType;

        public Privacy(String date, String termType) {
            this.createdAt = splitDate(date);
            this.termType = termType;
        }

        public boolean isExpired(Term term, TempDate currentDate) {
            if (term.type.equals(this.termType)) {
                TempDate tempDate = this.createdAt.plusMonth(term.duration);
                System.out.println(currentDate);
                System.out.println(this.createdAt);
                System.out.println(tempDate);
                if (tempDate.isAfter(currentDate)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class TempDate {
        private int year;
        private int month;
        private int day;

        public TempDate(String year, String month, String day) {
            this.year = Integer.parseInt(year);
            this.month = Integer.parseInt(month);
            this.day = Integer.parseInt(day);
        }

        public TempDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public TempDate plusMonth(int month) {
            int nxtYear = this.year;
            int nxtMonth = this.month + month;
            if (nxtMonth > 12) {
                while (nxtMonth > 12) {
                    System.out.println(nxtMonth);
                    nxtMonth = nxtMonth - 12;
                    if (nxtMonth / 12 == 0) {
                        nxtYear += 1;
                    } else {
                        nxtYear++;
                    }
                }
            }

            return new TempDate(nxtYear, nxtMonth, this.day);
        }

        public boolean isAfter(TempDate now) {
            if (now.year > this.year) {
                return true;
            } else if (now.year < this.year) {
                return false;
            }

            if (now.month > this.month) {
                return true;
            } else if (now.month < this.month) {
                return false;
            }

            return now.day >= this.day;
        }

        @Override
        public String toString() {
            return this.year + " :: " + this.month + " :: " + this.day;
        }
    }

}
