# [스택/큐] 프로세스

## :pushpin: **Algorithm**

알고리즘

- 스택/큐

## :round_pushpin: **Logic**

 ```java
import java.util.*;

public class Process {

  public int solution(int[] priorities, int location) {
    int answer = 0;
    Queue<Integer> queue = new LinkedList<>();
    for (int priority : priorities) {
      queue.add(priority);
    }
    Arrays.sort(priorities);
    int index = priorities.length - 1;
    while (!queue.isEmpty()) {
      int current = queue.poll();
      if (current == priorities[index - answer]) {
        answer++;
        if (location == 0) {
          break;
        }
      } else {
        queue.add(current);
      }
      location = (location + queue.size() - 1) % queue.size();
    }
    return answer;
  }
}


 ```

- 큐에 값을 저장하고, queue 값을 정렬해서 최대값을 알아낸다. 
- 반복문을 통해서 현재 처음 값을 가져와서, 현재 current 값이 최대 값과 같은지 확인한다. 
- 만약 같으면 answer를 증가시키고, 원하던 위치의 값이라면 멈춘다.아니라면 queue에 현재 값을 다시 넣는다.그리고 요청한 위치를 갱신합니다.
- ## :black_nib: **Review**

- 이번 문제는 코드를 간결화시키고 시간초과를 줄이는 것에 시간을 많이 사용한 것 같다.