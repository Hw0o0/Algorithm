package 연습문제;

public class NumberOfFactorsAndAddition {

    public int solution(int left, int right) {
        int answer = 0;
        while (left <= right) {
            System.out.println(def(left));
            if (def(left) % 2 == 0) {
                answer += left;
            } else {
                answer -= left;
            }
            left++;
        }
        return answer;
    }

    public int def(int num) {
        int x = 0;
        for (int a = 1; a <= num; a++) {
            if (num % a == 0) {
                x++;
            }
        }
        return x;
    }
}
