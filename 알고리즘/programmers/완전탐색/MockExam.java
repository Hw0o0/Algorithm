package 완전탐색;

import java.util.ArrayList;

public class MockExam {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int oneValue = calculate(one, answers);
        int twoValue = calculate(two, answers);
        int threeValue = calculate(three, answers);

        int max = Math.max(oneValue, Math.max(twoValue, threeValue));

        ArrayList<Integer> list = new ArrayList<>();
        if (oneValue == max) list.add(1);
        if (twoValue == max) list.add(2);
        if (threeValue == max) list.add(3);

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int calculate(int[] person, int[] answers) {
        int x = 0;
        int total = 0;
        for (int a : answers) {
            if (person[x] == a) {
                total++;
            }
            x++;
            if (x == person.length) {
                x = 0;
            }
        }
        return total;
    }
}
