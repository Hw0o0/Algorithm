# [해시] 완주하지 못한 선수

## :pushpin: **Algorithm**

알고리즘

- 해시

## :round_pushpin: **Logic**

 ```java
import java.util.HashMap;

public class FailToCompleteRunner {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> person = new HashMap<>();

        for (int a = 0; a < participant.length; a++) {
            if (person.get(participant[a]) == null) {
                person.put(participant[a], 1);
            } else {
                person.put(participant[a], person.get(participant[a]) + 1);
            }
        }

        for (int b = 0; b < completion.length; b++) {
            if (person.get(completion[b]) != null) {
                person.put(completion[b], person.get(completion[b]) - 1);
            }
        }

        for (String s : person.keySet()) {
            if (person.get(s) != 0) {
                answer = s;
            }
        }

        return answer;
    }
}

 ```

- 첫번째 반복문을 통해서 모든 마라톤 선수들을 person에 집어 넣어준다. 넣어줄 때 만약 person에 participant[a]값이 없으면 새로 그 사람의 정보를 넣어주고
  정보가 있다면 +1을 해준다
- 두번쨰 반복문을 통해서 person의 정보들에 마라톤 완주한 선수들의 정보들이 있다면 -1 씩해준다.
- 세번쨰 반복문을 통해서 선수의 정보가 0이 아니라면 완주하지 않은 선수이므로 원하는 정보를 찾을수 있다.
- ## :black_nib: **Review**

- 해시를 먼저 공부하고 풀어보니 쉬게 풀었다.