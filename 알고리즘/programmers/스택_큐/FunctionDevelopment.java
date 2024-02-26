package 스택_큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class FunctionDevelopment {

    public List<Integer> solution(int[] progresses, int[] speeds) {

        List<Integer> answer = new ArrayList<>();
        Queue<Integer> takeTime = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            takeTime.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        while (!takeTime.isEmpty()) {
            int minDays = takeTime.poll();
            int count = 1;

            while (!takeTime.isEmpty() && takeTime.peek() <= minDays) {
                takeTime.poll();
                count++;
            }
            answer.add(count);
        }

        return answer;
    }
}
