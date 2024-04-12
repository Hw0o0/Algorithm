# [연습문제] 약수의 개수와 덧셈

## :pushpin: **Algorithm**

알고리즘

- 구현

## :round_pushpin: **Logic**

 ```java
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


 ```

- 약수의 개수를 구해주는 함수를 따로 만들어 left~right까지의 숫자의 약수가 짝수이면 +, 홀수이면 -를 하여 다 더해준다.
- ## :black_nib: **Review**

- 이 문제는 금방 해결했다.