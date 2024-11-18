# [스택/큐] 다리를 지나는 트럭

## :pushpin: **Algorithm**

알고리즘

- 스택/큐

## :round_pushpin: **Logic**

 ```java
import java.util.*;
public class TruckPassingOverTheBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;               // 트럭이 지나가는데 걸리는 시간
        int currentWeight = 0;      // 현재 다리 위에 있는 트럭의 무게 합
        int index = 0;              // 대기하고 있는 트럭 인덱스 번호

        // 초기 다리를 0으로 채우기
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (!bridge.isEmpty()) {
            time++; // 시간 증가
            int removed = bridge.poll(); // 다리를 지나간 트럭 제거
            currentWeight -= removed;   // 현재 다리 무게 갱신

            // 대기 트럭이 있을 경우 실행
            if (index < truck_weights.length) {
                // 다음 트럭을 다리에 올릴 수 있는지 확인
                if (currentWeight + truck_weights[index] <= weight) {
                    bridge.add(truck_weights[index]); // 트럭 추가
                    currentWeight += truck_weights[index]; // 다리 무게 갱신
                    index++; // 다음 트럭으로 이동
                } else {
                    bridge.add(0); // 트럭 다리에 못 올라가서 0 추가
                }
            }
        }

        return time;
    }
}


 ```

- for문을 통해 다리를 0으로 설정을 해준다
- while문을 통해 bridge가 값이 있다면 반복을 시켜, 트럭이 다리를 지나가는데 걸리는 소요시간을 1만큼 더해줍니다.
- 조건문을 통해 대기중인 트럭의 무게가 현재 다리의 무게와 더했을 경우 다리가 허용하는 무게보다 낮다면 다리에 트럭을 추가하며,다리의 무게를 최신화 해줍니다.만약 조건을 만족하지 못한다면, 다리에 0을 넣어줍니다.
- ## :black_nib: **Review**

- 오랜만에 알고리즘 문제를 해보았는데, 알고리즘은 해결하였지만 코드로 구현하는것에 시간이 많이 소요되었으며, 결국 시간안에 해결하지 못해 오답노트를 하였습니다.앞으로 꾸준히 알고리즘 해결을 해야겠다고 다짐하게 되는 시간이었습니다.