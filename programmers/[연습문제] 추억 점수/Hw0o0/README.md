# [연습문제] 추억 점수

## :pushpin: **Algorithm**

알고리즘

- 구현

## :round_pushpin: **Logic**

 ```java
import java.util.*;

public class MemoriesScore {
    public List<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>();
        Map<String,Integer> person = new HashMap<>();

        for(int a = 0; a < name.length; a++){
            person.put(name[a],yearning[a]);
        }
        for(int b = 0; b < photo.length; b++){
            int x = 0;
            for(int c = 0; c< photo[b].length; c++){
                if(person.containsKey(photo[b][c])){
                    x+=person.get(photo[b][c]);
                }
            }
            answer.add(x);
        }
        return answer;
    }
}

 ```

- HashMap을 통해 name과 year을 넣어주고 for문을 통해 photo[b]의 이름이 person에 있다면 person의 value값을 가져와 다 더해주고 list에 담아주어 반환해준다.
- ## :black_nib: **Review**

- 이 문제는 금방 해결했다.