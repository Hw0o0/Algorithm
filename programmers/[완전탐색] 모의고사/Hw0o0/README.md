# [완전탐색] 모의고사 오답노트

## :pushpin: **Algorithm**

알고리즘

- 완전탐색

## :round_pushpin: **Logic**

 ```java
import java.util.*;

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

 ```

- 수포자들의 일정하게 찍는 수를 배열에 넣어두고, 각 수포자들의 맟춘 문제들을 갯수를 파악해주는 함수를 만들어준다.
- 수포자들 중 가장 많이 맟춘 수를 기준으로 수포자들이 같은 수를 가지면 리스트에 넣어주고 List 형태를 int[]으로 바꾸어 반환해주면 정답이 나온다.
- ## :black_nib: **Review**

- 이번에 리스트 형태를 int[]로 바꾸는 것에서 시간을 너무 많이 사용해서 시간을 오바했다.하지만 이 문제를 통해 바꾸는 법을 확실히 인지했다.