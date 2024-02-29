# [정렬] 가장 큰 수 오답 노트

## :pushpin: **Algorithm**

알고리즘

- 정렬

## :round_pushpin: **Logic**

 ```java
import java.util.*;

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

 ```

- CompareTo()를 사용하기 위해서 int형을 String형으로 바꿔주고, 뭐가 더 큰지를 비교해서 정렬을 해줍니다.
- 만약에 리스트의 처음이 0이라면 0을 반환 후 종료하게 해주었다.
- 반복문을 통해서 list를 하나의 문자로 합쳐주면 원하는 가장 큰 수를 구할 수 있다.
- ## :black_nib: **Review**

- 처음에 compareTo()메서드를 모르고 일단 반복문으로 모두 다 구해서 높은 값을 구하는 식으로 만들려고하니 너무 코드가 길고 가독성이 안 좋았다. 그렇게 풀다보니 너무 시간이 지체되어 시간내에 풀지 못했다.
- compareTo()메서드를 배우고나니 코드도 아주 간결해지고 가독성도 좋아졌다.