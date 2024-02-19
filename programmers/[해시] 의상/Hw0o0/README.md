# [해시] 의상 목록 오답 노트

## :pushpin: **Algorithm**

알고리즘

- 해시

## :round_pushpin: **Logic**

 ```java
import java.util.*;

public class Costume {
  class Solution {
    public int solution(String[][] clothes) {
      int answer = 1;
      HashMap<String,Integer> costume = new HashMap<>();
      String type;

      for (int a = 0; a < clothes.length;a++) {
        type = clothes[a][1];

        if(costume.containsKey(type)){
          costume.put(type,costume.getOrDefault(type,0)+1);
        }else{
          costume.put(type,1);
        }
      }

      for(Map.Entry<String,Integer> c : costume.entrySet()){
        answer *= c.getValue()+1;
      }
      return answer-1;
    }
  }
}

 ```

- 먼저 key값이 type가 들어가고 갯수를 나타내는 HashMap를 만들어준다.
- 반복문을 통해서 clothes의 정보들을 costume에 넣어주는데 costume에 정보가 있다면 갯수를 +1 해주고 없다면 1로 새로 만들어준다.
- 그리고 마지막 반복문을 통해 모든 경우의 수를 구하고 옷을 하나도 안입었을때의 경우를 생각해서 -1를 해주면 원하는 결과값을 얻을수 있다.
- ## :black_nib: **Review**

- 아직 해시에 대해 제대로 이해하지 못해서 해시를 공부하면서 문제를 풀어보았다.
- 이 문제를 통해서 containsKey()와 entrySet() 에 대해 알게 되었다. 