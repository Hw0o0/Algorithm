# [스택/큐] 기능개발 오답 노트

## :pushpin: **Algorithm**

알고리즘

- 스택/큐

## :round_pushpin: **Logic**

- 수정 전

 ```java
import java.util.*;

public class FunctionDevelopment {
    public static int takeTime(int remainingPercent, int speed) {
        int takeTime = 0;
        int currentPercent = 100 - remainingPercent;
        if (speed == 1) {
            timeTaken = remainingPercent;
        } else {
            while (currentPercent < 100) {
                currentPercent += speed;
                takeTime++;
            }
        }
        return takeTime;
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> function = new ArrayList<>();
        for (int a = 0; a < progresses.length; a++) {
            int cnt = 1;
            int remainingPercent = 100 - progresses[a];
            int takeTime = takeTime(remainingPercent, speeds[a]);
            for (int b = a + 1; b < progresses.length; b++) {
                int nextRemainingPercent = 100 - progresses[b];
                int nextTakeTime = takeTime(nextRemainingPercent, speeds[b]);
                if (takeTime > nextTakeTime) {
                    cnt++;
                } else {
                    break;
                }
            }
            function.add(cnt);
            a += (cnt - 1);
        }

        int[] answer = new int[function.size()];
        for (int c = 0; c < function.size(); c++) {
            answer[c] = function.get(c);
        }
        return answer;
    }
}


 ```

- 수정 후

 ```java
import java.util.*;

class Solution {
    public ArrayList solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> takeTime = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            takeTime.add((int)Math.ceil((100.0-progresses[i])/speeds[i]));
        }

        while(!takeTime.isEmpty()){
            int minDays = takeTime.poll();
            int count = 1;

            while(!takeTime.isEmpty() && takeTime.peek() <= minDays){
                takeTime.poll();
                count++;
            }
            answer.add(count);
        }

        return answer;
    }
}
 ```

- 먼저 첫 반복문을 통해서 기능개발 완성 기간을 구해서 queue의 takeTime에 넣어준다.
- while문을 통해서 기능개발 날짜를 queue에서 뽑아내서 변수로 저장시킨 후 두번째 while문을 통해서 minDays보다 개발기간이 짧으면 큐에서 뽑아서 삭제한다. 그리고 minDays 기간동안 몇개의 기능이 개발이 되었는지 answer에 저장해준다.그러면 원하는 결과 값을 얻을수있다.
- 
- ## :black_nib: **Review**

- 아무생각없이 결과값만 구현하려고 해서 queue를 사용할 생각을 하지못했다. 그래서 구현하는 코드가 처음에 너무 길었다.
- queue로 구현하니 코드가 정말 간결해지고 구현하기 쉬웠다. 