# [스택/큐] 같은 숫자는 싫어

## :pushpin: **Algorithm**

알고리즘

- 스택/큐

## :round_pushpin: **Logic**

 ```java
import java.util.ArrayList;
import java.util.List;

public class HateTheSameNumber {

    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int a = 1; a < arr.length; a++) {
            if (list.get(list.size() - 1) != arr[a]) {
                list.add(arr[a]);
            }
        }
        int[] answer = new int[list.size()];
        int x = 0;
        for (int a : list) {
            answer[x] = a;
            x++;
        }
        return answer;
    }
}


 ```

- 먼저 같지 않은 수를 리스트에 담아줍니다.
- 리스트의 크기만큼의 배열을 만들어 answer에 담아주어 출력해줍니다.
- ## :black_nib: **Review**

- 금방 해결했다.