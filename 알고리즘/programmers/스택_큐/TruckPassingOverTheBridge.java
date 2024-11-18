package 스택_큐;

import java.util.LinkedList;
import java.util.Queue;

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



