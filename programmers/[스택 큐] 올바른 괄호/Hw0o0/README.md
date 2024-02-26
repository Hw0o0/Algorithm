# [스택/큐] 올바른 괄호

## :pushpin: **Algorithm**

알고리즘

- 스택/큐

## :round_pushpin: **Logic**

 ```java
import java.util.*;

public class CorrectParentheses {

    boolean solution(String s) {
        int openCnt = 0;
        Queue<Character> queue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            queue.add(c);
        }

        while (!queue.isEmpty()) {
            char word = queue.poll();
            if (word == '(') {
                openCnt++;
            } else {
                if (openCnt == 0) {
                    return false;
                }
                openCnt--;
            }
        }

        return openCnt == 0;
    }
}
 ```

- 먼저 Queue에 문자를 하나씩 쪼개서 넣어준다.
- queue를 반복문을 통해서 돌면서 첫 queue를 꺼내어 변수에 저장 후 queue에서 제거 후 저장된 변수를 통해서 ( 가 나오면 openCnt를 올려주고,아니면
  openCnt를 1씩 줄여준다. 만약 openCnt가 0인데 ) 가 나오면 false를 반환헤준다.
- 마지막으로 open == 0이 맞다면 true를 반환 후 종료한다.
- ## :black_nib: **Review**

- 이번 문제는 쉽게 해결한 것 같다.