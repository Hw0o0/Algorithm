package 정렬;

import java.util.Arrays;

public class BiggestNumber {

    public String solution(int[] numbers) {
        String answer = "";
        String[] list = new String[numbers.length];

        for (int a = 0; a < numbers.length; a++) {
            list[a] = String.valueOf(numbers[a]);
        }

        Arrays.sort(list, (a, b) -> (b + a).compareTo(a + b));

        if (list[0].equals("0")) {
            return "0";
        }
        for (int b = 0; b < list.length; b++) {
            answer = (answer + list[b]);
        }
        return answer;
    }
}
